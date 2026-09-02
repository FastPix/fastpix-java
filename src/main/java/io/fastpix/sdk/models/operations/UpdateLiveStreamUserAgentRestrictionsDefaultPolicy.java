package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateLiveStreamUserAgentRestrictionsDefaultPolicy
 * 
 * <p>The default behavior when a user-agent is not listed in `allow` or `deny`.
 */
public enum UpdateLiveStreamUserAgentRestrictionsDefaultPolicy {
    ALLOW("allow"),
    DENY("deny");

    @JsonValue
    private final String value;

    UpdateLiveStreamUserAgentRestrictionsDefaultPolicy(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<UpdateLiveStreamUserAgentRestrictionsDefaultPolicy> fromValue(String value) {
        for (UpdateLiveStreamUserAgentRestrictionsDefaultPolicy o: UpdateLiveStreamUserAgentRestrictionsDefaultPolicy.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

