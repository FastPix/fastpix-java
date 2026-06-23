package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * AddTrackResponseType
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 *
 * <p>Specifies the type of track (audio or subtitle).
 */
public class AddTrackResponseType {

    private static final String AUDIO_VALUE = "audio";
    private static final String SUBTITLE_VALUE = "subtitle";

    public static final AddTrackResponseType AUDIO = new AddTrackResponseType(AUDIO_VALUE);
    public static final AddTrackResponseType SUBTITLE = new AddTrackResponseType(SUBTITLE_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, AddTrackResponseType> values = createValuesMap();
    private static final Map<String, AddTrackResponseTypeEnum> enums = createEnumsMap();

    private final String value;

    private AddTrackResponseType(String value) {
        this.value = value;
    }

    /**
     * Returns a AddTrackResponseType with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as AddTrackResponseType
     */ 
    @JsonCreator
    public static AddTrackResponseType of(String value) {
        synchronized (AddTrackResponseType.class) {
            return values.computeIfAbsent(value, AddTrackResponseType::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<AddTrackResponseTypeEnum> asEnum() {
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
        AddTrackResponseType other = (AddTrackResponseType) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "AddTrackResponseType [value=" + value + "]";
    }

    // return an array just like an enum
    public static AddTrackResponseType[] values() {
        synchronized (AddTrackResponseType.class) {
            return values.values().toArray(new AddTrackResponseType[] {});
        }
    }

    private static final Map<String, AddTrackResponseType> createValuesMap() {
        Map<String, AddTrackResponseType> map = new LinkedHashMap<>();
        map.put(AUDIO_VALUE, AUDIO);
        map.put(SUBTITLE_VALUE, SUBTITLE);
        return map;
    }

    private static final Map<String, AddTrackResponseTypeEnum> createEnumsMap() {
        Map<String, AddTrackResponseTypeEnum> map = new HashMap<>();
        map.put(AUDIO_VALUE, AddTrackResponseTypeEnum.AUDIO);
        map.put(SUBTITLE_VALUE, AddTrackResponseTypeEnum.SUBTITLE);
        return map;
    }
    
    
    public enum AddTrackResponseTypeEnum {

        AUDIO(AUDIO_VALUE),
        SUBTITLE(SUBTITLE_VALUE),;

        private final String value;

        private AddTrackResponseTypeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

