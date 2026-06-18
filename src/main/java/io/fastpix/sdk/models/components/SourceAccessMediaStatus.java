package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * SourceAccessMediaStatus
 *
 * <p>Determines the media's status, which can be one of the possible values.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class SourceAccessMediaStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final SourceAccessMediaStatus CREATED = new SourceAccessMediaStatus(CREATED_VALUE);
    public static final SourceAccessMediaStatus DOWNLOADING = new SourceAccessMediaStatus(DOWNLOADING_VALUE);
    public static final SourceAccessMediaStatus DOWNLOADED = new SourceAccessMediaStatus(DOWNLOADED_VALUE);
    public static final SourceAccessMediaStatus VALIDATING = new SourceAccessMediaStatus(VALIDATING_VALUE);
    public static final SourceAccessMediaStatus IN_QUEUE = new SourceAccessMediaStatus(IN_QUEUE_VALUE);
    public static final SourceAccessMediaStatus PROCESSING = new SourceAccessMediaStatus(PROCESSING_VALUE);
    public static final SourceAccessMediaStatus READY = new SourceAccessMediaStatus(READY_VALUE);
    public static final SourceAccessMediaStatus FAILED = new SourceAccessMediaStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, SourceAccessMediaStatus> values = createValuesMap();
    private static final Map<String, SourceAccessMediaStatusEnum> enums = createEnumsMap();

    private final String value;

    private SourceAccessMediaStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a SourceAccessMediaStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as SourceAccessMediaStatus
     */ 
    @JsonCreator
    public static SourceAccessMediaStatus of(String value) {
        synchronized (SourceAccessMediaStatus.class) {
            return values.computeIfAbsent(value, SourceAccessMediaStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<SourceAccessMediaStatusEnum> asEnum() {
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
        SourceAccessMediaStatus other = (SourceAccessMediaStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "SourceAccessMediaStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static SourceAccessMediaStatus[] values() {
        synchronized (SourceAccessMediaStatus.class) {
            return values.values().toArray(new SourceAccessMediaStatus[] {});
        }
    }

    private static final Map<String, SourceAccessMediaStatus> createValuesMap() {
        Map<String, SourceAccessMediaStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, SourceAccessMediaStatusEnum> createEnumsMap() {
        Map<String, SourceAccessMediaStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, SourceAccessMediaStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, SourceAccessMediaStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, SourceAccessMediaStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, SourceAccessMediaStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, SourceAccessMediaStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, SourceAccessMediaStatusEnum.PROCESSING);
        map.put(READY_VALUE, SourceAccessMediaStatusEnum.READY);
        map.put(FAILED_VALUE, SourceAccessMediaStatusEnum.FAILED);
        return map;
    }
    
    
    public enum SourceAccessMediaStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private SourceAccessMediaStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

