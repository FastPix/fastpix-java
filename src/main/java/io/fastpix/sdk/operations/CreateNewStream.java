package io.fastpix.sdk.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;
import static io.fastpix.sdk.utils.Exceptions.unchecked;
import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.SecuritySource;
import io.fastpix.sdk.models.components.CreateLiveStreamRequest;
import io.fastpix.sdk.models.components.DefaultError;
import io.fastpix.sdk.models.components.LiveStreamResponseDTO;
import io.fastpix.sdk.models.errors.APIException;
import io.fastpix.sdk.models.operations.CreateNewStreamResponse;
import io.fastpix.sdk.utils.AsyncRetries;
import io.fastpix.sdk.utils.BackoffStrategy;
import io.fastpix.sdk.utils.Blob;
import io.fastpix.sdk.utils.HTTPClient;
import io.fastpix.sdk.utils.HTTPRequest;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Hook.AfterErrorContextImpl;
import io.fastpix.sdk.utils.Hook.AfterSuccessContextImpl;
import io.fastpix.sdk.utils.Hook.BeforeRequestContextImpl;
import io.fastpix.sdk.utils.NonRetryableException;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.Retries;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.SerializedBody;
import io.fastpix.sdk.utils.Utils.JsonShape;
import io.fastpix.sdk.utils.Utils;


// Generated operation class with intentional naming conventions from the SDK generator that this
// project preserves: the header fields and parameters keep a leading-underscore style, and accessor
// methods reuse their backing field name. Reformatting them would diverge from the generated output.
@SuppressWarnings({"java:S116", "java:S117", "java:S1845", "java:S2142"})
public class CreateNewStream {

    private static final String OPERATION_ID = "create-new-stream";
    private static final String APPLICATION_JSON = "application/json";
    private static final String STATUS_4XX = "4XX";
    private static final String STATUS_5XX = "5XX";
    private static final String UNEXPECTED_CONTENT_TYPE_PREFIX = "Unexpected content-type received: ";
    private static final String API_ERROR_OCCURRED = "API error occurred";

    private CreateNewStream() {
        // utility holder for the Base/Sync/Async request operations
    }

    abstract static class Base {
        final SDKConfiguration sdkConfiguration;
        final String baseUrl;
        final SecuritySource securitySource;
        final List<String> retryStatusCodes;
        final RetryConfig retryConfig;
        final HTTPClient client;
        final Headers _headers;

        protected Base(
                @Nonnull SDKConfiguration sdkConfiguration, @Nullable Options options,
                Headers _headers) {
            this.sdkConfiguration = sdkConfiguration;
            this._headers =_headers;
            this.baseUrl = this.sdkConfiguration.serverUrl();
            this.securitySource = this.sdkConfiguration.securitySource();
            Optional.ofNullable(options)
                    .ifPresent(o -> o.validate(List.of(Options.Option.RETRY_CONFIG)));
            this.retryStatusCodes = List.of("408", "429", "500", "502", "503", "504");
            this.retryConfig = Optional.ofNullable(options)
                    .flatMap(Options::retryConfig)
                    .or(sdkConfiguration::retryConfig)
                    .orElse(RetryConfig.builder().backoff(BackoffStrategy.builder()
                                    .initialInterval(1000, TimeUnit.MILLISECONDS)
                                    .maxInterval(10000, TimeUnit.MILLISECONDS)
                                    .baseFactor(1.5)
                                    .maxElapsedTime(3600000, TimeUnit.MILLISECONDS)
                                    .retryConnectError(true)
                                    .build())
                            .build());
            this.client = this.sdkConfiguration.client();
        }

        Optional<SecuritySource> securitySource() {
            return Optional.ofNullable(this.securitySource);
        }

        BeforeRequestContextImpl createBeforeRequestContext() {
            return new BeforeRequestContextImpl(
                    this.sdkConfiguration,
                    this.baseUrl,
                    OPERATION_ID,
                    java.util.Optional.empty(),
                    securitySource());
        }

        AfterSuccessContextImpl createAfterSuccessContext() {
            return new AfterSuccessContextImpl(
                    this.sdkConfiguration,
                    this.baseUrl,
                    OPERATION_ID,
                    java.util.Optional.empty(),
                    securitySource());
        }

