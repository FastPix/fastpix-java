package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseMp4SupportExt
 *
 * <p>File extension of the downloadable rendition.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaDetailResponseMp4SupportExt {

    private static final String VALUE_MP4 = "mp4";
    private static final String VALUE_M4A = "m4a";

    public static final GetMediaDetailResponseMp4SupportExt MP4 = new GetMediaDetailResponseMp4SupportExt(VALUE_MP4);
    public static final GetMediaDetailResponseMp4SupportExt M4A = new GetMediaDetailResponseMp4SupportExt(VALUE_M4A);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseMp4SupportExt> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseMp4SupportExtEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseMp4SupportExt(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseMp4SupportExt with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as GetMediaDetailResponseMp4SupportExt
     */
    @JsonCreator
    public static GetMediaDetailResponseMp4SupportExt of(String value) {
        synchronized (GetMediaDetailResponseMp4SupportExt.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseMp4SupportExt::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseMp4SupportExtEnum> asEnum() {
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
        GetMediaDetailResponseMp4SupportExt other = (GetMediaDetailResponseMp4SupportExt) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseMp4SupportExt [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseMp4SupportExt[] values() {
        synchronized (GetMediaDetailResponseMp4SupportExt.class) {
            return values.values().toArray(new GetMediaDetailResponseMp4SupportExt[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseMp4SupportExt> createValuesMap() {
        Map<String, GetMediaDetailResponseMp4SupportExt> map = new LinkedHashMap<>();
        map.put(VALUE_MP4, MP4);
        map.put(VALUE_M4A, M4A);
        return map;
    }

    private static final Map<String, GetMediaDetailResponseMp4SupportExtEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseMp4SupportExtEnum> map = new HashMap<>();
        map.put(VALUE_MP4, GetMediaDetailResponseMp4SupportExtEnum.MP4);
        map.put(VALUE_M4A, GetMediaDetailResponseMp4SupportExtEnum.M4A);
        return map;
    }


    public enum GetMediaDetailResponseMp4SupportExtEnum {

        MP4(VALUE_MP4),
        M4A(VALUE_M4A),;

        private final String value;

        private GetMediaDetailResponseMp4SupportExtEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
