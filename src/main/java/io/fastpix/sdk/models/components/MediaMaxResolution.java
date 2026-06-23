package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaMaxResolution
 *
 * <p>The maximum resolution specified by the user for the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaMaxResolution {

    private static final String RESOLUTION_2160P = "2160p";
    private static final String RESOLUTION_1440P = "1440p";
    private static final String RESOLUTION_1080P = "1080p";
    private static final String RESOLUTION_720P = "720p";
    private static final String RESOLUTION_480P = "480p";

    public static final MediaMaxResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new MediaMaxResolution(RESOLUTION_2160P);
    public static final MediaMaxResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new MediaMaxResolution(RESOLUTION_1440P);
    public static final MediaMaxResolution ONE_THOUSAND_AND_EIGHTYP = new MediaMaxResolution(RESOLUTION_1080P);
    public static final MediaMaxResolution SEVEN_HUNDRED_AND_TWENTYP = new MediaMaxResolution(RESOLUTION_720P);
    public static final MediaMaxResolution FOUR_HUNDRED_AND_EIGHTYP = new MediaMaxResolution(RESOLUTION_480P);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaMaxResolution> values = createValuesMap();
    private static final Map<String, MediaMaxResolutionEnum> enums = createEnumsMap();

    private final String value;

    private MediaMaxResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaMaxResolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as MediaMaxResolution
     */ 
    @JsonCreator
    public static MediaMaxResolution of(String value) {
        synchronized (MediaMaxResolution.class) {
            return values.computeIfAbsent(value, MediaMaxResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaMaxResolutionEnum> asEnum() {
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
        MediaMaxResolution other = (MediaMaxResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaMaxResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaMaxResolution[] values() {
        synchronized (MediaMaxResolution.class) {
            return values.values().toArray(new MediaMaxResolution[] {});
        }
    }

    private static final Map<String, MediaMaxResolution> createValuesMap() {
        Map<String, MediaMaxResolution> map = new LinkedHashMap<>();
        map.put(RESOLUTION_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_480P, FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }

    private static final Map<String, MediaMaxResolutionEnum> createEnumsMap() {
        Map<String, MediaMaxResolutionEnum> map = new HashMap<>();
        map.put(RESOLUTION_2160P, MediaMaxResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_1440P, MediaMaxResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1080P, MediaMaxResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_720P, MediaMaxResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_480P, MediaMaxResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }
    
    
    public enum MediaMaxResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(RESOLUTION_2160P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(RESOLUTION_1440P),
        ONE_THOUSAND_AND_EIGHTYP(RESOLUTION_1080P),
        SEVEN_HUNDRED_AND_TWENTYP(RESOLUTION_720P),
        FOUR_HUNDRED_AND_EIGHTYP(RESOLUTION_480P),;

        private final String value;

        private MediaMaxResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

