package com.fastpix.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A minimal Spring Boot integration for FastPix. It exposes two endpoints:
 *   POST /uploads   -> mint a signed direct-upload URL (client PUTs the file to it)
 *   POST /webhooks  -> verify the FastPix-Signature and react to events
 *
 * The video bytes never pass through this server — the browser/client uploads
 * straight to the signed URL.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Fail fast with a clean message before Spring boots, rather than deep in a
        // bean-creation stack trace.
        if (System.getenv("FASTPIX_USERNAME") == null || System.getenv("FASTPIX_PASSWORD") == null) {
            System.err.println("Set FASTPIX_USERNAME and FASTPIX_PASSWORD before starting the app (see README.md).");
            System.exit(1);
        }
        SpringApplication.run(Application.class, args);
    }
}
