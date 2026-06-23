package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * CreateMediaResponseStatus
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 *
 * <p>Determines the media's status, which can be one of the possible values.
 */
public class CreateMediaResponseStatus {

    private static final String CREATED_VALUE = "Created";
    private static final String DOWNLOADING_VALUE = "Downloading";
    private static final String DOWNLOADED_VALUE = "Downloaded";
    private static final String VALIDATING_VALUE = "Validating";
    private static final String IN_QUEUE_VALUE = "In Queue";
    private static final String PROCESSING_VALUE = "Processing";
    private static final String READY_VALUE = "Ready";
    private static final String FAILED_VALUE = "Failed";

    public static final CreateMediaResponseStatus CREATED = new CreateMediaResponseStatus(CREATED_VALUE);
    public static final CreateMediaResponseStatus DOWNLOADING = new CreateMediaResponseStatus(DOWNLOADING_VALUE);
    public static final CreateMediaResponseStatus DOWNLOADED = new CreateMediaResponseStatus(DOWNLOADED_VALUE);
    public static final CreateMediaResponseStatus VALIDATING = new CreateMediaResponseStatus(VALIDATING_VALUE);
    public static final CreateMediaResponseStatus IN_QUEUE = new CreateMediaResponseStatus(IN_QUEUE_VALUE);
    public static final CreateMediaResponseStatus PROCESSING = new CreateMediaResponseStatus(PROCESSING_VALUE);
    public static final CreateMediaResponseStatus READY = new CreateMediaResponseStatus(READY_VALUE);
    public static final CreateMediaResponseStatus FAILED = new CreateMediaResponseStatus(FAILED_VALUE);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, CreateMediaResponseStatus> values = createValuesMap();
    private static final Map<String, CreateMediaResponseStatusEnum> enums = createEnumsMap();

    private final String value;

    private CreateMediaResponseStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a CreateMediaResponseStatus with the given value. For a specific value the 
     * returned object will always be a singleton so reference equality 
     * is satisfied when the values are the same.
     * 
     * @param value value to be wrapped as CreateMediaResponseStatus
     */ 
    @JsonCreator
    public static CreateMediaResponseStatus of(String value) {
        synchronized (CreateMediaResponseStatus.class) {
            return values.computeIfAbsent(value, CreateMediaResponseStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<CreateMediaResponseStatusEnum> asEnum() {
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
        CreateMediaResponseStatus other = (CreateMediaResponseStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "CreateMediaResponseStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static CreateMediaResponseStatus[] values() {
        synchronized (CreateMediaResponseStatus.class) {
            return values.values().toArray(new CreateMediaResponseStatus[] {});
        }
    }

    private static final Map<String, CreateMediaResponseStatus> createValuesMap() {
        Map<String, CreateMediaResponseStatus> map = new LinkedHashMap<>();
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

    private static final Map<String, CreateMediaResponseStatusEnum> createEnumsMap() {
        Map<String, CreateMediaResponseStatusEnum> map = new HashMap<>();
        map.put(CREATED_VALUE, CreateMediaResponseStatusEnum.CREATED);
        map.put(DOWNLOADING_VALUE, CreateMediaResponseStatusEnum.DOWNLOADING);
        map.put(DOWNLOADED_VALUE, CreateMediaResponseStatusEnum.DOWNLOADED);
        map.put(VALIDATING_VALUE, CreateMediaResponseStatusEnum.VALIDATING);
        map.put(IN_QUEUE_VALUE, CreateMediaResponseStatusEnum.IN_QUEUE);
        map.put(PROCESSING_VALUE, CreateMediaResponseStatusEnum.PROCESSING);
        map.put(READY_VALUE, CreateMediaResponseStatusEnum.READY);
        map.put(FAILED_VALUE, CreateMediaResponseStatusEnum.FAILED);
        return map;
    }
    
    
    public enum CreateMediaResponseStatusEnum {

        CREATED(CREATED_VALUE),
        DOWNLOADING(DOWNLOADING_VALUE),
        DOWNLOADED(DOWNLOADED_VALUE),
        VALIDATING(VALIDATING_VALUE),
        IN_QUEUE(IN_QUEUE_VALUE),
        PROCESSING(PROCESSING_VALUE),
        READY(READY_VALUE),
        FAILED(FAILED_VALUE),;

        private final String value;

        private CreateMediaResponseStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

