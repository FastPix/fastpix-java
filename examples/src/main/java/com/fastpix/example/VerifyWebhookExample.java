package com.fastpix.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Verify a FastPix webhook signature before trusting the payload. Runs offline —
 * it self-signs a demo payload and checks it, no API call or real credentials.
 *
 * FastPix signs the raw request body with your webhook Signing Secret (Dashboard
 * > Webhooks) and sends it as a Base64 HMAC-SHA256 in the "FastPix-Signature"
 * header. The Signing Secret is itself Base64-encoded, so sign with its decoded
 * bytes as the key. Verify the body exactly as received: parsing and
 * re-serializing changes the bytes and the signature will never match.
 */
public class VerifyWebhookExample {

    /** Reports whether signature is a valid FastPix-Signature for rawBody. */
    static boolean isValidSignature(byte[] rawBody, String signature, String secret) throws Exception {
        if (secret == null || secret.isEmpty() || signature == null || signature.isEmpty()) {
            return false;
        }
        byte[] key = Base64.getDecoder().decode(secret); // Signing Secret is Base64; use its decoded bytes.
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key, "HmacSHA256"));
        String expected = Base64.getEncoder().encodeToString(mac.doFinal(rawBody));
        // constant-time compare
        return MessageDigest.isEqual(expected.getBytes(StandardCharsets.UTF_8),
                signature.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws Exception {
        String secret = System.getenv("FASTPIX_WEBHOOK_SECRET");
        if (secret == null || secret.isEmpty()) {
            secret = Base64.getEncoder().encodeToString("demo-secret".getBytes(StandardCharsets.UTF_8));
        }

        byte[] rawBody = "{\"type\":\"video.media.ready\",\"data\":{\"id\":\"abc-123\"}}"
                .getBytes(StandardCharsets.UTF_8);

        byte[] key = Base64.getDecoder().decode(secret);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key, "HmacSHA256"));
        String signature = Base64.getEncoder().encodeToString(mac.doFinal(rawBody));

        System.out.println(isValidSignature(rawBody, signature, secret) ? "verified" : "rejected");
    }
}
