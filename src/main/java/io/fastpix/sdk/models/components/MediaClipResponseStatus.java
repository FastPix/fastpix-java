package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaClipResponseStatus
 *
 * <p>The current processing status of the media.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaClipResponseStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final MediaClipResponseStatus CREATED = new MediaClipResponseStatus(CREATED_VALUE);
    public static final MediaClipResponseStatus DOWNLOADING = new MediaClipResponseStatus(DOWNLOADING_VALUE);
    public static final MediaClipResponseStatus DOWNLOADED = new MediaClipResponseStatus(DOWNLOADED_VALUE);
    public static final MediaClipResponseStatus VALIDATING = new MediaClipResponseStatus(VALIDATING_VALUE);
    public static final MediaClipResponseStatus IN_QUEUE = new MediaClipResponseStatus(IN_QUEUE_VALUE);
    public static final MediaClipResponseStatus PROCESSING = new MediaClipResponseStatus(PROCESSING_VALUE);
    public static final MediaClipResponseStatus READY = new MediaClipResponseStatus(READY_VALUE);
    public static final MediaClipResponseStatus FAILED = new MediaClipResponseStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaClipResponseStatus> values = createValuesMap();
    private static final Map<String, MediaClipResponseStatusEnum> enums = createEnumsMap();

    private final String value;

    private MediaClipResponseStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaClipResponseStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as MediaClipResponseStatus
     */ 
    @JsonCreator
    public static MediaClipResponseStatus of(String value) {
        synchronized (MediaClipResponseStatus.class) {
            return values.computeIfAbsent(value, MediaClipResponseStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaClipResponseStatusEnum> asEnum() {
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
        MediaClipResponseStatus other = (MediaClipResponseStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaClipResponseStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaClipResponseStatus[] values() {
        synchronized (MediaClipResponseStatus.class) {
            return values.values().toArray(new MediaClipResponseStatus[] {});
        }
    }

    private static final Map<String, MediaClipResponseStatus> createValuesMap() {
        Map<String, MediaClipResponseStatus> map = new LinkedHashMap<>();
        map.put(CREATED_VALUE, CREATED);
        map.put(DOWNLOADING_VALUE, DOWNLOADING);
        map.put(DOWNLOADED_VALUE, DOWNLOADED);
        map.put(VALIDATING_VALUE, VALIDATING);
        map.put(IN_QUEUE_VALUE, IN_QUEUE);
        map.put(PROCESSING_VALUE, PROCESSING);
        map.put(READY_VALUE, READY);
        map.put(FAILED_VALUE, FAILED);
        return map;
    }

    private static final Map<String, MediaClipResponseStatusEnum> createEnumsMap() {
        Map<String, MediaClipResponseStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, MediaClipResponseStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, MediaClipResponseStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, MediaClipResponseStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, MediaClipResponseStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, MediaClipResponseStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, MediaClipResponseStatusEnum.PROCESSING);
        map.put(READY_VALUE, MediaClipResponseStatusEnum.READY);
        map.put(FAILED_VALUE, MediaClipResponseStatusEnum.FAILED);
        return map;
    }
    
    
    public enum MediaClipResponseStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private MediaClipResponseStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

