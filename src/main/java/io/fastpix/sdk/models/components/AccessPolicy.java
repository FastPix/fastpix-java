package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * AccessPolicy
 * 
 * <p>Access policy for media content
 */
public class AccessPolicy {

    private static final String VALUE_PUBLIC = "public";
    private static final String VALUE_PRIVATE = "private";
    private static final String VALUE_DRM = "drm";

    public static final AccessPolicy PUBLIC = new AccessPolicy(VALUE_PUBLIC);
    public static final AccessPolicy PRIVATE = new AccessPolicy(VALUE_PRIVATE);
    public static final AccessPolicy DRM = new AccessPolicy(VALUE_DRM);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, AccessPolicy> values = createValuesMap();
    private static final Map<String, AccessPolicyEnum> enums = createEnumsMap();

    private final String value;

    private AccessPolicy(String value) {
        this.value = value;
    }

    /**
     * Returns a AccessPolicy with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as AccessPolicy
     */ 
    @JsonCreator
    public static AccessPolicy of(String value) {
        synchronized (AccessPolicy.class) {
            return values.computeIfAbsent(value, AccessPolicy::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<AccessPolicyEnum> asEnum() {
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
        AccessPolicy other = (AccessPolicy) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "AccessPolicy [value=" + value + "]";
    }

    // return an array just like an enum
    public static AccessPolicy[] values() {
        synchronized (AccessPolicy.class) {
            return values.values().toArray(new AccessPolicy[] {});
        }
    }

    private static final Map<String, AccessPolicy> createValuesMap() {
        Map<String, AccessPolicy> map = new LinkedHashMap<>();
        map.put(VALUE_PUBLIC, PUBLIC);
        map.put(VALUE_PRIVATE, PRIVATE);
        map.put(VALUE_DRM, DRM);
        return map;
    }

    private static final Map<String, AccessPolicyEnum> createEnumsMap() {
        Map<String, AccessPolicyEnum> map = new HashMap<>();
        map.put(VALUE_PUBLIC, AccessPolicyEnum.PUBLIC);
        map.put(VALUE_PRIVATE, AccessPolicyEnum.PRIVATE);
        map.put(VALUE_DRM, AccessPolicyEnum.DRM);
        return map;
    }
    
    
    public enum AccessPolicyEnum {

        PUBLIC(VALUE_PUBLIC),
        PRIVATE(VALUE_PRIVATE),
        DRM(VALUE_DRM),;

        private final String value;

        private AccessPolicyEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

