package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * SourceAccessMediaSourceResolution
 *
 * <p>The actual resolution of the uploaded media. This represents the native quality of the source media.
 */
public class SourceAccessMediaSourceResolution {

    private static final String VALUE_2160P = "2160p";
    private static final String VALUE_2160 = "2160";
    private static final String VALUE_1440P = "1440p";
    private static final String VALUE_1440 = "1440";
    private static final String VALUE_1080P = "1080p";
    private static final String VALUE_1080 = "1080";
    private static final String VALUE_720P = "720p";
    private static final String VALUE_720 = "720";
    private static final String VALUE_480P = "480p";
    private static final String VALUE_480 = "480";
    private static final String VALUE_360P = "360p";
    private static final String VALUE_360 = "360";

    public static final SourceAccessMediaSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new SourceAccessMediaSourceResolution(VALUE_2160P);
    public static final SourceAccessMediaSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY = new SourceAccessMediaSourceResolution(VALUE_2160);
    public static final SourceAccessMediaSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new SourceAccessMediaSourceResolution(VALUE_1440P);
    public static final SourceAccessMediaSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY = new SourceAccessMediaSourceResolution(VALUE_1440);
    public static final SourceAccessMediaSourceResolution ONE_THOUSAND_AND_EIGHTYP = new SourceAccessMediaSourceResolution(VALUE_1080P);
    public static final SourceAccessMediaSourceResolution ONE_THOUSAND_AND_EIGHTY = new SourceAccessMediaSourceResolution(VALUE_1080);
    public static final SourceAccessMediaSourceResolution SEVEN_HUNDRED_AND_TWENTYP = new SourceAccessMediaSourceResolution(VALUE_720P);
    public static final SourceAccessMediaSourceResolution SEVEN_HUNDRED_AND_TWENTY = new SourceAccessMediaSourceResolution(VALUE_720);
    public static final SourceAccessMediaSourceResolution FOUR_HUNDRED_AND_EIGHTYP = new SourceAccessMediaSourceResolution(VALUE_480P);
    public static final SourceAccessMediaSourceResolution FOUR_HUNDRED_AND_EIGHTY = new SourceAccessMediaSourceResolution(VALUE_480);
    public static final SourceAccessMediaSourceResolution THREE_HUNDRED_AND_SIXTYP = new SourceAccessMediaSourceResolution(VALUE_360P);
    public static final SourceAccessMediaSourceResolution THREE_HUNDRED_AND_SIXTY = new SourceAccessMediaSourceResolution(VALUE_360);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, SourceAccessMediaSourceResolution> values = createValuesMap();
    private static final Map<String, SourceAccessMediaSourceResolutionEnum> enums = createEnumsMap();

    private final String value;

    private SourceAccessMediaSourceResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a SourceAccessMediaSourceResolution with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as SourceAccessMediaSourceResolution
     */
    @JsonCreator
    public static SourceAccessMediaSourceResolution of(String value) {
        synchronized (SourceAccessMediaSourceResolution.class) {
            return values.computeIfAbsent(value, SourceAccessMediaSourceResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<SourceAccessMediaSourceResolutionEnum> asEnum() {
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
        SourceAccessMediaSourceResolution other = (SourceAccessMediaSourceResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "SourceAccessMediaSourceResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static SourceAccessMediaSourceResolution[] values() {
        synchronized (SourceAccessMediaSourceResolution.class) {
            return values.values().toArray(new SourceAccessMediaSourceResolution[] {});
        }
    }

    private static final Map<String, SourceAccessMediaSourceResolution> createValuesMap() {
        Map<String, SourceAccessMediaSourceResolution> map = new LinkedHashMap<>();
        map.put(VALUE_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_2160, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(VALUE_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1440, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(VALUE_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_1080, ONE_THOUSAND_AND_EIGHTY);
        map.put(VALUE_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_720, SEVEN_HUNDRED_AND_TWENTY);
        map.put(VALUE_480P, FOUR_HUNDRED_AND_EIGHTYP);
        map.put(VALUE_480, FOUR_HUNDRED_AND_EIGHTY);
        map.put(VALUE_360P, THREE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_360, THREE_HUNDRED_AND_SIXTY);
        return map;
    }

    private static final Map<String, SourceAccessMediaSourceResolutionEnum> createEnumsMap() {
        Map<String, SourceAccessMediaSourceResolutionEnum> map = new HashMap<>();
        map.put(VALUE_2160P, SourceAccessMediaSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_2160, SourceAccessMediaSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(VALUE_1440P, SourceAccessMediaSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1440, SourceAccessMediaSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(VALUE_1080P, SourceAccessMediaSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_1080, SourceAccessMediaSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTY);
        map.put(VALUE_720P, SourceAccessMediaSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_720, SourceAccessMediaSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTY);
        map.put(VALUE_480P, SourceAccessMediaSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(VALUE_480, SourceAccessMediaSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTY);
        map.put(VALUE_360P, SourceAccessMediaSourceResolutionEnum.THREE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_360, SourceAccessMediaSourceResolutionEnum.THREE_HUNDRED_AND_SIXTY);
        return map;
    }


    public enum SourceAccessMediaSourceResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(VALUE_2160P),
        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY(VALUE_2160),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(VALUE_1440P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY(VALUE_1440),
        ONE_THOUSAND_AND_EIGHTYP(VALUE_1080P),
        ONE_THOUSAND_AND_EIGHTY(VALUE_1080),
        SEVEN_HUNDRED_AND_TWENTYP(VALUE_720P),
        SEVEN_HUNDRED_AND_TWENTY(VALUE_720),
        FOUR_HUNDRED_AND_EIGHTYP(VALUE_480P),
        FOUR_HUNDRED_AND_EIGHTY(VALUE_480),
        THREE_HUNDRED_AND_SIXTYP(VALUE_360P),
        THREE_HUNDRED_AND_SIXTY(VALUE_360),;

        private final String value;

        private SourceAccessMediaSourceResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
