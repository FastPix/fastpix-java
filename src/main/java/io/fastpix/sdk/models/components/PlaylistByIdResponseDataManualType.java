package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * PlaylistByIdResponseDataManualType
 *
 * <p>type of the playlist, when it was created
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class PlaylistByIdResponseDataManualType {

    private static final String MANUAL_VALUE = "manual";

    public static final PlaylistByIdResponseDataManualType MANUAL = new PlaylistByIdResponseDataManualType(MANUAL_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, PlaylistByIdResponseDataManualType> values = createValuesMap();
    private static final Map<String, PlaylistByIdResponseDataManualTypeEnum> enums = createEnumsMap();

    private final String value;

    private PlaylistByIdResponseDataManualType(String value) {
        this.value = value;
    }

    /**
     * Returns a PlaylistByIdResponseDataManualType with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as PlaylistByIdResponseDataManualType
     */ 
    @JsonCreator
    public static PlaylistByIdResponseDataManualType of(String value) {
        synchronized (PlaylistByIdResponseDataManualType.class) {
            return values.computeIfAbsent(value, PlaylistByIdResponseDataManualType::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<PlaylistByIdResponseDataManualTypeEnum> asEnum() {
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
        PlaylistByIdResponseDataManualType other = (PlaylistByIdResponseDataManualType) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "PlaylistByIdResponseDataManualType [value=" + value + "]";
    }

    // return an array just like an enum
    public static PlaylistByIdResponseDataManualType[] values() {
        synchronized (PlaylistByIdResponseDataManualType.class) {
            return values.values().toArray(new PlaylistByIdResponseDataManualType[] {});
        }
    }

    private static final Map<String, PlaylistByIdResponseDataManualType> createValuesMap() {
        Map<String, PlaylistByIdResponseDataManualType> map = new LinkedHashMap<>();
        map.put(MANUAL_VALUE, MANUAL);
        return map;
    }

    private static final Map<String, PlaylistByIdResponseDataManualTypeEnum> createEnumsMap() {
        Map<String, PlaylistByIdResponseDataManualTypeEnum> map = new HashMap<>();
        map.put(MANUAL_VALUE, PlaylistByIdResponseDataManualTypeEnum.MANUAL);
        return map;
    }
    
    
    public enum PlaylistByIdResponseDataManualTypeEnum {

        MANUAL(MANUAL_VALUE),;

        private final String value;

        private PlaylistByIdResponseDataManualTypeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