        AfterErrorContextImpl createAfterErrorContext() {
            return new AfterErrorContextImpl(
                    this.sdkConfiguration,
                    this.baseUrl,
                    OPERATION_ID,
                    java.util.Optional.empty(),
                    securitySource());
        }
        <T, U>HttpRequest buildRequest(T request, TypeReference<U> typeReference) throws Exception {
            String url = Utils.generateURL(
                    this.baseUrl,
                    "/live/streams");
            HTTPRequest req = new HTTPRequest(url, "POST");
            Object convertedRequest = Utils.convertToShape(
                    request,
                    JsonShape.DEFAULT,
                    typeReference);
            SerializedBody serializedRequestBody = Utils.serializeRequestBody(
                    convertedRequest,
                    "request",
                    "json",
                    false);
            if (serializedRequestBody == null) {
                throw new IllegalArgumentException("Request body is required");
            }
            req.setBody(Optional.ofNullable(serializedRequestBody));
            req.addHeader("Accept", APPLICATION_JSON)
                    .addHeader("user-agent", SDKConfiguration.USER_AGENT);
            _headers.forEach((k, list) -> list.forEach(v -> req.addHeader(k, v)));
            Utils.configureSecurity(req, this.sdkConfiguration.securitySource().getSecurity());

            return req.build();
        }
    }

