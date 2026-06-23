package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * DirectUploadVideoMediaAccessPolicy
 * 
 * <p>Determines if access to the streamed content is kept private, drm or available to all.
 */
public enum DirectUploadVideoMediaAccessPolicy {
    PUBLIC("public"),
    PRIVATE("private"),
    DRM("drm");

    @JsonValue
    private final String value;

    DirectUploadVideoMediaAccessPolicy(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<DirectUploadVideoMediaAccessPolicy> fromValue(String value) {
        for (DirectUploadVideoMediaAccessPolicy o: DirectUploadVideoMediaAccessPolicy.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

