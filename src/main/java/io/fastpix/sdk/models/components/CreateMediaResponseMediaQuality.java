package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * CreateMediaResponseMediaQuality
 *
 * <p>The quality tier applied to the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class CreateMediaResponseMediaQuality {

    private static final String STANDARD_VALUE = "standard";
    private static final String PRO_VALUE = "pro";
    private static final String PREMIUM_VALUE = "premium";

    public static final CreateMediaResponseMediaQuality STANDARD = new CreateMediaResponseMediaQuality(STANDARD_VALUE);
    public static final CreateMediaResponseMediaQuality PRO = new CreateMediaResponseMediaQuality(PRO_VALUE);
    public static final CreateMediaResponseMediaQuality PREMIUM = new CreateMediaResponseMediaQuality(PREMIUM_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, CreateMediaResponseMediaQuality> values = createValuesMap();
    private static final Map<String, CreateMediaResponseMediaQualityEnum> enums = createEnumsMap();

    private final String value;

    private CreateMediaResponseMediaQuality(String value) {
        this.value = value;
    }

    /**
     * Returns a CreateMediaResponseMediaQuality with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as CreateMediaResponseMediaQuality
     */ 
    @JsonCreator
    public static CreateMediaResponseMediaQuality of(String value) {
        synchronized (CreateMediaResponseMediaQuality.class) {
            return values.computeIfAbsent(value, CreateMediaResponseMediaQuality::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<CreateMediaResponseMediaQualityEnum> asEnum() {
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
        CreateMediaResponseMediaQuality other = (CreateMediaResponseMediaQuality) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "CreateMediaResponseMediaQuality [value=" + value + "]";
    }

    // return an array just like an enum
    public static CreateMediaResponseMediaQuality[] values() {
        synchronized (CreateMediaResponseMediaQuality.class) {
            return values.values().toArray(new CreateMediaResponseMediaQuality[] {});
        }
    }

    private static final Map<String, CreateMediaResponseMediaQuality> createValuesMap() {
        Map<String, CreateMediaResponseMediaQuality> map = new LinkedHashMap<>();
        map.put(STANDARD_VALUE, STANDARD);
        map.put(PRO_VALUE, PRO);
        map.put(PREMIUM_VALUE, PREMIUM);
        return map;
    }

    private static final Map<String, CreateMediaResponseMediaQualityEnum> createEnumsMap() {
        Map<String, CreateMediaResponseMediaQualityEnum> map = new HashMap<>();
        map.put(STANDARD_VALUE, CreateMediaResponseMediaQualityEnum.STANDARD);
        map.put(PRO_VALUE, CreateMediaResponseMediaQualityEnum.PRO);
        map.put(PREMIUM_VALUE, CreateMediaResponseMediaQualityEnum.PREMIUM);
        return map;
    }
    
    
    public enum CreateMediaResponseMediaQualityEnum {

        STANDARD(STANDARD_VALUE),
        PRO(PRO_VALUE),
        PREMIUM(PREMIUM_VALUE),;

        private final String value;

        private CreateMediaResponseMediaQualityEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

