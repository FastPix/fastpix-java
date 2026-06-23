package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateMediaMaxResolution
 *
 * <p>The maximum resolution specified by the user for the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class UpdateMediaMaxResolution {

    private static final String RESOLUTION_2160P = "2160p";
    private static final String RESOLUTION_1440P = "1440p";
    private static final String RESOLUTION_1080P = "1080p";
    private static final String RESOLUTION_720P = "720p";
    private static final String RESOLUTION_480P = "480p";
    private static final String RESOLUTION_360P = "360p";

    public static final UpdateMediaMaxResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new UpdateMediaMaxResolution(RESOLUTION_2160P);
    public static final UpdateMediaMaxResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new UpdateMediaMaxResolution(RESOLUTION_1440P);
    public static final UpdateMediaMaxResolution ONE_THOUSAND_AND_EIGHTYP = new UpdateMediaMaxResolution(RESOLUTION_1080P);
    public static final UpdateMediaMaxResolution SEVEN_HUNDRED_AND_TWENTYP = new UpdateMediaMaxResolution(RESOLUTION_720P);
    public static final UpdateMediaMaxResolution FOUR_HUNDRED_AND_EIGHTYP = new UpdateMediaMaxResolution(RESOLUTION_480P);
    public static final UpdateMediaMaxResolution THREE_HUNDRED_AND_SIXTYP = new UpdateMediaMaxResolution(RESOLUTION_360P);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UpdateMediaMaxResolution> values = createValuesMap();
    private static final Map<String, UpdateMediaMaxResolutionEnum> enums = createEnumsMap();

    private final String value;

    private UpdateMediaMaxResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a UpdateMediaMaxResolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as UpdateMediaMaxResolution
     */ 
    @JsonCreator
    public static UpdateMediaMaxResolution of(String value) {
        synchronized (UpdateMediaMaxResolution.class) {
            return values.computeIfAbsent(value, UpdateMediaMaxResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UpdateMediaMaxResolutionEnum> asEnum() {
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
        UpdateMediaMaxResolution other = (UpdateMediaMaxResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UpdateMediaMaxResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static UpdateMediaMaxResolution[] values() {
        synchronized (UpdateMediaMaxResolution.class) {
            return values.values().toArray(new UpdateMediaMaxResolution[] {});
        }
    }

    private static final Map<String, UpdateMediaMaxResolution> createValuesMap() {
        Map<String, UpdateMediaMaxResolution> map = new LinkedHashMap<>();
        map.put(RESOLUTION_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_480P, FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_360P, THREE_HUNDRED_AND_SIXTYP);
        return map;
    }

    private static final Map<String, UpdateMediaMaxResolutionEnum> createEnumsMap() {
        Map<String, UpdateMediaMaxResolutionEnum> map = new HashMap<>();
        map.put(RESOLUTION_2160P, UpdateMediaMaxResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_1440P, UpdateMediaMaxResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1080P, UpdateMediaMaxResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_720P, UpdateMediaMaxResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_480P, UpdateMediaMaxResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_360P, UpdateMediaMaxResolutionEnum.THREE_HUNDRED_AND_SIXTYP);
        return map;
    }
    
    
    public enum UpdateMediaMaxResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(RESOLUTION_2160P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(RESOLUTION_1440P),
        ONE_THOUSAND_AND_EIGHTYP(RESOLUTION_1080P),
        SEVEN_HUNDRED_AND_TWENTYP(RESOLUTION_720P),
        FOUR_HUNDRED_AND_EIGHTYP(RESOLUTION_480P),
        THREE_HUNDRED_AND_SIXTYP(RESOLUTION_360P),;

        private final String value;

        private UpdateMediaMaxResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

