package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MediaStatus
 *
 * <p>Determines the media’s status, which can be one of the possible values.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class MediaStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final MediaStatus CREATED = new MediaStatus(CREATED_VALUE);
    public static final MediaStatus DOWNLOADING = new MediaStatus(DOWNLOADING_VALUE);
    public static final MediaStatus DOWNLOADED = new MediaStatus(DOWNLOADED_VALUE);
    public static final MediaStatus VALIDATING = new MediaStatus(VALIDATING_VALUE);
    public static final MediaStatus IN_QUEUE = new MediaStatus(IN_QUEUE_VALUE);
    public static final MediaStatus PROCESSING = new MediaStatus(PROCESSING_VALUE);
    public static final MediaStatus READY = new MediaStatus(READY_VALUE);
    public static final MediaStatus FAILED = new MediaStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, MediaStatus> values = createValuesMap();
    private static final Map<String, MediaStatusEnum> enums = createEnumsMap();

    private final String value;

    private MediaStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a MediaStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as MediaStatus
     */ 
    @JsonCreator
    public static MediaStatus of(String value) {
        synchronized (MediaStatus.class) {
            return values.computeIfAbsent(value, MediaStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<MediaStatusEnum> asEnum() {
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
        MediaStatus other = (MediaStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "MediaStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static MediaStatus[] values() {
        synchronized (MediaStatus.class) {
            return values.values().toArray(new MediaStatus[] {});
        }
    }

    private static final Map<String, MediaStatus> createValuesMap() {
        Map<String, MediaStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, MediaStatusEnum> createEnumsMap() {
        Map<String, MediaStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, MediaStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, MediaStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, MediaStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, MediaStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, MediaStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, MediaStatusEnum.PROCESSING);
        map.put(READY_VALUE, MediaStatusEnum.READY);
        map.put(FAILED_VALUE, MediaStatusEnum.FAILED);
        return map;
    }
    
    
    public enum MediaStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private MediaStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

