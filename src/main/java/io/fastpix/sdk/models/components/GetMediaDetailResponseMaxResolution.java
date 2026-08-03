package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseMaxResolution
 *
 * <p>The maximum resolution specified by the user for the media.
 */
public class GetMediaDetailResponseMaxResolution {

    private static final String VALUE_2160P = "2160p";
    private static final String VALUE_1440P = "1440p";
    private static final String VALUE_1080P = "1080p";
    private static final String VALUE_720P = "720p";
    private static final String VALUE_480P = "480p";

    public static final GetMediaDetailResponseMaxResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new GetMediaDetailResponseMaxResolution(VALUE_2160P);
    public static final GetMediaDetailResponseMaxResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new GetMediaDetailResponseMaxResolution(VALUE_1440P);
    public static final GetMediaDetailResponseMaxResolution ONE_THOUSAND_AND_EIGHTYP = new GetMediaDetailResponseMaxResolution(VALUE_1080P);
    public static final GetMediaDetailResponseMaxResolution SEVEN_HUNDRED_AND_TWENTYP = new GetMediaDetailResponseMaxResolution(VALUE_720P);
    public static final GetMediaDetailResponseMaxResolution FOUR_HUNDRED_AND_EIGHTYP = new GetMediaDetailResponseMaxResolution(VALUE_480P);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseMaxResolution> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseMaxResolutionEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseMaxResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseMaxResolution with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as GetMediaDetailResponseMaxResolution
     */
    @JsonCreator
    public static GetMediaDetailResponseMaxResolution of(String value) {
        synchronized (GetMediaDetailResponseMaxResolution.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseMaxResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseMaxResolutionEnum> asEnum() {
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
        GetMediaDetailResponseMaxResolution other = (GetMediaDetailResponseMaxResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseMaxResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseMaxResolution[] values() {
        synchronized (GetMediaDetailResponseMaxResolution.class) {
            return values.values().toArray(new GetMediaDetailResponseMaxResolution[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseMaxResolution> createValuesMap() {
        Map<String, GetMediaDetailResponseMaxResolution> map = new LinkedHashMap<>();
        map.put(VALUE_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_480P, FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }

    private static final Map<String, GetMediaDetailResponseMaxResolutionEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseMaxResolutionEnum> map = new HashMap<>();
        map.put(VALUE_2160P, GetMediaDetailResponseMaxResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_1440P, GetMediaDetailResponseMaxResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1080P, GetMediaDetailResponseMaxResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_720P, GetMediaDetailResponseMaxResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_480P, GetMediaDetailResponseMaxResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }


    public enum GetMediaDetailResponseMaxResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(VALUE_2160P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(VALUE_1440P),
        ONE_THOUSAND_AND_EIGHTYP(VALUE_1080P),
        SEVEN_HUNDRED_AND_TWENTYP(VALUE_720P),
        FOUR_HUNDRED_AND_EIGHTYP(VALUE_480P),;

        private final String value;

        private GetMediaDetailResponseMaxResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
