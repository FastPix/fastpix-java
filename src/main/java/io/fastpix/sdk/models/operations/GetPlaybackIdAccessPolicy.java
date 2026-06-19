package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetPlaybackIdAccessPolicy
 *
 * <p>The access policy set for the playback ID.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetPlaybackIdAccessPolicy {

    private static final String PUBLIC_VALUE = "public";
    private static final String PRIVATE_VALUE = "private";
    private static final String DRM_VALUE = "drm";

    public static final GetPlaybackIdAccessPolicy PUBLIC = new GetPlaybackIdAccessPolicy(PUBLIC_VALUE);
    public static final GetPlaybackIdAccessPolicy PRIVATE = new GetPlaybackIdAccessPolicy(PRIVATE_VALUE);
    public static final GetPlaybackIdAccessPolicy DRM = new GetPlaybackIdAccessPolicy(DRM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetPlaybackIdAccessPolicy> values = createValuesMap();
    private static final Map<String, GetPlaybackIdAccessPolicyEnum> enums = createEnumsMap();

    private final String value;

    private GetPlaybackIdAccessPolicy(String value) {
        this.value = value;
    }

    /**
     * Returns a GetPlaybackIdAccessPolicy with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetPlaybackIdAccessPolicy
     */ 
    @JsonCreator
    public static GetPlaybackIdAccessPolicy of(String value) {
        synchronized (GetPlaybackIdAccessPolicy.class) {
            return values.computeIfAbsent(value, GetPlaybackIdAccessPolicy::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetPlaybackIdAccessPolicyEnum> asEnum() {
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
        GetPlaybackIdAccessPolicy other = (GetPlaybackIdAccessPolicy) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetPlaybackIdAccessPolicy [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetPlaybackIdAccessPolicy[] values() {
        synchronized (GetPlaybackIdAccessPolicy.class) {
            return values.values().toArray(new GetPlaybackIdAccessPolicy[] {});
        }
    }

    private static final Map<String, GetPlaybackIdAccessPolicy> createValuesMap() {
        Map<String, GetPlaybackIdAccessPolicy> map = new LinkedHashMap<>();
        map.put(PUBLIC_VALUE, PUBLIC);
        map.put(PRIVATE_VALUE, PRIVATE);
        map.put(DRM_VALUE, DRM);
        return map;
    }

    private static final Map<String, GetPlaybackIdAccessPolicyEnum> createEnumsMap() {
        Map<String, GetPlaybackIdAccessPolicyEnum> map = new HashMap<>();
        map.put(PUBLIC_VALUE, GetPlaybackIdAccessPolicyEnum.PUBLIC);
        map.put(PRIVATE_VALUE, GetPlaybackIdAccessPolicyEnum.PRIVATE);
        map.put(DRM_VALUE, GetPlaybackIdAccessPolicyEnum.DRM);
        return map;
    }
    
    
    public enum GetPlaybackIdAccessPolicyEnum {

        PUBLIC(PUBLIC_VALUE),
        PRIVATE(PRIVATE_VALUE),
        DRM(DRM_VALUE),;

        private final String value;

        private GetPlaybackIdAccessPolicyEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

