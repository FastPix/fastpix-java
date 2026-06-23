package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * LiveMediaClipsSourceResolution
 *
 * <p>The actual resolution of the uploaded media. This represents the native quality of the source media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class LiveMediaClipsSourceResolution {

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

    public static final LiveMediaClipsSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new LiveMediaClipsSourceResolution(RESOLUTION_2160P);
    public static final LiveMediaClipsSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY = new LiveMediaClipsSourceResolution(RESOLUTION_2160);
    public static final LiveMediaClipsSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new LiveMediaClipsSourceResolution(RESOLUTION_1440P);
    public static final LiveMediaClipsSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY = new LiveMediaClipsSourceResolution(RESOLUTION_1440);
    public static final LiveMediaClipsSourceResolution ONE_THOUSAND_AND_EIGHTYP = new LiveMediaClipsSourceResolution(RESOLUTION_1080P);
    public static final LiveMediaClipsSourceResolution ONE_THOUSAND_AND_EIGHTY = new LiveMediaClipsSourceResolution(RESOLUTION_1080);
    public static final LiveMediaClipsSourceResolution SEVEN_HUNDRED_AND_TWENTYP = new LiveMediaClipsSourceResolution(RESOLUTION_720P);
    public static final LiveMediaClipsSourceResolution SEVEN_HUNDRED_AND_TWENTY = new LiveMediaClipsSourceResolution(RESOLUTION_720);
    public static final LiveMediaClipsSourceResolution FOUR_HUNDRED_AND_EIGHTYP = new LiveMediaClipsSourceResolution(RESOLUTION_480P);
    public static final LiveMediaClipsSourceResolution FOUR_HUNDRED_AND_EIGHTY = new LiveMediaClipsSourceResolution(RESOLUTION_480);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, LiveMediaClipsSourceResolution> values = createValuesMap();
    private static final Map<String, LiveMediaClipsSourceResolutionEnum> enums = createEnumsMap();

    private final String value;

    private LiveMediaClipsSourceResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a LiveMediaClipsSourceResolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as LiveMediaClipsSourceResolution
     */ 
    @JsonCreator
    public static LiveMediaClipsSourceResolution of(String value) {
        synchronized (LiveMediaClipsSourceResolution.class) {
            return values.computeIfAbsent(value, LiveMediaClipsSourceResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<LiveMediaClipsSourceResolutionEnum> asEnum() {
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
        LiveMediaClipsSourceResolution other = (LiveMediaClipsSourceResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "LiveMediaClipsSourceResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static LiveMediaClipsSourceResolution[] values() {
        synchronized (LiveMediaClipsSourceResolution.class) {
            return values.values().toArray(new LiveMediaClipsSourceResolution[] {});
        }
    }

    private static final Map<String, LiveMediaClipsSourceResolution> createValuesMap() {
        Map<String, LiveMediaClipsSourceResolution> map = new LinkedHashMap<>();
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

    private static final Map<String, LiveMediaClipsSourceResolutionEnum> createEnumsMap() {
        Map<String, LiveMediaClipsSourceResolutionEnum> map = new HashMap<>();
        map.put(RESOLUTION_2160P, LiveMediaClipsSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_2160, LiveMediaClipsSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(RESOLUTION_1440P, LiveMediaClipsSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1440, LiveMediaClipsSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(RESOLUTION_1080P, LiveMediaClipsSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_1080, LiveMediaClipsSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTY);
        map.put(RESOLUTION_720P, LiveMediaClipsSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_720, LiveMediaClipsSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTY);
        map.put(RESOLUTION_480P, LiveMediaClipsSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_480, LiveMediaClipsSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTY);
        return map;
    }
    
    
    public enum LiveMediaClipsSourceResolutionEnum {

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

        private LiveMediaClipsSourceResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

