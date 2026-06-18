package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final MediaMediaQuality STANDARD = new MediaMediaQuality(STANDARD_VALUE);
    public static final MediaMediaQuality PRO = new MediaMediaQuality(PRO_VALUE);
    public static final MediaMediaQuality PREMIUM = new MediaMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaMediaQuality> values = createValuesMap();
    private static final Map<String, MediaMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private MediaMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as MediaMediaQuality
     */ 
    @JsonCreator
    public static MediaMediaQuality of(String value) {
        synchronized (MediaMediaQuality.class) {
            return values.computeIfAbsent(value, MediaMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaMediaQualityEnum> asEnum() {
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
        MediaMediaQuality other = (MediaMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaMediaQuality[] values() {
        synchronized (MediaMediaQuality.class) {
            return values.values().toArray(new MediaMediaQuality[] {});
        }
    }

    private static final Map<String, MediaMediaQuality> createValuesMap() {
        Map<String, MediaMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, MediaMediaQualityEnum> createEnumsMap() {
        Map<String, MediaMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, MediaMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, MediaMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, MediaMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum MediaMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private MediaMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