    public static class Sync extends Base
            implements RequestOperation<CreateLiveStreamRequest, CreateNewStreamResponse> {
        public Sync(
                @Nonnull SDKConfiguration sdkConfiguration, @Nullable Options options,
                Headers _headers) {
            super(
                  sdkConfiguration, options,
                  _headers);
        }

        private HttpRequest onBuildRequest(CreateLiveStreamRequest request) throws Exception {
            HttpRequest req = buildRequest(request, new TypeReference<CreateLiveStreamRequest>() {});
            return sdkConfiguration.hooks().beforeRequest(createBeforeRequestContext(), req);
        }

        private HttpResponse<InputStream> onError(HttpResponse<InputStream> response, Exception error) throws Exception {
            return sdkConfiguration.hooks().afterError(
                    createAfterErrorContext(),
                    Optional.ofNullable(response),
                    Optional.ofNullable(error));
        }

        private HttpResponse<InputStream> onSuccess(HttpResponse<InputStream> response) throws Exception {
            return sdkConfiguration.hooks().afterSuccess(createAfterSuccessContext(), response);
        }

        @Override
        public HttpResponse<InputStream> doRequest(CreateLiveStreamRequest request) {
            Retries retries = Retries.builder()
                    .action(() -> {
                        HttpRequest r;
                        try {
                            r = onBuildRequest(request);
                        } catch (Exception e) {
                            throw new NonRetryableException(e);
                        }
                        try {
                            HttpResponse<InputStream> httpRes = client.send(r);
                            if (Utils.statusCodeMatches(httpRes.statusCode(), STATUS_4XX, STATUS_5XX)) {
                                return onError(httpRes, null);
                            }
                            return httpRes;
                        } catch (Exception e) {
                            return onError(null, e);
                        }
                    })
                    .retryConfig(retryConfig)
                    .statusCodes(retryStatusCodes)
                    .build();
            return unchecked(() -> onSuccess(retries.run())).get();
        }


        @Override
        public CreateNewStreamResponse handleResponse(HttpResponse<InputStream> response) {
            String contentType = response
                    .headers()
                    .firstValue("Content-Type")
                    .orElse("application/octet-stream");
            CreateNewStreamResponse.Builder resBuilder =
                    CreateNewStreamResponse
                            .builder()
                            .contentType(contentType)
                            .statusCode(response.statusCode())
                            .rawResponse(response);

            CreateNewStreamResponse res = resBuilder.build();
            
            if (Utils.statusCodeMatches(response.statusCode(), "201")) {
                if (Utils.contentTypeMatches(contentType, APPLICATION_JSON)) {
                    return res.withLiveStreamResponseDTO(Utils.unmarshal(response, new TypeReference<LiveStreamResponseDTO>() {}));
                } else {
                    throw APIException.from(UNEXPECTED_CONTENT_TYPE_PREFIX + contentType, response);
                }
            }
            if (Utils.statusCodeMatches(response.statusCode(), STATUS_4XX)) {
                // no content
                throw APIException.from(API_ERROR_OCCURRED, response);
            }
            if (Utils.statusCodeMatches(response.statusCode(), STATUS_5XX)) {
                // no content
                throw APIException.from(API_ERROR_OCCURRED, response);
            }
            if (Utils.statusCodeMatches(response.statusCode(), "default")) {
                if (Utils.contentTypeMatches(contentType, APPLICATION_JSON)) {
                    return res.withDefaultError(Utils.unmarshal(response, new TypeReference<DefaultError>() {}));
                } else {
                    throw APIException.from(UNEXPECTED_CONTENT_TYPE_PREFIX + contentType, response);
                }
            }
            throw APIException.from("Unexpected status code received: " + response.statusCode(), response);
        }
    }
    public static class Async extends Base
            implements AsyncRequestOperation<CreateLiveStreamRequest, io.fastpix.sdk.models.operations.async.CreateNewStreamResponse> {
        private final ScheduledExecutorService retryScheduler;

        public Async(
                @Nonnull SDKConfiguration sdkConfiguration, @Nullable Options options,
                @Nullable ScheduledExecutorService retryScheduler, Headers _headers) {
            super(
                  sdkConfiguration, options,
                  _headers);
            this.retryScheduler = retryScheduler;
        }

        private CompletableFuture<HttpRequest> onBuildRequest(CreateLiveStreamRequest request) throws Exception {
            HttpRequest req = buildRequest(request, new TypeReference<CreateLiveStreamRequest>() {});
            return this.sdkConfiguration.asyncHooks().beforeRequest(createBeforeRequestContext(), req);
        }

        private CompletableFuture<HttpResponse<Blob>> onError(HttpResponse<Blob> response, Throwable error) {
            return this.sdkConfiguration.asyncHooks().afterError(createAfterErrorContext(), response, error);
        }

        private CompletableFuture<HttpResponse<Blob>> onSuccess(HttpResponse<Blob> response) {
            return this.sdkConfiguration.asyncHooks().afterSuccess(createAfterSuccessContext(), response);
        }

        @Override
        public CompletableFuture<HttpResponse<Blob>> doRequest(CreateLiveStreamRequest request) {
            AsyncRetries retries = AsyncRetries.builder()
                    .retryConfig(retryConfig)
                    .statusCodes(retryStatusCodes)
                    .scheduler(retryScheduler)
                    .build();
            return retries.retry(() -> unchecked(() -> onBuildRequest(request)).get().thenCompose(client::sendAsync)
                            .handle((resp, err) -> {
                                if (err != null) {
                                    return onError(null, err);
                                }
                                if (Utils.statusCodeMatches(resp.statusCode(), STATUS_4XX, STATUS_5XX)) {
                                    return onError(resp, null);
                                }
                                return CompletableFuture.completedFuture(resp);
                            })
                            .thenCompose(Function.identity()))
                    .thenCompose(this::onSuccess);
        }

        @Override
        public CompletableFuture<io.fastpix.sdk.models.operations.async.CreateNewStreamResponse> handleResponse(
                HttpResponse<Blob> response) {
            String contentType = response
                    .headers()
                    .firstValue("Content-Type")
                    .orElse("application/octet-stream");
            io.fastpix.sdk.models.operations.async.CreateNewStreamResponse.Builder resBuilder =
                    io.fastpix.sdk.models.operations.async.CreateNewStreamResponse
                            .builder()
                            .contentType(contentType)
                            .statusCode(response.statusCode())
                            .rawResponse(response);

            io.fastpix.sdk.models.operations.async.CreateNewStreamResponse res = resBuilder.build();
            
            if (Utils.statusCodeMatches(response.statusCode(), "201")) {
                if (Utils.contentTypeMatches(contentType, APPLICATION_JSON)) {
                    return Utils.unmarshalAsync(response, new TypeReference<LiveStreamResponseDTO>() {})
                            .thenApply(res::withLiveStreamResponseDTO);
                } else {
                    return Utils.createAsyncApiError(response, UNEXPECTED_CONTENT_TYPE_PREFIX + contentType);
                }
            }
            if (Utils.statusCodeMatches(response.statusCode(), STATUS_4XX)) {
                // no content
                return Utils.createAsyncApiError(response, API_ERROR_OCCURRED);
            }
            if (Utils.statusCodeMatches(response.statusCode(), STATUS_5XX)) {
                // no content
                return Utils.createAsyncApiError(response, API_ERROR_OCCURRED);
            }
            if (Utils.statusCodeMatches(response.statusCode(), "default")) {
                if (Utils.contentTypeMatches(contentType, APPLICATION_JSON)) {
                    return Utils.unmarshalAsync(response, new TypeReference<DefaultError>() {})
                            .thenApply(res::withDefaultError);
                } else {
                    return Utils.createAsyncApiError(response, UNEXPECTED_CONTENT_TYPE_PREFIX + contentType);
                }
            }
            return Utils.createAsyncApiError(response, "Unexpected status code received: " + response.statusCode());
        }
    }
}
