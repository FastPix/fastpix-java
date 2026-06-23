package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * LiveMediaClipsStatus
 *
 * <p>Determines the media's status, which can be one of the possible values.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class LiveMediaClipsStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final LiveMediaClipsStatus CREATED = new LiveMediaClipsStatus(CREATED_VALUE);
    public static final LiveMediaClipsStatus DOWNLOADING = new LiveMediaClipsStatus(DOWNLOADING_VALUE);
    public static final LiveMediaClipsStatus DOWNLOADED = new LiveMediaClipsStatus(DOWNLOADED_VALUE);
    public static final LiveMediaClipsStatus VALIDATING = new LiveMediaClipsStatus(VALIDATING_VALUE);
    public static final LiveMediaClipsStatus IN_QUEUE = new LiveMediaClipsStatus(IN_QUEUE_VALUE);
    public static final LiveMediaClipsStatus PROCESSING = new LiveMediaClipsStatus(PROCESSING_VALUE);
    public static final LiveMediaClipsStatus READY = new LiveMediaClipsStatus(READY_VALUE);
    public static final LiveMediaClipsStatus FAILED = new LiveMediaClipsStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, LiveMediaClipsStatus> values = createValuesMap();
    private static final Map<String, LiveMediaClipsStatusEnum> enums = createEnumsMap();

    private final String value;

    private LiveMediaClipsStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a LiveMediaClipsStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as LiveMediaClipsStatus
     */ 
    @JsonCreator
    public static LiveMediaClipsStatus of(String value) {
        synchronized (LiveMediaClipsStatus.class) {
            return values.computeIfAbsent(value, LiveMediaClipsStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<LiveMediaClipsStatusEnum> asEnum() {
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
        LiveMediaClipsStatus other = (LiveMediaClipsStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "LiveMediaClipsStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static LiveMediaClipsStatus[] values() {
        synchronized (LiveMediaClipsStatus.class) {
            return values.values().toArray(new LiveMediaClipsStatus[] {});
        }
    }

    private static final Map<String, LiveMediaClipsStatus> createValuesMap() {
        Map<String, LiveMediaClipsStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, LiveMediaClipsStatusEnum> createEnumsMap() {
        Map<String, LiveMediaClipsStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, LiveMediaClipsStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, LiveMediaClipsStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, LiveMediaClipsStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, LiveMediaClipsStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, LiveMediaClipsStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, LiveMediaClipsStatusEnum.PROCESSING);
        map.put(READY_VALUE, LiveMediaClipsStatusEnum.READY);
        map.put(FAILED_VALUE, LiveMediaClipsStatusEnum.FAILED);
        return map;
    }
    
    
    public enum LiveMediaClipsStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private LiveMediaClipsStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

