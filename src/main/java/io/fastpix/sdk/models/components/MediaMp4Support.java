package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaMp4Support
 *
 * <p>Determines the type of MP4 support for the media.
 * - **none**: Disables MP4 support.
 * - **capped_4k**: Enables MP4 downloads with resolutions up to 4K.
 * - **audioOnly**: Provides an MP4 stream containing only the audio.
 * - **audioOnly,capped_4k**: Enables both MP4 video downloads (up to 4K) and an audio-only stream.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaMp4Support {

    private static final String NONE_VALUE = "none";
    private static final String CAPPED_4K_VALUE = "capped_4k";
    private static final String AUDIO_ONLY_VALUE = "audioOnly";
    private static final String AUDIO_ONLY_CAPPED_4K_VALUE = "audioOnly,capped_4k";

    public static final MediaMp4Support NONE = new MediaMp4Support(NONE_VALUE);
    public static final MediaMp4Support CAPPED4K = new MediaMp4Support(CAPPED_4K_VALUE);
    public static final MediaMp4Support AUDIO_ONLY = new MediaMp4Support(AUDIO_ONLY_VALUE);
    public static final MediaMp4Support AUDIO_ONLY_CAPPED4K = new MediaMp4Support(AUDIO_ONLY_CAPPED_4K_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaMp4Support> values = createValuesMap();
    private static final Map<String, MediaMp4SupportEnum> enums = createEnumsMap();

    private final String value;

    private MediaMp4Support(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaMp4Support with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as MediaMp4Support
     */ 
    @JsonCreator
    public static MediaMp4Support of(String value) {
        synchronized (MediaMp4Support.class) {
            return values.computeIfAbsent(value, MediaMp4Support::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaMp4SupportEnum> asEnum() {
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
        MediaMp4Support other = (MediaMp4Support) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaMp4Support [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaMp4Support[] values() {
        synchronized (MediaMp4Support.class) {
            return values.values().toArray(new MediaMp4Support[] {});
        }
    }

    private static final Map<String, MediaMp4Support> createValuesMap() {
        Map<String, MediaMp4Support> map = new LinkedHashMap<>();
        map.put(NONE_VALUE, NONE);
        map.put(CAPPED_4K_VALUE, CAPPED4K);
        map.put(AUDIO_ONLY_VALUE, AUDIO_ONLY);
        map.put(AUDIO_ONLY_CAPPED_4K_VALUE, AUDIO_ONLY_CAPPED4K);
        return map;
    }

    private static final Map<String, MediaMp4SupportEnum> createEnumsMap() {
        Map<String, MediaMp4SupportEnum> map = new HashMap<>();
        map.put(NONE_VALUE, MediaMp4SupportEnum.NONE);
        map.put(CAPPED_4K_VALUE, MediaMp4SupportEnum.CAPPED4K);
        map.put(AUDIO_ONLY_VALUE, MediaMp4SupportEnum.AUDIO_ONLY);
        map.put(AUDIO_ONLY_CAPPED_4K_VALUE, MediaMp4SupportEnum.AUDIO_ONLY_CAPPED4K);
        return map;
    }
    
    
    public enum MediaMp4SupportEnum {

        NONE(NONE_VALUE),
        CAPPED4K(CAPPED_4K_VALUE),
        AUDIO_ONLY(AUDIO_ONLY_VALUE),
        AUDIO_ONLY_CAPPED4K(AUDIO_ONLY_CAPPED_4K_VALUE),;

        private final String value;

        private MediaMp4SupportEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

