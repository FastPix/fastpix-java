package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UnusedDirectUploadResponseMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class UnusedDirectUploadResponseMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final UnusedDirectUploadResponseMediaQuality STANDARD = new UnusedDirectUploadResponseMediaQuality(STANDARD_VALUE);
    public static final UnusedDirectUploadResponseMediaQuality PRO = new UnusedDirectUploadResponseMediaQuality(PRO_VALUE);
    public static final UnusedDirectUploadResponseMediaQuality PREMIUM = new UnusedDirectUploadResponseMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UnusedDirectUploadResponseMediaQuality> values = createValuesMap();
    private static final Map<String, UnusedDirectUploadResponseMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private UnusedDirectUploadResponseMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a UnusedDirectUploadResponseMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as UnusedDirectUploadResponseMediaQuality
     */ 
    @JsonCreator
    public static UnusedDirectUploadResponseMediaQuality of(String value) {
        synchronized (UnusedDirectUploadResponseMediaQuality.class) {
            return values.computeIfAbsent(value, UnusedDirectUploadResponseMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UnusedDirectUploadResponseMediaQualityEnum> asEnum() {
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
        UnusedDirectUploadResponseMediaQuality other = (UnusedDirectUploadResponseMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UnusedDirectUploadResponseMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static UnusedDirectUploadResponseMediaQuality[] values() {
        synchronized (UnusedDirectUploadResponseMediaQuality.class) {
            return values.values().toArray(new UnusedDirectUploadResponseMediaQuality[] {});
        }
    }

    private static final Map<String, UnusedDirectUploadResponseMediaQuality> createValuesMap() {
        Map<String, UnusedDirectUploadResponseMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, UnusedDirectUploadResponseMediaQualityEnum> createEnumsMap() {
        Map<String, UnusedDirectUploadResponseMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, UnusedDirectUploadResponseMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, UnusedDirectUploadResponseMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, UnusedDirectUploadResponseMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum UnusedDirectUploadResponseMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private UnusedDirectUploadResponseMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

