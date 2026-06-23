package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * PlaylistByIdResponseDataSmartType
 *
 * <p>type of the playlist, when it was created
 */
public class PlaylistByIdResponseDataSmartType {

    private static final String VALUE_SMART = "smart";

    public static final PlaylistByIdResponseDataSmartType SMART = new PlaylistByIdResponseDataSmartType(VALUE_SMART);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, PlaylistByIdResponseDataSmartType> values = createValuesMap();
    private static final Map<String, PlaylistByIdResponseDataSmartTypeEnum> enums = createEnumsMap();

    private final String value;

    private PlaylistByIdResponseDataSmartType(String value) {
        this.value = value;
    }

    /**
     * Returns a PlaylistByIdResponseDataSmartType with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as PlaylistByIdResponseDataSmartType
     */
    @JsonCreator
    public static PlaylistByIdResponseDataSmartType of(String value) {
        synchronized (PlaylistByIdResponseDataSmartType.class) {
            return values.computeIfAbsent(value, PlaylistByIdResponseDataSmartType::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<PlaylistByIdResponseDataSmartTypeEnum> asEnum() {
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
        PlaylistByIdResponseDataSmartType other = (PlaylistByIdResponseDataSmartType) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "PlaylistByIdResponseDataSmartType [value=" + value + "]";
    }

    // return an array just like an enum
    public static PlaylistByIdResponseDataSmartType[] values() {
        synchronized (PlaylistByIdResponseDataSmartType.class) {
            return values.values().toArray(new PlaylistByIdResponseDataSmartType[] {});
        }
    }

    private static final Map<String, PlaylistByIdResponseDataSmartType> createValuesMap() {
        Map<String, PlaylistByIdResponseDataSmartType> map = new LinkedHashMap<>();
        map.put(VALUE_SMART, SMART);
        return map;
    }

    private static final Map<String, PlaylistByIdResponseDataSmartTypeEnum> createEnumsMap() {
        Map<String, PlaylistByIdResponseDataSmartTypeEnum> map = new HashMap<>();
        map.put(VALUE_SMART, PlaylistByIdResponseDataSmartTypeEnum.SMART);
        return map;
    }


    public enum PlaylistByIdResponseDataSmartTypeEnum {

        SMART(VALUE_SMART),;

        private final String value;

        private PlaylistByIdResponseDataSmartTypeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
