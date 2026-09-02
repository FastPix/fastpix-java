package io.fastpix.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpServer;

import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.APIException;
import io.fastpix.sdk.models.errors.FastpixException;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsResponse;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.utils.JSON;

/** Drives the live playback restriction operations against a local HTTP server and checks the wire request. */
class LivePlaybackRestrictionsTest {

    private static final String OK = "{\"success\":true,\"data\":{\"defaultPolicy\":\"allow\",\"allow\":[\"yourdomain.com\"],\"deny\":[]}}";

    private HttpServer server;
    private FastPixSDK sdk;
    private volatile String method;
    private volatile String path;
    private volatile String contentType;
    private volatile String body;
    private volatile int status = 200;

    @BeforeEach
    void start() throws Exception {
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/", exchange -> {
            method = exchange.getRequestMethod();
            path = exchange.getRequestURI().getPath();
            contentType = exchange.getRequestHeaders().getFirst("Content-Type");
            body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            byte[] out = OK.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(status, out.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(out);
            }
        });
        server.start();
        sdk = FastPixSDK.builder()
                .serverURL("http://localhost:" + server.getAddress().getPort() + "/v1/")
                .security(Security.builder().username("user").password("pass").build())
                .build();
    }

    @AfterEach
    void stop() {
        server.stop(0);
    }

    @Test
    void updateDomainRestrictionsSendsFlatPatch() throws Exception {
        UpdateLiveStreamDomainRestrictionsResponse res = sdk.livePlayback().updateDomainRestrictions("s1", "p1",
                UpdateLiveStreamDomainRestrictionsRequestBody.builder()
                        .allow(List.of("yourdomain.com")).deny(List.of("malicioussite.io")).build());

        assertEquals("PATCH", method);
        assertEquals("/v1/live/streams/s1/playback-ids/p1/domains", path);
        assertTrue(contentType.startsWith("application/json"));
        JsonNode sent = JSON.getMapper().readTree(body);
        assertEquals(JSON.getMapper().readTree("{\"defaultPolicy\":\"allow\",\"allow\":[\"yourdomain.com\"],\"deny\":[\"malicioussite.io\"]}"), sent);
        assertEquals(Optional.of(List.of("yourdomain.com")), res.object().get().data().get().allow());
    }

    @Test
    void updateUserAgentRestrictionsSendsFlatPatchAsync() throws Exception {
        var res = sdk.livePlayback().async().updateUserAgentRestrictions("s1", "p1",
                UpdateLiveStreamUserAgentRestrictionsRequestBody.builder()
                        .defaultPolicy(io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsDefaultPolicy.DENY)
                        .allow(List.of("PostmanRuntime/7.29.0")).build()).get();

        assertEquals("PATCH", method);
        assertEquals("/v1/live/streams/s1/playback-ids/p1/user-agents", path);
        assertEquals(JSON.getMapper().readTree("{\"defaultPolicy\":\"deny\",\"allow\":[\"PostmanRuntime/7.29.0\"]}"),
                JSON.getMapper().readTree(body));
        assertEquals(Optional.of(true), res.object().get().success());
    }

    @Test
    void apiErrorSurfacesAsApiException() {
        status = 403;
        assertThrows(APIException.class, () -> sdk.livePlayback().updateDomainRestrictions("s1", "p1",
                UpdateLiveStreamDomainRestrictionsRequestBody.builder().build()));
        ExecutionException async = assertThrows(ExecutionException.class, () -> sdk.livePlayback().async()
                .updateUserAgentRestrictions("s1", "p1", UpdateLiveStreamUserAgentRestrictionsRequestBody.builder().build()).get());
        assertTrue(async.getCause() instanceof FastpixException);
    }
}
