package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateMediaMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class UpdateMediaMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final UpdateMediaMediaQuality STANDARD = new UpdateMediaMediaQuality(STANDARD_VALUE);
    public static final UpdateMediaMediaQuality PRO = new UpdateMediaMediaQuality(PRO_VALUE);
    public static final UpdateMediaMediaQuality PREMIUM = new UpdateMediaMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UpdateMediaMediaQuality> values = createValuesMap();
    private static final Map<String, UpdateMediaMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private UpdateMediaMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a UpdateMediaMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as UpdateMediaMediaQuality
     */ 
    @JsonCreator
    public static UpdateMediaMediaQuality of(String value) {
        synchronized (UpdateMediaMediaQuality.class) {
            return values.computeIfAbsent(value, UpdateMediaMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UpdateMediaMediaQualityEnum> asEnum() {
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
        UpdateMediaMediaQuality other = (UpdateMediaMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UpdateMediaMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static UpdateMediaMediaQuality[] values() {
        synchronized (UpdateMediaMediaQuality.class) {
            return values.values().toArray(new UpdateMediaMediaQuality[] {});
        }
    }

    private static final Map<String, UpdateMediaMediaQuality> createValuesMap() {
        Map<String, UpdateMediaMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, UpdateMediaMediaQualityEnum> createEnumsMap() {
        Map<String, UpdateMediaMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, UpdateMediaMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, UpdateMediaMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, UpdateMediaMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum UpdateMediaMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private UpdateMediaMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

