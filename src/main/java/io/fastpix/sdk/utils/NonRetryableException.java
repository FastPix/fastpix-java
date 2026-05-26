package io.fastpix.sdk.utils;

public final class NonRetryableException extends Exception {
    private final Throwable throwable;

    public NonRetryableException(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
    }

    public Throwable exception() {
        return throwable;
    }
}
