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
        SpringApplication.run(Application.class, args);
    }
}
