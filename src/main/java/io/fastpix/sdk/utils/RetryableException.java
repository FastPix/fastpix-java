package io.fastpix.sdk.utils;

import java.io.InputStream;
import java.net.http.HttpResponse;

public final class RetryableException extends Exception {
    private final HttpResponse<InputStream> response;

    public RetryableException(HttpResponse<InputStream> response) {
        this.response = response;
    }

    public HttpResponse<InputStream> response() {
        return response;
    }
}
