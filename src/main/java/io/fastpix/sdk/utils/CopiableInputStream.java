package io.fastpix.sdk.utils;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class CopiableInputStream {
    private final byte[] bytes;

    public CopiableInputStream(InputStream original) {
        try (InputStream stream = original) {
            this.bytes = IOUtils.toByteArray(stream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public InputStream copy() {
        return new ByteArrayInputStream(bytes);
    }
}
