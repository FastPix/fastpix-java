package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Resolution
 *
 * <p>The maximum resolution for the playback ID.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class Resolution {

    private static final String RESOLUTION_480P = "480p";
    private static final String RESOLUTION_720P = "720p";
    private static final String RESOLUTION_1080P = "1080p";
    private static final String RESOLUTION_1440P = "1440p";
    private static final String RESOLUTION_2160P = "2160p";

    public static final Resolution FOUR_HUNDRED_AND_EIGHTYP = new Resolution(RESOLUTION_480P);
    public static final Resolution SEVEN_HUNDRED_AND_TWENTYP = new Resolution(RESOLUTION_720P);
    public static final Resolution ONE_THOUSAND_AND_EIGHTYP = new Resolution(RESOLUTION_1080P);
    public static final Resolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new Resolution(RESOLUTION_1440P);
    public static final Resolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new Resolution(RESOLUTION_2160P);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, Resolution> values = createValuesMap();
    private static final Map<String, ResolutionEnum> enums = createEnumsMap();

    private final String value;

    private Resolution(String value) {
        this.value = value;
    }

    /**
     * Returns a Resolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as Resolution
     */ 
    @JsonCreator
    public static Resolution of(String value) {
        synchronized (Resolution.class) {
            return values.computeIfAbsent(value, Resolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<ResolutionEnum> asEnum() {
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
        Resolution other = (Resolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "Resolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static Resolution[] values() {
        synchronized (Resolution.class) {
            return values.values().toArray(new Resolution[] {});
        }
    }

    private static final Map<String, Resolution> createValuesMap() {
        Map<String, Resolution> map = new LinkedHashMap<>();
        map.put(RESOLUTION_480P, FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        return map;
    }

    private static final Map<String, ResolutionEnum> createEnumsMap() {
        Map<String, ResolutionEnum> map = new HashMap<>();
        map.put(RESOLUTION_480P, ResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_720P, ResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_1080P, ResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_1440P, ResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_2160P, ResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        return map;
    }
    
    
    public enum ResolutionEnum {

        FOUR_HUNDRED_AND_EIGHTYP(RESOLUTION_480P),
        SEVEN_HUNDRED_AND_TWENTYP(RESOLUTION_720P),
        ONE_THOUSAND_AND_EIGHTYP(RESOLUTION_1080P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(RESOLUTION_1440P),
        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(RESOLUTION_2160P),;

        private final String value;

        private ResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

