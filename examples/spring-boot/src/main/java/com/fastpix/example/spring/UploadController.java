package com.fastpix.example.spring;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.DirectUpload;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaAccessPolicy;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaRequest;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaResponse;
import io.fastpix.sdk.models.operations.PushMediaSettings;

/**
 * POST /uploads — mint a signed direct-upload URL. The client then PUTs the
 * file straight to the returned url; it never passes through this server.
 *
 * In production, put this behind your own auth — anyone who can call it can
 * create uploads on your account. corsOrigin "*" lets a browser PUT from any
 * origin; tighten it to your own domain before you ship.
 */
@RestController
public class UploadController {

    private final FastPixSDK sdk;

    public UploadController(FastPixSDK sdk) {
        this.sdk = sdk;
    }

    @PostMapping("/uploads")
    public Map<String, String> createUpload() throws Exception {
        DirectUploadVideoMediaResponse res = sdk.inputVideos().upload()
                .request(DirectUploadVideoMediaRequest.builder()
                        .corsOrigin("*")
                        .pushMediaSettings(PushMediaSettings.builder()
                                .accessPolicy(DirectUploadVideoMediaAccessPolicy.PUBLIC)
                                .build())
                        .build())
                .call();

        DirectUpload upload = res.object().get().data();
        return Map.of(
                "uploadId", upload.uploadId().orElseThrow(),
                "url", upload.url().orElseThrow());
    }
}
