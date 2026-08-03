package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaDetailResponseMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final GetMediaDetailResponseMediaQuality STANDARD = new GetMediaDetailResponseMediaQuality(STANDARD_VALUE);
    public static final GetMediaDetailResponseMediaQuality PRO = new GetMediaDetailResponseMediaQuality(PRO_VALUE);
    public static final GetMediaDetailResponseMediaQuality PREMIUM = new GetMediaDetailResponseMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseMediaQuality> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetMediaDetailResponseMediaQuality
     */ 
    @JsonCreator
    public static GetMediaDetailResponseMediaQuality of(String value) {
        synchronized (GetMediaDetailResponseMediaQuality.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseMediaQualityEnum> asEnum() {
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
        GetMediaDetailResponseMediaQuality other = (GetMediaDetailResponseMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseMediaQuality[] values() {
        synchronized (GetMediaDetailResponseMediaQuality.class) {
            return values.values().toArray(new GetMediaDetailResponseMediaQuality[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseMediaQuality> createValuesMap() {
        Map<String, GetMediaDetailResponseMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, GetMediaDetailResponseMediaQualityEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, GetMediaDetailResponseMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, GetMediaDetailResponseMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, GetMediaDetailResponseMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum GetMediaDetailResponseMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private GetMediaDetailResponseMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

