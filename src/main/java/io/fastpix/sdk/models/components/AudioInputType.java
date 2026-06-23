package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * AudioInputType
 * 
 * <p>Type of overlay (currently only supports "audio").
 */
public enum AudioInputType {
    AUDIO("audio");

    @JsonValue
    private final String value;

    AudioInputType(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<AudioInputType> fromValue(String value) {
        for (AudioInputType o: AudioInputType.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

