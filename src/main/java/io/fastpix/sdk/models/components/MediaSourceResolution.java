package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaSourceResolution
 *
 * <p>The actual resolution of the uploaded media. This represents the native quality of the source media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaSourceResolution {

    private static final String RESOLUTION_2160P = "2160p";
    private static final String RESOLUTION_2160 = "2160";
    private static final String RESOLUTION_1440P = "1440p";
    private static final String RESOLUTION_1440 = "1440";
    private static final String RESOLUTION_1080P = "1080p";
    private static final String RESOLUTION_1080 = "1080";
    private static final String RESOLUTION_720P = "720p";
    private static final String RESOLUTION_720 = "720";
    private static final String RESOLUTION_480P = "480p";
    private static final String RESOLUTION_480 = "480";

    public static final MediaSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new MediaSourceResolution(RESOLUTION_2160P);
    public static final MediaSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY = new MediaSourceResolution(RESOLUTION_2160);
    public static final MediaSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new MediaSourceResolution(RESOLUTION_1440P);
    public static final MediaSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY = new MediaSourceResolution(RESOLUTION_1440);
    public static final MediaSourceResolution ONE_THOUSAND_AND_EIGHTYP = new MediaSourceResolution(RESOLUTION_1080P);
    public static final MediaSourceResolution ONE_THOUSAND_AND_EIGHTY = new MediaSourceResolution(RESOLUTION_1080);
    public static final MediaSourceResolution SEVEN_HUNDRED_AND_TWENTYP = new MediaSourceResolution(RESOLUTION_720P);
    public static final MediaSourceResolution SEVEN_HUNDRED_AND_TWENTY = new MediaSourceResolution(RESOLUTION_720);
    public static final MediaSourceResolution FOUR_HUNDRED_AND_EIGHTYP = new MediaSourceResolution(RESOLUTION_480P);
    public static final MediaSourceResolution FOUR_HUNDRED_AND_EIGHTY = new MediaSourceResolution(RESOLUTION_480);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaSourceResolution> values = createValuesMap();
    private static final Map<String, MediaSourceResolutionEnum> enums = createEnumsMap();

    private final String value;

    private MediaSourceResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaSourceResolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as MediaSourceResolution
     */ 
    @JsonCreator
    public static MediaSourceResolution of(String value) {
        synchronized (MediaSourceResolution.class) {
            return values.computeIfAbsent(value, MediaSourceResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaSourceResolutionEnum> asEnum() {
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
        MediaSourceResolution other = (MediaSourceResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaSourceResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaSourceResolution[] values() {
        synchronized (MediaSourceResolution.class) {
            return values.values().toArray(new MediaSourceResolution[] {});
        }
    }

    private static final Map<String, MediaSourceResolution> createValuesMap() {
        Map<String, MediaSourceResolution> map = new LinkedHashMap<>();
        map.put(RESOLUTION_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_2160, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(RESOLUTION_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1440, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(RESOLUTION_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_1080, ONE_THOUSAND_AND_EIGHTY);
        map.put(RESOLUTION_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_720, SEVEN_HUNDRED_AND_TWENTY);
        map.put(RESOLUTION_480P, FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_480, FOUR_HUNDRED_AND_EIGHTY);
        return map;
    }

    private static final Map<String, MediaSourceResolutionEnum> createEnumsMap() {
        Map<String, MediaSourceResolutionEnum> map = new HashMap<>();
        map.put(RESOLUTION_2160P, MediaSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_2160, MediaSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(RESOLUTION_1440P, MediaSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1440, MediaSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(RESOLUTION_1080P, MediaSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_1080, MediaSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTY);
        map.put(RESOLUTION_720P, MediaSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_720, MediaSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTY);
        map.put(RESOLUTION_480P, MediaSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_480, MediaSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTY);
        return map;
    }
    
    
    public enum MediaSourceResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(RESOLUTION_2160P),
        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY(RESOLUTION_2160),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(RESOLUTION_1440P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY(RESOLUTION_1440),
        ONE_THOUSAND_AND_EIGHTYP(RESOLUTION_1080P),
        ONE_THOUSAND_AND_EIGHTY(RESOLUTION_1080),
        SEVEN_HUNDRED_AND_TWENTYP(RESOLUTION_720P),
        SEVEN_HUNDRED_AND_TWENTY(RESOLUTION_720),
        FOUR_HUNDRED_AND_EIGHTYP(RESOLUTION_480P),
        FOUR_HUNDRED_AND_EIGHTY(RESOLUTION_480),;

        private final String value;

        private MediaSourceResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

