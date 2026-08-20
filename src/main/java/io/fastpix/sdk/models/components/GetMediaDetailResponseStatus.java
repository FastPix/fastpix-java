package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseStatus
 *
 * <p>Determines the media's status, which can be one of the possible values.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaDetailResponseStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final GetMediaDetailResponseStatus CREATED = new GetMediaDetailResponseStatus(CREATED_VALUE);
    public static final GetMediaDetailResponseStatus DOWNLOADING = new GetMediaDetailResponseStatus(DOWNLOADING_VALUE);
    public static final GetMediaDetailResponseStatus DOWNLOADED = new GetMediaDetailResponseStatus(DOWNLOADED_VALUE);
    public static final GetMediaDetailResponseStatus VALIDATING = new GetMediaDetailResponseStatus(VALIDATING_VALUE);
    public static final GetMediaDetailResponseStatus IN_QUEUE = new GetMediaDetailResponseStatus(IN_QUEUE_VALUE);
    public static final GetMediaDetailResponseStatus PROCESSING = new GetMediaDetailResponseStatus(PROCESSING_VALUE);
    public static final GetMediaDetailResponseStatus READY = new GetMediaDetailResponseStatus(READY_VALUE);
    public static final GetMediaDetailResponseStatus FAILED = new GetMediaDetailResponseStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseStatus> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseStatusEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetMediaDetailResponseStatus
     */ 
    @JsonCreator
    public static GetMediaDetailResponseStatus of(String value) {
        synchronized (GetMediaDetailResponseStatus.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseStatusEnum> asEnum() {
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
        GetMediaDetailResponseStatus other = (GetMediaDetailResponseStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseStatus[] values() {
        synchronized (GetMediaDetailResponseStatus.class) {
            return values.values().toArray(new GetMediaDetailResponseStatus[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseStatus> createValuesMap() {
        Map<String, GetMediaDetailResponseStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, GetMediaDetailResponseStatusEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, GetMediaDetailResponseStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, GetMediaDetailResponseStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, GetMediaDetailResponseStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, GetMediaDetailResponseStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, GetMediaDetailResponseStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, GetMediaDetailResponseStatusEnum.PROCESSING);
        map.put(READY_VALUE, GetMediaDetailResponseStatusEnum.READY);
        map.put(FAILED_VALUE, GetMediaDetailResponseStatusEnum.FAILED);
        return map;
    }
    
    
    public enum GetMediaDetailResponseStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private GetMediaDetailResponseStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

