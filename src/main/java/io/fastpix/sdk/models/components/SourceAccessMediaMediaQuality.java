package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * SourceAccessMediaMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class SourceAccessMediaMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final SourceAccessMediaMediaQuality STANDARD = new SourceAccessMediaMediaQuality(STANDARD_VALUE);
    public static final SourceAccessMediaMediaQuality PRO = new SourceAccessMediaMediaQuality(PRO_VALUE);
    public static final SourceAccessMediaMediaQuality PREMIUM = new SourceAccessMediaMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, SourceAccessMediaMediaQuality> values = createValuesMap();
    private static final Map<String, SourceAccessMediaMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private SourceAccessMediaMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a SourceAccessMediaMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as SourceAccessMediaMediaQuality
     */ 
    @JsonCreator
    public static SourceAccessMediaMediaQuality of(String value) {
        synchronized (SourceAccessMediaMediaQuality.class) {
            return values.computeIfAbsent(value, SourceAccessMediaMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<SourceAccessMediaMediaQualityEnum> asEnum() {
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
        SourceAccessMediaMediaQuality other = (SourceAccessMediaMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "SourceAccessMediaMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static SourceAccessMediaMediaQuality[] values() {
        synchronized (SourceAccessMediaMediaQuality.class) {
            return values.values().toArray(new SourceAccessMediaMediaQuality[] {});
        }
    }

    private static final Map<String, SourceAccessMediaMediaQuality> createValuesMap() {
        Map<String, SourceAccessMediaMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, SourceAccessMediaMediaQualityEnum> createEnumsMap() {
        Map<String, SourceAccessMediaMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, SourceAccessMediaMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, SourceAccessMediaMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, SourceAccessMediaMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum SourceAccessMediaMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private SourceAccessMediaMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

