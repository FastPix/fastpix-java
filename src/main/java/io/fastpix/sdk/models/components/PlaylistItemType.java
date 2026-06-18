package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * PlaylistItemType
 *
 * <p>type of the playlist, when it was created
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class PlaylistItemType {

    private static final String MANUAL_VALUE = "manual";
    private static final String SMART_VALUE = "smart";

    public static final PlaylistItemType MANUAL = new PlaylistItemType(MANUAL_VALUE);
    public static final PlaylistItemType SMART = new PlaylistItemType(SMART_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, PlaylistItemType> values = createValuesMap();
    private static final Map<String, PlaylistItemTypeEnum> enums = createEnumsMap();

    private final String value;

    private PlaylistItemType(String value) {
        this.value = value;
    }

    /**
     * Returns a PlaylistItemType with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as PlaylistItemType
     */ 
    @JsonCreator
    public static PlaylistItemType of(String value) {
        synchronized (PlaylistItemType.class) {
            return values.computeIfAbsent(value, PlaylistItemType::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<PlaylistItemTypeEnum> asEnum() {
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
        PlaylistItemType other = (PlaylistItemType) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "PlaylistItemType [value=" + value + "]";
    }

    // return an array just like an enum
    public static PlaylistItemType[] values() {
        synchronized (PlaylistItemType.class) {
            return values.values().toArray(new PlaylistItemType[] {});
        }
    }

    private static final Map<String, PlaylistItemType> createValuesMap() {
        Map<String, PlaylistItemType> map = new LinkedHashMap<>();
        map.put(MANUAL_VALUE, MANUAL);
        map.put(SMART_VALUE, SMART);
        return map;
    }

    private static final Map<String, PlaylistItemTypeEnum> createEnumsMap() {
        Map<String, PlaylistItemTypeEnum> map = new HashMap<>();
        map.put(MANUAL_VALUE, PlaylistItemTypeEnum.MANUAL);
        map.put(SMART_VALUE, PlaylistItemTypeEnum.SMART);
        return map;
    }
    
    
    public enum PlaylistItemTypeEnum {

        MANUAL(MANUAL_VALUE),
        SMART(SMART_VALUE),;

        private final String value;

        private PlaylistItemTypeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

