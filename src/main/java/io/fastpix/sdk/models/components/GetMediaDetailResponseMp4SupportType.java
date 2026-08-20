package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseMp4SupportType
 *
 * <p>The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution,
 * `audioOnly` is a downloadable m4a audio-only file.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaDetailResponseMp4SupportType {

    private static final String VALUE_CAPPED_4K = "capped_4k";
    private static final String VALUE_AUDIO_ONLY = "audioOnly";

    public static final GetMediaDetailResponseMp4SupportType CAPPED4K = new GetMediaDetailResponseMp4SupportType(VALUE_CAPPED_4K);
    public static final GetMediaDetailResponseMp4SupportType AUDIO_ONLY = new GetMediaDetailResponseMp4SupportType(VALUE_AUDIO_ONLY);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseMp4SupportType> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseMp4SupportTypeEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseMp4SupportType(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseMp4SupportType with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as GetMediaDetailResponseMp4SupportType
     */
    @JsonCreator
    public static GetMediaDetailResponseMp4SupportType of(String value) {
        synchronized (GetMediaDetailResponseMp4SupportType.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseMp4SupportType::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseMp4SupportTypeEnum> asEnum() {
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
        GetMediaDetailResponseMp4SupportType other = (GetMediaDetailResponseMp4SupportType) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseMp4SupportType [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseMp4SupportType[] values() {
        synchronized (GetMediaDetailResponseMp4SupportType.class) {
            return values.values().toArray(new GetMediaDetailResponseMp4SupportType[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseMp4SupportType> createValuesMap() {
        Map<String, GetMediaDetailResponseMp4SupportType> map = new LinkedHashMap<>();
        map.put(VALUE_CAPPED_4K, CAPPED4K);
        map.put(VALUE_AUDIO_ONLY, AUDIO_ONLY);
        return map;
    }

    private static final Map<String, GetMediaDetailResponseMp4SupportTypeEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseMp4SupportTypeEnum> map = new HashMap<>();
        map.put(VALUE_CAPPED_4K, GetMediaDetailResponseMp4SupportTypeEnum.CAPPED4K);
        map.put(VALUE_AUDIO_ONLY, GetMediaDetailResponseMp4SupportTypeEnum.AUDIO_ONLY);
        return map;
    }


    public enum GetMediaDetailResponseMp4SupportTypeEnum {

        CAPPED4K(VALUE_CAPPED_4K),
        AUDIO_ONLY(VALUE_AUDIO_ONLY),;

        private final String value;

        private GetMediaDetailResponseMp4SupportTypeEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
