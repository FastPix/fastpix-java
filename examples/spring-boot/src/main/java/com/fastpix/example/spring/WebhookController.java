package com.fastpix.example.spring;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * POST /webhooks — verify the FastPix-Signature over the RAW request body, then
 * react to the event. We ack fast with a 2xx; FastPix retries on non-2xx.
 *
 * This endpoint is safe to leave CSRF-exempt: it's a server-to-server call
 * authenticated by the HMAC signature, not by a browser session cookie. It reads
 * the raw bytes (byte[]) before any parsing — re-serializing the JSON would
 * change the bytes and break the signature.
 */
@RestController
public class WebhookController {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @PostMapping("/webhooks")
    public ResponseEntity<String> handle(
            @RequestBody byte[] rawBody,
            @RequestHeader(value = "FastPix-Signature", required = false) String signature) throws Exception {

        String secret = System.getenv("FASTPIX_WEBHOOK_SECRET");
        if (!isValidSignature(rawBody, signature, secret)) {
            return ResponseEntity.status(401).body("invalid signature");
        }

        // Signature is good — now it's safe to parse and dispatch on the event type.
        JsonNode event = MAPPER.readTree(rawBody);
        String type = event.path("type").asText("");
        switch (type) {
            case "video.media.ready":
                // e.g. mark the media playable in your database
                System.out.println("media ready: " + event.path("data").path("id").asText());
                break;
            case "video.media.failed":
                System.out.println("media failed: " + event.path("data").path("id").asText());
                break;
            default:
                System.out.println("unhandled event: " + type);
        }
        return ResponseEntity.ok("ok");
    }

    /** True if signature is a valid FastPix-Signature for rawBody. */
    static boolean isValidSignature(byte[] rawBody, String signature, String secret) throws Exception {
        if (secret == null || secret.isEmpty() || signature == null || signature.isEmpty()) {
            return false;
        }
        byte[] key = Base64.getDecoder().decode(secret); // Signing Secret is Base64; use its decoded bytes.
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key, "HmacSHA256"));
        String expected = Base64.getEncoder().encodeToString(mac.doFinal(rawBody));
        return MessageDigest.isEqual(expected.getBytes(StandardCharsets.UTF_8),
                signature.getBytes(StandardCharsets.UTF_8));
    }
}
