package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * CreateMediaRequestMediaQuality
 * 
 * <p>The quality tier applied to the media.
 */
public enum CreateMediaRequestMediaQuality {
    STANDARD("standard"),
    PRO("pro"),
    PREMIUM("premium");

    @JsonValue
    private final String value;

    CreateMediaRequestMediaQuality(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<CreateMediaRequestMediaQuality> fromValue(String value) {
        for (CreateMediaRequestMediaQuality o: CreateMediaRequestMediaQuality.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

