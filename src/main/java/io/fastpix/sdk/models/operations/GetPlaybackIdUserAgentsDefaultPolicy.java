package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetPlaybackIdUserAgentsDefaultPolicy {

    private static final String ALLOW_VALUE = "allow";
    private static final String DENY_VALUE = "deny";

    public static final GetPlaybackIdUserAgentsDefaultPolicy ALLOW = new GetPlaybackIdUserAgentsDefaultPolicy(ALLOW_VALUE);
    public static final GetPlaybackIdUserAgentsDefaultPolicy DENY = new GetPlaybackIdUserAgentsDefaultPolicy(DENY_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetPlaybackIdUserAgentsDefaultPolicy> values = createValuesMap();
    private static final Map<String, GetPlaybackIdUserAgentsDefaultPolicyEnum> enums = createEnumsMap();

    private final String value;

    private GetPlaybackIdUserAgentsDefaultPolicy(String value) {
        this.value = value;
    }

    /**
     * Returns a GetPlaybackIdUserAgentsDefaultPolicy with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetPlaybackIdUserAgentsDefaultPolicy
     */ 
    @JsonCreator
    public static GetPlaybackIdUserAgentsDefaultPolicy of(String value) {
        synchronized (GetPlaybackIdUserAgentsDefaultPolicy.class) {
            return values.computeIfAbsent(value, GetPlaybackIdUserAgentsDefaultPolicy::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetPlaybackIdUserAgentsDefaultPolicyEnum> asEnum() {
        return Optional.ofNullable(enums.getOrDefault(value, null));
    }

    public boolean isKnown() {
        return asEnum().isPresent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GetPlaybackIdUserAgentsDefaultPolicy other = (GetPlaybackIdUserAgentsDefaultPolicy) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetPlaybackIdUserAgentsDefaultPolicy [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetPlaybackIdUserAgentsDefaultPolicy[] values() {
        synchronized (GetPlaybackIdUserAgentsDefaultPolicy.class) {
            return values.values().toArray(new GetPlaybackIdUserAgentsDefaultPolicy[] {});
        }
    }

    private static final Map<String, GetPlaybackIdUserAgentsDefaultPolicy> createValuesMap() {
        Map<String, GetPlaybackIdUserAgentsDefaultPolicy> map = new LinkedHashMap<>();
        map.put(ALLOW_VALUE, ALLOW);
        map.put(DENY_VALUE, DENY);
        return map;
    }

    private static final Map<String, GetPlaybackIdUserAgentsDefaultPolicyEnum> createEnumsMap() {
        Map<String, GetPlaybackIdUserAgentsDefaultPolicyEnum> map = new HashMap<>();
        map.put(ALLOW_VALUE, GetPlaybackIdUserAgentsDefaultPolicyEnum.ALLOW);
        map.put(DENY_VALUE, GetPlaybackIdUserAgentsDefaultPolicyEnum.DENY);
        return map;
    }
    
    
    public enum GetPlaybackIdUserAgentsDefaultPolicyEnum {

        ALLOW(ALLOW_VALUE),
        DENY(DENY_VALUE),;

        private final String value;

        private GetPlaybackIdUserAgentsDefaultPolicyEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

