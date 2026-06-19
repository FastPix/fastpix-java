package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * Type
 * 
 * <p>Defines the type of input. Possible values include video, audio, av.
 */
public enum Type {
    VIDEO("video"),
    AUDIO("audio"),
    AV("av");

    @JsonValue
    private final String value;

    Type(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<Type> fromValue(String value) {
        for (Type o: Type.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

