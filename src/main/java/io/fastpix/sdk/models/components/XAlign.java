/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * XAlign
 * 
 * <p>Horizontal alignment of the watermark.
 */
public enum XAlign {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right");

    @JsonValue
    private final String value;

    private XAlign(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<XAlign> fromValue(String value) {
        for (XAlign o: XAlign.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

