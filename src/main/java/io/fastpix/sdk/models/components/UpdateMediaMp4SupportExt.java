package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateMediaMp4SupportExt
 *
 * <p>File extension of the downloadable rendition.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class UpdateMediaMp4SupportExt {

    private static final String VALUE_MP4 = "mp4";
    private static final String VALUE_M4A = "m4a";

    public static final UpdateMediaMp4SupportExt MP4 = new UpdateMediaMp4SupportExt(VALUE_MP4);
    public static final UpdateMediaMp4SupportExt M4A = new UpdateMediaMp4SupportExt(VALUE_M4A);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UpdateMediaMp4SupportExt> values = createValuesMap();
    private static final Map<String, UpdateMediaMp4SupportExtEnum> enums = createEnumsMap();

    private final String value;

    private UpdateMediaMp4SupportExt(String value) {
        this.value = value;
    }

    /**
     * Returns a UpdateMediaMp4SupportExt with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as UpdateMediaMp4SupportExt
     */
    @JsonCreator
    public static UpdateMediaMp4SupportExt of(String value) {
        synchronized (UpdateMediaMp4SupportExt.class) {
            return values.computeIfAbsent(value, UpdateMediaMp4SupportExt::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UpdateMediaMp4SupportExtEnum> asEnum() {
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
        UpdateMediaMp4SupportExt other = (UpdateMediaMp4SupportExt) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UpdateMediaMp4SupportExt [value=" + value + "]";
    }

    // return an array just like an enum
    public static UpdateMediaMp4SupportExt[] values() {
        synchronized (UpdateMediaMp4SupportExt.class) {
            return values.values().toArray(new UpdateMediaMp4SupportExt[] {});
        }
    }

    private static final Map<String, UpdateMediaMp4SupportExt> createValuesMap() {
        Map<String, UpdateMediaMp4SupportExt> map = new LinkedHashMap<>();
        map.put(VALUE_MP4, MP4);
        map.put(VALUE_M4A, M4A);
        return map;
    }

    private static final Map<String, UpdateMediaMp4SupportExtEnum> createEnumsMap() {
        Map<String, UpdateMediaMp4SupportExtEnum> map = new HashMap<>();
        map.put(VALUE_MP4, UpdateMediaMp4SupportExtEnum.MP4);
        map.put(VALUE_M4A, UpdateMediaMp4SupportExtEnum.M4A);
        return map;
    }


    public enum UpdateMediaMp4SupportExtEnum {

        MP4(VALUE_MP4),
        M4A(VALUE_M4A),;

        private final String value;

        private UpdateMediaMp4SupportExtEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
