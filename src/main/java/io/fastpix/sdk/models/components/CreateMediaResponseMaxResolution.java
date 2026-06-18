package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * CreateMediaResponseMaxResolution
 * 
 * <p>The maximum resolution tier defines the highest quality at which your media is available.
 */
public class CreateMediaResponseMaxResolution {

    private static final String VALUE_2160P = "2160p";
    private static final String VALUE_1440P = "1440p";
    private static final String VALUE_1080P = "1080p";
    private static final String VALUE_720P = "720p";
    private static final String VALUE_480P = "480p";

    public static final CreateMediaResponseMaxResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new CreateMediaResponseMaxResolution(VALUE_2160P);
    public static final CreateMediaResponseMaxResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new CreateMediaResponseMaxResolution(VALUE_1440P);
    public static final CreateMediaResponseMaxResolution ONE_THOUSAND_AND_EIGHTYP = new CreateMediaResponseMaxResolution(VALUE_1080P);
    public static final CreateMediaResponseMaxResolution SEVEN_HUNDRED_AND_TWENTYP = new CreateMediaResponseMaxResolution(VALUE_720P);
    public static final CreateMediaResponseMaxResolution FOUR_HUNDRED_AND_EIGHTYP = new CreateMediaResponseMaxResolution(VALUE_480P);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, CreateMediaResponseMaxResolution> values = createValuesMap();
    private static final Map<String, CreateMediaResponseMaxResolutionEnum> enums = createEnumsMap();

    private final String value;

    private CreateMediaResponseMaxResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a CreateMediaResponseMaxResolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as CreateMediaResponseMaxResolution
     */ 
    @JsonCreator
    public static CreateMediaResponseMaxResolution of(String value) {
        synchronized (CreateMediaResponseMaxResolution.class) {
            return values.computeIfAbsent(value, CreateMediaResponseMaxResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<CreateMediaResponseMaxResolutionEnum> asEnum() {
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
        CreateMediaResponseMaxResolution other = (CreateMediaResponseMaxResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "CreateMediaResponseMaxResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static CreateMediaResponseMaxResolution[] values() {
        synchronized (CreateMediaResponseMaxResolution.class) {
            return values.values().toArray(new CreateMediaResponseMaxResolution[] {});
        }
    }

    private static final Map<String, CreateMediaResponseMaxResolution> createValuesMap() {
        Map<String, CreateMediaResponseMaxResolution> map = new LinkedHashMap<>();
        map.put(VALUE_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_480P, FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }

    private static final Map<String, CreateMediaResponseMaxResolutionEnum> createEnumsMap() {
        Map<String, CreateMediaResponseMaxResolutionEnum> map = new HashMap<>();
        map.put(VALUE_2160P, CreateMediaResponseMaxResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_1440P, CreateMediaResponseMaxResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1080P, CreateMediaResponseMaxResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_720P, CreateMediaResponseMaxResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_480P, CreateMediaResponseMaxResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }
    
    
    public enum CreateMediaResponseMaxResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(VALUE_2160P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(VALUE_1440P),
        ONE_THOUSAND_AND_EIGHTYP(VALUE_1080P),
        SEVEN_HUNDRED_AND_TWENTYP(VALUE_720P),
        FOUR_HUNDRED_AND_EIGHTYP(VALUE_480P),;

        private final String value;

        private CreateMediaResponseMaxResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

