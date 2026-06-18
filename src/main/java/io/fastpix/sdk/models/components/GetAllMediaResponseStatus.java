package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetAllMediaResponseStatus
 *
 * <p>Determines the media's status, which can be one of the possible values.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetAllMediaResponseStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final GetAllMediaResponseStatus CREATED = new GetAllMediaResponseStatus(CREATED_VALUE);
    public static final GetAllMediaResponseStatus DOWNLOADING = new GetAllMediaResponseStatus(DOWNLOADING_VALUE);
    public static final GetAllMediaResponseStatus DOWNLOADED = new GetAllMediaResponseStatus(DOWNLOADED_VALUE);
    public static final GetAllMediaResponseStatus VALIDATING = new GetAllMediaResponseStatus(VALIDATING_VALUE);
    public static final GetAllMediaResponseStatus IN_QUEUE = new GetAllMediaResponseStatus(IN_QUEUE_VALUE);
    public static final GetAllMediaResponseStatus PROCESSING = new GetAllMediaResponseStatus(PROCESSING_VALUE);
    public static final GetAllMediaResponseStatus READY = new GetAllMediaResponseStatus(READY_VALUE);
    public static final GetAllMediaResponseStatus FAILED = new GetAllMediaResponseStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetAllMediaResponseStatus> values = createValuesMap();
    private static final Map<String, GetAllMediaResponseStatusEnum> enums = createEnumsMap();

    private final String value;

    private GetAllMediaResponseStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a GetAllMediaResponseStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as GetAllMediaResponseStatus
     */ 
    @JsonCreator
    public static GetAllMediaResponseStatus of(String value) {
        synchronized (GetAllMediaResponseStatus.class) {
            return values.computeIfAbsent(value, GetAllMediaResponseStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetAllMediaResponseStatusEnum> asEnum() {
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
        GetAllMediaResponseStatus other = (GetAllMediaResponseStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetAllMediaResponseStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetAllMediaResponseStatus[] values() {
        synchronized (GetAllMediaResponseStatus.class) {
            return values.values().toArray(new GetAllMediaResponseStatus[] {});
        }
    }

    private static final Map<String, GetAllMediaResponseStatus> createValuesMap() {
        Map<String, GetAllMediaResponseStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, GetAllMediaResponseStatusEnum> createEnumsMap() {
        Map<String, GetAllMediaResponseStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, GetAllMediaResponseStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, GetAllMediaResponseStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, GetAllMediaResponseStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, GetAllMediaResponseStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, GetAllMediaResponseStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, GetAllMediaResponseStatusEnum.PROCESSING);
        map.put(READY_VALUE, GetAllMediaResponseStatusEnum.READY);
        map.put(FAILED_VALUE, GetAllMediaResponseStatusEnum.FAILED);
        return map;
    }
    
    
    public enum GetAllMediaResponseStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private GetAllMediaResponseStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

