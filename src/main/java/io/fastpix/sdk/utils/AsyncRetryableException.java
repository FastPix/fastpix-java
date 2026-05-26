package io.fastpix.sdk.utils;

import io.fastpix.sdk.utils.Blob;

import java.net.http.HttpResponse;

public final class AsyncRetryableException extends Exception {
    private final HttpResponse<Blob> response;

    public AsyncRetryableException(HttpResponse<Blob> response) {
        this.response = response;
    }

    public HttpResponse<Blob> response() {
        return response;
    }
}
