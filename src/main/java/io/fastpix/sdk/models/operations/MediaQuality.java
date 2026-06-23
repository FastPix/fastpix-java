package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaQuality
 * 
 * <p>The quality tier applied to the media.
 */
public enum MediaQuality {
    STANDARD("standard"),
    PRO("pro"),
    PREMIUM("premium");

    @JsonValue
    private final String value;

    MediaQuality(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<MediaQuality> fromValue(String value) {
        for (MediaQuality o: MediaQuality.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

