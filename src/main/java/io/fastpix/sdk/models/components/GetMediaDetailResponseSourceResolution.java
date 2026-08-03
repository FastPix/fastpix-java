package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseSourceResolution
 *
 * <p>The actual resolution of the uploaded media. This represents the native quality of the source media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaDetailResponseSourceResolution {

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
    private static final String RESOLUTION_360P = "360p";
    private static final String RESOLUTION_360 = "360";

    public static final GetMediaDetailResponseSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new GetMediaDetailResponseSourceResolution(RESOLUTION_2160P);
    public static final GetMediaDetailResponseSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY = new GetMediaDetailResponseSourceResolution(RESOLUTION_2160);
    public static final GetMediaDetailResponseSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new GetMediaDetailResponseSourceResolution(RESOLUTION_1440P);
    public static final GetMediaDetailResponseSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY = new GetMediaDetailResponseSourceResolution(RESOLUTION_1440);
    public static final GetMediaDetailResponseSourceResolution ONE_THOUSAND_AND_EIGHTYP = new GetMediaDetailResponseSourceResolution(RESOLUTION_1080P);
    public static final GetMediaDetailResponseSourceResolution ONE_THOUSAND_AND_EIGHTY = new GetMediaDetailResponseSourceResolution(RESOLUTION_1080);
    public static final GetMediaDetailResponseSourceResolution SEVEN_HUNDRED_AND_TWENTYP = new GetMediaDetailResponseSourceResolution(RESOLUTION_720P);
    public static final GetMediaDetailResponseSourceResolution SEVEN_HUNDRED_AND_TWENTY = new GetMediaDetailResponseSourceResolution(RESOLUTION_720);
    public static final GetMediaDetailResponseSourceResolution FOUR_HUNDRED_AND_EIGHTYP = new GetMediaDetailResponseSourceResolution(RESOLUTION_480P);
    public static final GetMediaDetailResponseSourceResolution FOUR_HUNDRED_AND_EIGHTY = new GetMediaDetailResponseSourceResolution(RESOLUTION_480);
    public static final GetMediaDetailResponseSourceResolution THREE_HUNDRED_AND_SIXTYP = new GetMediaDetailResponseSourceResolution(RESOLUTION_360P);
    public static final GetMediaDetailResponseSourceResolution THREE_HUNDRED_AND_SIXTY = new GetMediaDetailResponseSourceResolution(RESOLUTION_360);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseSourceResolution> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseSourceResolutionEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseSourceResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseSourceResolution with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetMediaDetailResponseSourceResolution
     */ 
    @JsonCreator
    public static GetMediaDetailResponseSourceResolution of(String value) {
        synchronized (GetMediaDetailResponseSourceResolution.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseSourceResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseSourceResolutionEnum> asEnum() {
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
        GetMediaDetailResponseSourceResolution other = (GetMediaDetailResponseSourceResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseSourceResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseSourceResolution[] values() {
        synchronized (GetMediaDetailResponseSourceResolution.class) {
            return values.values().toArray(new GetMediaDetailResponseSourceResolution[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseSourceResolution> createValuesMap() {
        Map<String, GetMediaDetailResponseSourceResolution> map = new LinkedHashMap<>();
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
        map.put(RESOLUTION_360P, THREE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_360, THREE_HUNDRED_AND_SIXTY);
        return map;
    }

    private static final Map<String, GetMediaDetailResponseSourceResolutionEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseSourceResolutionEnum> map = new HashMap<>();
        map.put(RESOLUTION_2160P, GetMediaDetailResponseSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_2160, GetMediaDetailResponseSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(RESOLUTION_1440P, GetMediaDetailResponseSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(RESOLUTION_1440, GetMediaDetailResponseSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(RESOLUTION_1080P, GetMediaDetailResponseSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(RESOLUTION_1080, GetMediaDetailResponseSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTY);
        map.put(RESOLUTION_720P, GetMediaDetailResponseSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(RESOLUTION_720, GetMediaDetailResponseSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTY);
        map.put(RESOLUTION_480P, GetMediaDetailResponseSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(RESOLUTION_480, GetMediaDetailResponseSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTY);
        map.put(RESOLUTION_360P, GetMediaDetailResponseSourceResolutionEnum.THREE_HUNDRED_AND_SIXTYP);
        map.put(RESOLUTION_360, GetMediaDetailResponseSourceResolutionEnum.THREE_HUNDRED_AND_SIXTY);
        return map;
    }
    
    
    public enum GetMediaDetailResponseSourceResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(RESOLUTION_2160P),
        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY(RESOLUTION_2160),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(RESOLUTION_1440P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY(RESOLUTION_1440),
        ONE_THOUSAND_AND_EIGHTYP(RESOLUTION_1080P),
        ONE_THOUSAND_AND_EIGHTY(RESOLUTION_1080),
        SEVEN_HUNDRED_AND_TWENTYP(RESOLUTION_720P),
        SEVEN_HUNDRED_AND_TWENTY(RESOLUTION_720),
        FOUR_HUNDRED_AND_EIGHTYP(RESOLUTION_480P),
        FOUR_HUNDRED_AND_EIGHTY(RESOLUTION_480),
        THREE_HUNDRED_AND_SIXTYP(RESOLUTION_360P),
        THREE_HUNDRED_AND_SIXTY(RESOLUTION_360),;

        private final String value;

        private GetMediaDetailResponseSourceResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

