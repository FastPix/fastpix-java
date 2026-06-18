package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaResponseMp4Support
 *
 * <p>Determines the type of MP4 support for the media.
 * - **none**: Disables MP4 support.
 * - **capped_4k**: Enables MP4 downloads with resolutions up to 4K.
 * - **audioOnly**: Provides an MP4 stream containing only the audio.
 * - **audioOnly,capped_4k**: Enables both MP4 video downloads (up to 4K) and an audio-only stream.
 */
public class GetMediaResponseMp4Support {

    private static final String VALUE_NONE = "none";
    private static final String VALUE_CAPPED_4K = "capped_4k";
    private static final String VALUE_AUDIO_ONLY = "audioOnly";
    private static final String VALUE_AUDIO_ONLY_CAPPED_4K = "audioOnly,capped_4k";

    public static final GetMediaResponseMp4Support NONE = new GetMediaResponseMp4Support(VALUE_NONE);
    public static final GetMediaResponseMp4Support CAPPED4K = new GetMediaResponseMp4Support(VALUE_CAPPED_4K);
    public static final GetMediaResponseMp4Support AUDIO_ONLY = new GetMediaResponseMp4Support(VALUE_AUDIO_ONLY);
    public static final GetMediaResponseMp4Support AUDIO_ONLY_CAPPED4K = new GetMediaResponseMp4Support(VALUE_AUDIO_ONLY_CAPPED_4K);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaResponseMp4Support> values = createValuesMap();
    private static final Map<String, GetMediaResponseMp4SupportEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaResponseMp4Support(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaResponseMp4Support with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as GetMediaResponseMp4Support
     */
    @JsonCreator
    public static GetMediaResponseMp4Support of(String value) {
        synchronized (GetMediaResponseMp4Support.class) {
            return values.computeIfAbsent(value, GetMediaResponseMp4Support::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaResponseMp4SupportEnum> asEnum() {
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
        GetMediaResponseMp4Support other = (GetMediaResponseMp4Support) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaResponseMp4Support [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaResponseMp4Support[] values() {
        synchronized (GetMediaResponseMp4Support.class) {
            return values.values().toArray(new GetMediaResponseMp4Support[] {});
        }
    }

    private static final Map<String, GetMediaResponseMp4Support> createValuesMap() {
        Map<String, GetMediaResponseMp4Support> map = new LinkedHashMap<>();
        map.put(VALUE_NONE, NONE);
        map.put(VALUE_CAPPED_4K, CAPPED4K);
        map.put(VALUE_AUDIO_ONLY, AUDIO_ONLY);
        map.put(VALUE_AUDIO_ONLY_CAPPED_4K, AUDIO_ONLY_CAPPED4K);
        return map;
    }

    private static final Map<String, GetMediaResponseMp4SupportEnum> createEnumsMap() {
        Map<String, GetMediaResponseMp4SupportEnum> map = new HashMap<>();
        map.put(VALUE_NONE, GetMediaResponseMp4SupportEnum.NONE);
        map.put(VALUE_CAPPED_4K, GetMediaResponseMp4SupportEnum.CAPPED4K);
        map.put(VALUE_AUDIO_ONLY, GetMediaResponseMp4SupportEnum.AUDIO_ONLY);
        map.put(VALUE_AUDIO_ONLY_CAPPED_4K, GetMediaResponseMp4SupportEnum.AUDIO_ONLY_CAPPED4K);
        return map;
    }


    public enum GetMediaResponseMp4SupportEnum {

        NONE(VALUE_NONE),
        CAPPED4K(VALUE_CAPPED_4K),
        AUDIO_ONLY(VALUE_AUDIO_ONLY),
        AUDIO_ONLY_CAPPED4K(VALUE_AUDIO_ONLY_CAPPED_4K),;

        private final String value;

        private GetMediaResponseMp4SupportEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
