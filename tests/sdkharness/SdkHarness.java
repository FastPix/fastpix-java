// SdkHarness is invoked as a subprocess by the TypeScript endpoint validators
// (validate-get-endpoints.ts / validate-non-get-endpoints.ts).
//
// It reads a single JSON payload from stdin:
//
//   { "operationId": "...", "request": {...}, "baseUrl": "...",
//     "username": "...", "password": "..." }
//
// dispatches to the matching fastpix-java SDK method, and prints a JSON result
// to stdout following the contract the validators expect:
//
//   success: { "ok": true,  "value": <sdk response body>, "statusCode": <int|null>, "rawBody": <parsed json|string|null> }
//   failure: { "ok": false, "error": { "name": "...", "message": "...", "statusCode": <int>, "bodyJson": <...> } }
//
// The raw wire body is captured via a wrapping HTTP client so the non-GET
// validator can still validate the on-the-wire response against the OpenAPI
// schema (the SDK otherwise consumes the body during deserialization).
//
// This file is hand-written (not generated). It is compiled by the TS harness
// against the built SDK's runtime classpath and run with `java`.
package io.fastpix.sdk.harness;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.models.errors.FastpixException;
import io.fastpix.sdk.utils.FastpixHTTPClient;
import io.fastpix.sdk.utils.HTTPClient;
import io.fastpix.sdk.utils.JSON;

import io.fastpix.sdk.models.operations.OrderBy;
import io.fastpix.sdk.models.operations.ListVideoViewsRequest;
import io.fastpix.sdk.models.operations.ListVideoViewsTimespan;
import io.fastpix.sdk.models.operations.ListByTopContentTimespan;
import io.fastpix.sdk.models.operations.DimensionsId;
import io.fastpix.sdk.models.operations.ListFilterValuesForDimensionTimespan;
import io.fastpix.sdk.models.operations.ListBreakdownValuesRequest;
import io.fastpix.sdk.models.operations.ListBreakdownValuesMetricId;
import io.fastpix.sdk.models.operations.ListBreakdownValuesTimespan;
import io.fastpix.sdk.models.operations.ListOverallValuesMetricId;
import io.fastpix.sdk.models.operations.ListOverallValuesTimespan;
import io.fastpix.sdk.models.operations.GetTimeseriesDataRequest;
import io.fastpix.sdk.models.operations.GetTimeseriesDataMetricId;
import io.fastpix.sdk.models.operations.GetTimeseriesDataTimespan;
import io.fastpix.sdk.models.operations.GroupBy;
import io.fastpix.sdk.models.operations.ListComparisonValuesTimespan;
import io.fastpix.sdk.models.operations.Dimension;
import io.fastpix.sdk.models.operations.ListErrorsTimespan;

public final class SdkHarness {

    private static final ObjectMapper MAPPER = JSON.getMapper();

    public static void main(String[] args) {
        try {
            byte[] raw = readAll(System.in);
            @SuppressWarnings("unchecked")
            Map<String, Object> payload = MAPPER.readValue(raw, Map.class);

            String operationId = asString(payload.get("operationId"));
            @SuppressWarnings("unchecked")
            Map<String, Object> request =
                    payload.get("request") instanceof Map
                            ? (Map<String, Object>) payload.get("request")
                            : new LinkedHashMap<>();
            String baseUrl = asString(payload.get("baseUrl"));
            String username = asString(payload.get("username"));
            String password = asString(payload.get("password"));

            CapturingClient cc = new CapturingClient();
            FastPixSDK.Builder builder = FastPixSDK.builder()
                    .security(Security.builder().username(username).password(password).build())
                    .client(cc);
            if (baseUrl != null && !baseUrl.isBlank()) {
                builder = builder.serverURL(baseUrl);
            }
            FastPixSDK sdk = builder.build();

            Object res;
            try {
                res = Dispatch.invoke(sdk, operationId, request);
            } catch (FastpixException e) {
                emitErr(named(e.getClass()), e.getMessage(), Integer.valueOf(e.code()),
                        e.bodyAsString().orElse(null));
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause() != null ? e.getCause() : e;
                if (cause instanceof FastpixException) {
                    FastpixException fe = (FastpixException) cause;
                    emitErr(named(fe.getClass()), fe.getMessage(), Integer.valueOf(fe.code()),
                            fe.bodyAsString().orElse(null));
                } else {
                    emitErr(named(cause.getClass()), cause.getMessage(),
                            cc.lastStatus != 0 ? Integer.valueOf(cc.lastStatus) : null, null);
                }
                return;
            }

            Object value = extractBody(res);
            Integer status = statusOf(res);
            if (status == null && cc.lastStatus != 0) {
                status = Integer.valueOf(cc.lastStatus);
            }
            emitOK(value, status, cc.parsedRawBody(MAPPER));
        } catch (Throwable t) {
            emitErr(named(t.getClass()), t.getMessage(), null, null);
        }
    }

    // ----------------------------------------------------------------------
    // stdout contract
    // ----------------------------------------------------------------------

    private static void emitOK(Object value, Integer statusCode, Object rawBody) {
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("ok", Boolean.TRUE);
        out.put("value", value == null ? null : MAPPER.valueToTree(value));
        out.put("statusCode", statusCode);
        out.put("rawBody", rawBody);
        print(out);
    }

