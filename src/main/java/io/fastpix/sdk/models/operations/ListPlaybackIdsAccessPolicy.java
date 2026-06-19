package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * ListPlaybackIdsAccessPolicy
 *
 * <p>The access policy set for the playback ID.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class ListPlaybackIdsAccessPolicy {

    private static final String PUBLIC_VALUE = "public";
    private static final String PRIVATE_VALUE = "private";
    private static final String DRM_VALUE = "drm";

    public static final ListPlaybackIdsAccessPolicy PUBLIC = new ListPlaybackIdsAccessPolicy(PUBLIC_VALUE);
    public static final ListPlaybackIdsAccessPolicy PRIVATE = new ListPlaybackIdsAccessPolicy(PRIVATE_VALUE);
    public static final ListPlaybackIdsAccessPolicy DRM = new ListPlaybackIdsAccessPolicy(DRM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, ListPlaybackIdsAccessPolicy> values = createValuesMap();
    private static final Map<String, ListPlaybackIdsAccessPolicyEnum> enums = createEnumsMap();

    private final String value;

    private ListPlaybackIdsAccessPolicy(String value) {
        this.value = value;
    }

    /**
     * Returns a ListPlaybackIdsAccessPolicy with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as ListPlaybackIdsAccessPolicy
     */ 
    @JsonCreator
    public static ListPlaybackIdsAccessPolicy of(String value) {
        synchronized (ListPlaybackIdsAccessPolicy.class) {
            return values.computeIfAbsent(value, ListPlaybackIdsAccessPolicy::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<ListPlaybackIdsAccessPolicyEnum> asEnum() {
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
        ListPlaybackIdsAccessPolicy other = (ListPlaybackIdsAccessPolicy) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "ListPlaybackIdsAccessPolicy [value=" + value + "]";
    }

    // return an array just like an enum
    public static ListPlaybackIdsAccessPolicy[] values() {
        synchronized (ListPlaybackIdsAccessPolicy.class) {
            return values.values().toArray(new ListPlaybackIdsAccessPolicy[] {});
        }
    }

    private static final Map<String, ListPlaybackIdsAccessPolicy> createValuesMap() {
        Map<String, ListPlaybackIdsAccessPolicy> map = new LinkedHashMap<>();
        map.put(PUBLIC_VALUE, PUBLIC);
        map.put(PRIVATE_VALUE, PRIVATE);
        map.put(DRM_VALUE, DRM);
        return map;
    }

    private static final Map<String, ListPlaybackIdsAccessPolicyEnum> createEnumsMap() {
        Map<String, ListPlaybackIdsAccessPolicyEnum> map = new HashMap<>();
        map.put(PUBLIC_VALUE, ListPlaybackIdsAccessPolicyEnum.PUBLIC);
        map.put(PRIVATE_VALUE, ListPlaybackIdsAccessPolicyEnum.PRIVATE);
        map.put(DRM_VALUE, ListPlaybackIdsAccessPolicyEnum.DRM);
        return map;
    }
    
    
    public enum ListPlaybackIdsAccessPolicyEnum {

        PUBLIC(PUBLIC_VALUE),
        PRIVATE(PRIVATE_VALUE),
        DRM(DRM_VALUE),;

        private final String value;

        private ListPlaybackIdsAccessPolicyEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

