package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaMp4SupportExt
 *
 * <p>File extension of the downloadable rendition.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaMp4SupportExt {

    private static final String VALUE_MP4 = "mp4";
    private static final String VALUE_M4A = "m4a";

    public static final MediaMp4SupportExt MP4 = new MediaMp4SupportExt(VALUE_MP4);
    public static final MediaMp4SupportExt M4A = new MediaMp4SupportExt(VALUE_M4A);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaMp4SupportExt> values = createValuesMap();
    private static final Map<String, MediaMp4SupportExtEnum> enums = createEnumsMap();

    private final String value;

    private MediaMp4SupportExt(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaMp4SupportExt with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as MediaMp4SupportExt
     */
    @JsonCreator
    public static MediaMp4SupportExt of(String value) {
        synchronized (MediaMp4SupportExt.class) {
            return values.computeIfAbsent(value, MediaMp4SupportExt::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaMp4SupportExtEnum> asEnum() {
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
        MediaMp4SupportExt other = (MediaMp4SupportExt) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaMp4SupportExt [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaMp4SupportExt[] values() {
        synchronized (MediaMp4SupportExt.class) {
            return values.values().toArray(new MediaMp4SupportExt[] {});
        }
    }

    private static final Map<String, MediaMp4SupportExt> createValuesMap() {
        Map<String, MediaMp4SupportExt> map = new LinkedHashMap<>();
        map.put(VALUE_MP4, MP4);
        map.put(VALUE_M4A, M4A);
        return map;
    }

    private static final Map<String, MediaMp4SupportExtEnum> createEnumsMap() {
        Map<String, MediaMp4SupportExtEnum> map = new HashMap<>();
        map.put(VALUE_MP4, MediaMp4SupportExtEnum.MP4);
        map.put(VALUE_M4A, MediaMp4SupportExtEnum.M4A);
        return map;
    }


    public enum MediaMp4SupportExtEnum {

        MP4(VALUE_MP4),
        M4A(VALUE_M4A),;

        private final String value;

        private MediaMp4SupportExtEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
