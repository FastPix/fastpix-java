package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateLiveStreamDomainRestrictionsDefaultPolicy
 * 
 * <p>Specify the fallback behavior for domains that are not listed in the `allow` or `deny` lists.
 */
public enum UpdateLiveStreamDomainRestrictionsDefaultPolicy {
    ALLOW("allow"),
    DENY("deny");

    @JsonValue
    private final String value;

    UpdateLiveStreamDomainRestrictionsDefaultPolicy(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<UpdateLiveStreamDomainRestrictionsDefaultPolicy> fromValue(String value) {
        for (UpdateLiveStreamDomainRestrictionsDefaultPolicy o: UpdateLiveStreamDomainRestrictionsDefaultPolicy.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