    private static void emitErr(String name, String message, Integer statusCode, String body) {
        Map<String, Object> err = new LinkedHashMap<>();
        err.put("name", name);
        err.put("message", message == null ? "" : message);
        if (statusCode != null) {
            err.put("statusCode", statusCode);
        }
        if (body != null) {
            try {
                err.put("bodyJson", MAPPER.readTree(body));
            } catch (Exception ignore) {
                err.put("body", body);
            }
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("ok", Boolean.FALSE);
        out.put("error", err);
        print(out);
    }

    private static void print(Map<String, Object> out) {
        try {
            System.out.println(MAPPER.writeValueAsString(out));
        } catch (Exception e) {
            System.out.println("{\"ok\":false,\"error\":{\"name\":\"HarnessEmitError\",\"message\":"
                    + quote(e.getMessage()) + "}}");
        }
    }

    private static String quote(String s) {
        return "\"" + (s == null ? "" : s.replace("\\", "\\\\").replace("\"", "\\\"")) + "\"";
    }

    private static String named(Class<?> c) {
        return c.getSimpleName().isEmpty() ? c.getName() : c.getSimpleName();
    }

    // ----------------------------------------------------------------------
    // response-body extraction (reflection): find the single populated Optional
    // body accessor on the SDK response wrapper, skipping `defaultError`.
    // ----------------------------------------------------------------------

    private static Object extractBody(Object res) {
        if (res == null) {
            return null;
        }
        for (Method m : res.getClass().getDeclaredMethods()) {
            if (m.getParameterCount() != 0) {
                continue;
            }
            if (!Optional.class.equals(m.getReturnType())) {
                continue;
            }
            if (m.getName().equals("defaultError")) {
                continue;
            }
            try {
                m.setAccessible(true);
                Object opt = m.invoke(res);
                if (opt instanceof Optional && ((Optional<?>) opt).isPresent()) {
                    return ((Optional<?>) opt).get();
                }
            } catch (Exception ignore) {
                // try the next accessor
            }
        }
        return res;
    }

    private static Integer statusOf(Object res) {
        try {
            Method m = res.getClass().getMethod("statusCode");
            Object v = m.invoke(res);
            if (v instanceof Integer) {
                return (Integer) v;
            }
        } catch (Exception ignore) {
            // not all responses expose statusCode()
        }
        return null;
    }

    // ----------------------------------------------------------------------
    // capturing HTTP client — retains the last response's status + raw body so
    // the non-GET validator can compare against the real wire JSON.
    // ----------------------------------------------------------------------

    static final class CapturingClient implements HTTPClient {
        private final HTTPClient inner = new FastpixHTTPClient();
        volatile int lastStatus = 0;
        private volatile byte[] lastBody = null;

        @Override
        public HttpResponse<InputStream> send(HttpRequest request)
                throws IOException, InterruptedException, java.net.URISyntaxException {
            HttpResponse<InputStream> resp = inner.send(request);
            lastStatus = resp.statusCode();
            byte[] body = resp.body() != null ? readAll(resp.body()) : new byte[0];
            lastBody = body;
            return new BufferedResponse(resp, body);
        }

        Object parsedRawBody(ObjectMapper mapper) {
            if (lastBody == null || lastBody.length == 0) {
                return null;
            }
            try {
                return mapper.readTree(lastBody);
            } catch (Exception e) {
                return new String(lastBody, java.nio.charset.StandardCharsets.UTF_8);
            }
        }
    }

    // Re-supplies the consumed body as a fresh InputStream; delegates the rest.
    static final class BufferedResponse implements HttpResponse<InputStream> {
        private final HttpResponse<InputStream> delegate;
        private final byte[] body;

        BufferedResponse(HttpResponse<InputStream> delegate, byte[] body) {
            this.delegate = delegate;
            this.body = body;
        }

        @Override public int statusCode() { return delegate.statusCode(); }
        @Override public HttpRequest request() { return delegate.request(); }
        @Override public Optional<HttpResponse<InputStream>> previousResponse() { return Optional.empty(); }
        @Override public java.net.http.HttpHeaders headers() { return delegate.headers(); }
        @Override public InputStream body() { return new ByteArrayInputStream(body); }
        @Override public Optional<javax.net.ssl.SSLSession> sslSession() { return delegate.sslSession(); }
        @Override public java.net.URI uri() { return delegate.uri(); }
        @Override public java.net.http.HttpClient.Version version() { return delegate.version(); }
    }

    // ----------------------------------------------------------------------
    // helpers
    // ----------------------------------------------------------------------

    static String asString(Object o) {
        return o == null ? null : String.valueOf(o);
    }

    static byte[] readAll(InputStream in) throws IOException {
        return in.readAllBytes();
    }

    // request-map accessors used by Dispatch
    static String str(Map<String, Object> req, String key) {
        Object v = req.get(key);
        return v == null ? null : String.valueOf(v);
    }

    static Long lng(Map<String, Object> req, String key) {
        Object v = req.get(key);
        if (v == null) {
            return null;
        }
        if (v instanceof Number) {
            return Long.valueOf(((Number) v).longValue());
        }
        try {
            return Long.valueOf(String.valueOf(v));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static SortOrder sortOrder(Map<String, Object> req) {
        String v = str(req, "orderBy");
        if (v == null) {
            return null;
        }
        return "desc".equalsIgnoreCase(v) ? SortOrder.DESC : SortOrder.ASC;
    }

    static OrderBy opOrderBy(Map<String, Object> req) {
        String v = str(req, "orderBy");
        if (v == null) {
            return null;
        }
        return "desc".equalsIgnoreCase(v) ? OrderBy.DESC : OrderBy.ASC;
    }
}
