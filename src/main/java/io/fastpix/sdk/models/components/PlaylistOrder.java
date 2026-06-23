package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * PlaylistOrder
 *
 * <p>Determines the insertion order of media into playlist.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class PlaylistOrder {

    private static final String CREATED_DATE_ASC_VALUE = "createdDate ASC";
    private static final String CREATED_DATE_DESC_VALUE = "createdDate DESC";

    public static final PlaylistOrder CREATED_DATE_ASC = new PlaylistOrder(CREATED_DATE_ASC_VALUE);
    public static final PlaylistOrder CREATED_DATE_DESC = new PlaylistOrder(CREATED_DATE_DESC_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, PlaylistOrder> values = createValuesMap();
    private static final Map<String, PlaylistOrderEnum> enums = createEnumsMap();

    private final String value;

    private PlaylistOrder(String value) {
        this.value = value;
    }

    /**
     * Returns a PlaylistOrder with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as PlaylistOrder
     */ 
    @JsonCreator
    public static PlaylistOrder of(String value) {
        synchronized (PlaylistOrder.class) {
            return values.computeIfAbsent(value, PlaylistOrder::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<PlaylistOrderEnum> asEnum() {
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
        PlaylistOrder other = (PlaylistOrder) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "PlaylistOrder [value=" + value + "]";
    }

    // return an array just like an enum
    public static PlaylistOrder[] values() {
        synchronized (PlaylistOrder.class) {
            return values.values().toArray(new PlaylistOrder[] {});
        }
    }

    private static final Map<String, PlaylistOrder> createValuesMap() {
        Map<String, PlaylistOrder> map = new LinkedHashMap<>();
        map.put(CREATED_DATE_ASC_VALUE, CREATED_DATE_ASC);
        map.put(CREATED_DATE_DESC_VALUE, CREATED_DATE_DESC);
        return map;
    }

    private static final Map<String, PlaylistOrderEnum> createEnumsMap() {
        Map<String, PlaylistOrderEnum> map = new HashMap<>();
        map.put(CREATED_DATE_ASC_VALUE, PlaylistOrderEnum.CREATED_DATE_ASC);
        map.put(CREATED_DATE_DESC_VALUE, PlaylistOrderEnum.CREATED_DATE_DESC);
        return map;
    }
    
    
    public enum PlaylistOrderEnum {

        CREATED_DATE_ASC(CREATED_DATE_ASC_VALUE),
        CREATED_DATE_DESC(CREATED_DATE_DESC_VALUE),;

        private final String value;

        private PlaylistOrderEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

