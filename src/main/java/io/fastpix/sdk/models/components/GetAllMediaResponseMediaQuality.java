package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetAllMediaResponseMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetAllMediaResponseMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final GetAllMediaResponseMediaQuality STANDARD = new GetAllMediaResponseMediaQuality(STANDARD_VALUE);
    public static final GetAllMediaResponseMediaQuality PRO = new GetAllMediaResponseMediaQuality(PRO_VALUE);
    public static final GetAllMediaResponseMediaQuality PREMIUM = new GetAllMediaResponseMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetAllMediaResponseMediaQuality> values = createValuesMap();
    private static final Map<String, GetAllMediaResponseMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private GetAllMediaResponseMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a GetAllMediaResponseMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetAllMediaResponseMediaQuality
     */ 
    @JsonCreator
    public static GetAllMediaResponseMediaQuality of(String value) {
        synchronized (GetAllMediaResponseMediaQuality.class) {
            return values.computeIfAbsent(value, GetAllMediaResponseMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetAllMediaResponseMediaQualityEnum> asEnum() {
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
        GetAllMediaResponseMediaQuality other = (GetAllMediaResponseMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetAllMediaResponseMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetAllMediaResponseMediaQuality[] values() {
        synchronized (GetAllMediaResponseMediaQuality.class) {
            return values.values().toArray(new GetAllMediaResponseMediaQuality[] {});
        }
    }

    private static final Map<String, GetAllMediaResponseMediaQuality> createValuesMap() {
        Map<String, GetAllMediaResponseMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, GetAllMediaResponseMediaQualityEnum> createEnumsMap() {
        Map<String, GetAllMediaResponseMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, GetAllMediaResponseMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, GetAllMediaResponseMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, GetAllMediaResponseMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum GetAllMediaResponseMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private GetAllMediaResponseMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

