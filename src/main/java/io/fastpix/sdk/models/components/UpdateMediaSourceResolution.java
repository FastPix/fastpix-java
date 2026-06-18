package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateMediaSourceResolution
 *
 * <p>The actual resolution of the uploaded media. This represents the native quality of the source media.
 */
public class UpdateMediaSourceResolution {

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

    public static final UpdateMediaSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new UpdateMediaSourceResolution(VALUE_2160P);
    public static final UpdateMediaSourceResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY = new UpdateMediaSourceResolution(VALUE_2160);
    public static final UpdateMediaSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new UpdateMediaSourceResolution(VALUE_1440P);
    public static final UpdateMediaSourceResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY = new UpdateMediaSourceResolution(VALUE_1440);
    public static final UpdateMediaSourceResolution ONE_THOUSAND_AND_EIGHTYP = new UpdateMediaSourceResolution(VALUE_1080P);
    public static final UpdateMediaSourceResolution ONE_THOUSAND_AND_EIGHTY = new UpdateMediaSourceResolution(VALUE_1080);
    public static final UpdateMediaSourceResolution SEVEN_HUNDRED_AND_TWENTYP = new UpdateMediaSourceResolution(VALUE_720P);
    public static final UpdateMediaSourceResolution SEVEN_HUNDRED_AND_TWENTY = new UpdateMediaSourceResolution(VALUE_720);
    public static final UpdateMediaSourceResolution FOUR_HUNDRED_AND_EIGHTYP = new UpdateMediaSourceResolution(VALUE_480P);
    public static final UpdateMediaSourceResolution FOUR_HUNDRED_AND_EIGHTY = new UpdateMediaSourceResolution(VALUE_480);
    public static final UpdateMediaSourceResolution THREE_HUNDRED_AND_SIXTYP = new UpdateMediaSourceResolution(VALUE_360P);
    public static final UpdateMediaSourceResolution THREE_HUNDRED_AND_SIXTY = new UpdateMediaSourceResolution(VALUE_360);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UpdateMediaSourceResolution> values = createValuesMap();
    private static final Map<String, UpdateMediaSourceResolutionEnum> enums = createEnumsMap();

    private final String value;

    private UpdateMediaSourceResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a UpdateMediaSourceResolution with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as UpdateMediaSourceResolution
     */
    @JsonCreator
    public static UpdateMediaSourceResolution of(String value) {
        synchronized (UpdateMediaSourceResolution.class) {
            return values.computeIfAbsent(value, UpdateMediaSourceResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UpdateMediaSourceResolutionEnum> asEnum() {
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
        UpdateMediaSourceResolution other = (UpdateMediaSourceResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UpdateMediaSourceResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static UpdateMediaSourceResolution[] values() {
        synchronized (UpdateMediaSourceResolution.class) {
            return values.values().toArray(new UpdateMediaSourceResolution[] {});
        }
    }

    private static final Map<String, UpdateMediaSourceResolution> createValuesMap() {
        Map<String, UpdateMediaSourceResolution> map = new LinkedHashMap<>();
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

    private static final Map<String, UpdateMediaSourceResolutionEnum> createEnumsMap() {
        Map<String, UpdateMediaSourceResolutionEnum> map = new HashMap<>();
        map.put(VALUE_2160P, UpdateMediaSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_2160, UpdateMediaSourceResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTY);
        map.put(VALUE_1440P, UpdateMediaSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1440, UpdateMediaSourceResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTY);
        map.put(VALUE_1080P, UpdateMediaSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_1080, UpdateMediaSourceResolutionEnum.ONE_THOUSAND_AND_EIGHTY);
        map.put(VALUE_720P, UpdateMediaSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_720, UpdateMediaSourceResolutionEnum.SEVEN_HUNDRED_AND_TWENTY);
        map.put(VALUE_480P, UpdateMediaSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        map.put(VALUE_480, UpdateMediaSourceResolutionEnum.FOUR_HUNDRED_AND_EIGHTY);
        map.put(VALUE_360P, UpdateMediaSourceResolutionEnum.THREE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_360, UpdateMediaSourceResolutionEnum.THREE_HUNDRED_AND_SIXTY);
        return map;
    }


    public enum UpdateMediaSourceResolutionEnum {

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

        private UpdateMediaSourceResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
