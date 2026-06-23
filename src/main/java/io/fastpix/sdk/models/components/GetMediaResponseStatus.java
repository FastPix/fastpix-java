package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaResponseStatus
 *
 * <p>Determines the media's status, which can be one of the possible values.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaResponseStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final GetMediaResponseStatus CREATED = new GetMediaResponseStatus(CREATED_VALUE);
    public static final GetMediaResponseStatus DOWNLOADING = new GetMediaResponseStatus(DOWNLOADING_VALUE);
    public static final GetMediaResponseStatus DOWNLOADED = new GetMediaResponseStatus(DOWNLOADED_VALUE);
    public static final GetMediaResponseStatus VALIDATING = new GetMediaResponseStatus(VALIDATING_VALUE);
    public static final GetMediaResponseStatus IN_QUEUE = new GetMediaResponseStatus(IN_QUEUE_VALUE);
    public static final GetMediaResponseStatus PROCESSING = new GetMediaResponseStatus(PROCESSING_VALUE);
    public static final GetMediaResponseStatus READY = new GetMediaResponseStatus(READY_VALUE);
    public static final GetMediaResponseStatus FAILED = new GetMediaResponseStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaResponseStatus> values = createValuesMap();
    private static final Map<String, GetMediaResponseStatusEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaResponseStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaResponseStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetMediaResponseStatus
     */ 
    @JsonCreator
    public static GetMediaResponseStatus of(String value) {
        synchronized (GetMediaResponseStatus.class) {
            return values.computeIfAbsent(value, GetMediaResponseStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaResponseStatusEnum> asEnum() {
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
        GetMediaResponseStatus other = (GetMediaResponseStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaResponseStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaResponseStatus[] values() {
        synchronized (GetMediaResponseStatus.class) {
            return values.values().toArray(new GetMediaResponseStatus[] {});
        }
    }

    private static final Map<String, GetMediaResponseStatus> createValuesMap() {
        Map<String, GetMediaResponseStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, GetMediaResponseStatusEnum> createEnumsMap() {
        Map<String, GetMediaResponseStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, GetMediaResponseStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, GetMediaResponseStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, GetMediaResponseStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, GetMediaResponseStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, GetMediaResponseStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, GetMediaResponseStatusEnum.PROCESSING);
        map.put(READY_VALUE, GetMediaResponseStatusEnum.READY);
        map.put(FAILED_VALUE, GetMediaResponseStatusEnum.FAILED);
        return map;
    }
    
    
    public enum GetMediaResponseStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private GetMediaResponseStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

