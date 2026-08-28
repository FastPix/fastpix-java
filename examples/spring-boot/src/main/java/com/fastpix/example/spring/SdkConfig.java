package com.fastpix.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;

/**
 * Wires a single FastPixSDK bean from environment credentials.
 *
 * FastPix also ships a Spring Boot starter (io.fastpix:sdk-spring-boot-starter)
 * that auto-configures this bean from `openapi.security.*` properties. Once that
 * artifact is available to you, you can delete this class and depend on the
 * starter instead.
 */
@Configuration
public class SdkConfig {

    @Bean
    FastPixSDK fastPixSdk() {
        return FastPixSDK.builder()
                .security(Security.builder()
                        .username(System.getenv("FASTPIX_USERNAME"))
                        .password(System.getenv("FASTPIX_PASSWORD"))
                        .build())
                .build();
    }
}
