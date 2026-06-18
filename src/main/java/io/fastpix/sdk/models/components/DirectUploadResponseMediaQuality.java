package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * DirectUploadResponseMediaQuality
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 *
 * <p>The quality tier applied to the media.
 */
public class DirectUploadResponseMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final DirectUploadResponseMediaQuality STANDARD = new DirectUploadResponseMediaQuality(STANDARD_VALUE);
    public static final DirectUploadResponseMediaQuality PRO = new DirectUploadResponseMediaQuality(PRO_VALUE);
    public static final DirectUploadResponseMediaQuality PREMIUM = new DirectUploadResponseMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, DirectUploadResponseMediaQuality> values = createValuesMap();
    private static final Map<String, DirectUploadResponseMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private DirectUploadResponseMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a DirectUploadResponseMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as DirectUploadResponseMediaQuality
     */ 
    @JsonCreator
    public static DirectUploadResponseMediaQuality of(String value) {
        synchronized (DirectUploadResponseMediaQuality.class) {
            return values.computeIfAbsent(value, DirectUploadResponseMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<DirectUploadResponseMediaQualityEnum> asEnum() {
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
        DirectUploadResponseMediaQuality other = (DirectUploadResponseMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "DirectUploadResponseMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static DirectUploadResponseMediaQuality[] values() {
        synchronized (DirectUploadResponseMediaQuality.class) {
            return values.values().toArray(new DirectUploadResponseMediaQuality[] {});
        }
    }

    private static final Map<String, DirectUploadResponseMediaQuality> createValuesMap() {
        Map<String, DirectUploadResponseMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, DirectUploadResponseMediaQualityEnum> createEnumsMap() {
        Map<String, DirectUploadResponseMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, DirectUploadResponseMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, DirectUploadResponseMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, DirectUploadResponseMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum DirectUploadResponseMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private DirectUploadResponseMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

