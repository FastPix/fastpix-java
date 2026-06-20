package io.fastpix.sdk.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class HelpersTest {

    @Test
    void bodyUtf8RoundTripsRequestBody() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .POST(HttpRequest.BodyPublishers.ofString("hello wörld"))
                .build();
        assertEquals("hello wörld", Helpers.bodyUtf8(request));
    }

    @Test
    void bodyBytesReturnsRawBytes() {
        byte[] payload = "payload".getBytes(StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .POST(HttpRequest.BodyPublishers.ofByteArray(payload))
                .build();
        assertArrayEquals(payload, Helpers.bodyBytes(request));
    }

    @Test
    void bodyBytesEmptyWhenNoBody() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .GET()
                .build();
        assertArrayEquals(new byte[] {}, Helpers.bodyBytes(request));
    }
}
