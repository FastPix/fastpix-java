package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaResponseMaxResolution
 *
 * <p>The maximum resolution specified by the user for the media.
 */
public class GetMediaResponseMaxResolution {

    private static final String VALUE_2160P = "2160p";
    private static final String VALUE_1440P = "1440p";
    private static final String VALUE_1080P = "1080p";
    private static final String VALUE_720P = "720p";
    private static final String VALUE_480P = "480p";

    public static final GetMediaResponseMaxResolution TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP = new GetMediaResponseMaxResolution(VALUE_2160P);
    public static final GetMediaResponseMaxResolution ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP = new GetMediaResponseMaxResolution(VALUE_1440P);
    public static final GetMediaResponseMaxResolution ONE_THOUSAND_AND_EIGHTYP = new GetMediaResponseMaxResolution(VALUE_1080P);
    public static final GetMediaResponseMaxResolution SEVEN_HUNDRED_AND_TWENTYP = new GetMediaResponseMaxResolution(VALUE_720P);
    public static final GetMediaResponseMaxResolution FOUR_HUNDRED_AND_EIGHTYP = new GetMediaResponseMaxResolution(VALUE_480P);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaResponseMaxResolution> values = createValuesMap();
    private static final Map<String, GetMediaResponseMaxResolutionEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaResponseMaxResolution(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaResponseMaxResolution with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as GetMediaResponseMaxResolution
     */
    @JsonCreator
    public static GetMediaResponseMaxResolution of(String value) {
        synchronized (GetMediaResponseMaxResolution.class) {
            return values.computeIfAbsent(value, GetMediaResponseMaxResolution::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaResponseMaxResolutionEnum> asEnum() {
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
        GetMediaResponseMaxResolution other = (GetMediaResponseMaxResolution) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaResponseMaxResolution [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaResponseMaxResolution[] values() {
        synchronized (GetMediaResponseMaxResolution.class) {
            return values.values().toArray(new GetMediaResponseMaxResolution[] {});
        }
    }

    private static final Map<String, GetMediaResponseMaxResolution> createValuesMap() {
        Map<String, GetMediaResponseMaxResolution> map = new LinkedHashMap<>();
        map.put(VALUE_2160P, TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_1440P, ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1080P, ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_720P, SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_480P, FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }

    private static final Map<String, GetMediaResponseMaxResolutionEnum> createEnumsMap() {
        Map<String, GetMediaResponseMaxResolutionEnum> map = new HashMap<>();
        map.put(VALUE_2160P, GetMediaResponseMaxResolutionEnum.TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP);
        map.put(VALUE_1440P, GetMediaResponseMaxResolutionEnum.ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP);
        map.put(VALUE_1080P, GetMediaResponseMaxResolutionEnum.ONE_THOUSAND_AND_EIGHTYP);
        map.put(VALUE_720P, GetMediaResponseMaxResolutionEnum.SEVEN_HUNDRED_AND_TWENTYP);
        map.put(VALUE_480P, GetMediaResponseMaxResolutionEnum.FOUR_HUNDRED_AND_EIGHTYP);
        return map;
    }


    public enum GetMediaResponseMaxResolutionEnum {

        TWO_THOUSAND_ONE_HUNDRED_AND_SIXTYP(VALUE_2160P),
        ONE_THOUSAND_FOUR_HUNDRED_AND_FORTYP(VALUE_1440P),
        ONE_THOUSAND_AND_EIGHTYP(VALUE_1080P),
        SEVEN_HUNDRED_AND_TWENTYP(VALUE_720P),
        FOUR_HUNDRED_AND_EIGHTYP(VALUE_480P),;

        private final String value;

        private GetMediaResponseMaxResolutionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
