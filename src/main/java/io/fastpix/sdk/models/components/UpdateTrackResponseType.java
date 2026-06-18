package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateTrackResponseType
 *
 * <p>Specifies the type of track (audio or subtitle).
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class UpdateTrackResponseType {

    private static final String AUDIO_VALUE = "audio";
    private static final String SUBTITLE_VALUE = "subtitle";

    public static final UpdateTrackResponseType AUDIO = new UpdateTrackResponseType(AUDIO_VALUE);
    public static final UpdateTrackResponseType SUBTITLE = new UpdateTrackResponseType(SUBTITLE_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UpdateTrackResponseType> values = createValuesMap();
    private static final Map<String, UpdateTrackResponseTypeEnum> enums = createEnumsMap();

    private final String value;

    private UpdateTrackResponseType(String value) {
        this.value = value;
    }

    /**
     * Returns a UpdateTrackResponseType with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as UpdateTrackResponseType
     */ 
    @JsonCreator
    public static UpdateTrackResponseType of(String value) {
        synchronized (UpdateTrackResponseType.class) {
            return values.computeIfAbsent(value, UpdateTrackResponseType::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UpdateTrackResponseTypeEnum> asEnum() {
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
        UpdateTrackResponseType other = (UpdateTrackResponseType) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UpdateTrackResponseType [value=" + value + "]";
    }

    // return an array just like an enum
    public static UpdateTrackResponseType[] values() {
        synchronized (UpdateTrackResponseType.class) {
            return values.values().toArray(new UpdateTrackResponseType[] {});
        }
    }

    private static final Map<String, UpdateTrackResponseType> createValuesMap() {
        Map<String, UpdateTrackResponseType> map = new LinkedHashMap<>();
        map.put(AUDIO_VALUE, AUDIO);
        map.put(SUBTITLE_VALUE, SUBTITLE);
        return map;
    }

    private static final Map<String, UpdateTrackResponseTypeEnum> createEnumsMap() {
        Map<String, UpdateTrackResponseTypeEnum> map = new HashMap<>();
        map.put(AUDIO_VALUE, UpdateTrackResponseTypeEnum.AUDIO);
        map.put(SUBTITLE_VALUE, UpdateTrackResponseTypeEnum.SUBTITLE);
        return map;
    }
    
    
    public enum UpdateTrackResponseTypeEnum {

        AUDIO(AUDIO_VALUE),
        SUBTITLE(SUBTITLE_VALUE),;

        private final String value;

        private UpdateTrackResponseTypeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

