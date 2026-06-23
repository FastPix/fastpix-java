package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * UpdateMediaStatus
 *
 * <p>Determines the media's status, which can be one of the possible values.
 */
public class UpdateMediaStatus {

    private static final String VALUE_CREATED = "Created";
    private static final String VALUE_DOWNLOADING = "Downloading";
    private static final String VALUE_DOWNLOADED = "Downloaded";
    private static final String VALUE_VALIDATING = "Validating";
    private static final String VALUE_IN_QUEUE = "In Queue";
    private static final String VALUE_PROCESSING = "Processing";
    private static final String VALUE_READY = "Ready";
    private static final String VALUE_FAILED = "Failed";

    public static final UpdateMediaStatus CREATED = new UpdateMediaStatus(VALUE_CREATED);
    public static final UpdateMediaStatus DOWNLOADING = new UpdateMediaStatus(VALUE_DOWNLOADING);
    public static final UpdateMediaStatus DOWNLOADED = new UpdateMediaStatus(VALUE_DOWNLOADED);
    public static final UpdateMediaStatus VALIDATING = new UpdateMediaStatus(VALUE_VALIDATING);
    public static final UpdateMediaStatus IN_QUEUE = new UpdateMediaStatus(VALUE_IN_QUEUE);
    public static final UpdateMediaStatus PROCESSING = new UpdateMediaStatus(VALUE_PROCESSING);
    public static final UpdateMediaStatus READY = new UpdateMediaStatus(VALUE_READY);
    public static final UpdateMediaStatus FAILED = new UpdateMediaStatus(VALUE_FAILED);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, UpdateMediaStatus> values = createValuesMap();
    private static final Map<String, UpdateMediaStatusEnum> enums = createEnumsMap();

    private final String value;

    private UpdateMediaStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a UpdateMediaStatus with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as UpdateMediaStatus
     */
    @JsonCreator
    public static UpdateMediaStatus of(String value) {
        synchronized (UpdateMediaStatus.class) {
            return values.computeIfAbsent(value, UpdateMediaStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<UpdateMediaStatusEnum> asEnum() {
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
        UpdateMediaStatus other = (UpdateMediaStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "UpdateMediaStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static UpdateMediaStatus[] values() {
        synchronized (UpdateMediaStatus.class) {
            return values.values().toArray(new UpdateMediaStatus[] {});
        }
    }

    private static final Map<String, UpdateMediaStatus> createValuesMap() {
        Map<String, UpdateMediaStatus> map = new LinkedHashMap<>();
        map.put(VALUE_CREATED, CREATED);
        map.put(VALUE_DOWNLOADING, DOWNLOADING);
        map.put(VALUE_DOWNLOADED, DOWNLOADED);
        map.put(VALUE_VALIDATING, VALIDATING);
        map.put(VALUE_IN_QUEUE, IN_QUEUE);
        map.put(VALUE_PROCESSING, PROCESSING);
        map.put(VALUE_READY, READY);
        map.put(VALUE_FAILED, FAILED);
        return map;
    }

    private static final Map<String, UpdateMediaStatusEnum> createEnumsMap() {
        Map<String, UpdateMediaStatusEnum> map = new HashMap<>();
        map.put(VALUE_CREATED, UpdateMediaStatusEnum.CREATED);
        map.put(VALUE_DOWNLOADING, UpdateMediaStatusEnum.DOWNLOADING);
        map.put(VALUE_DOWNLOADED, UpdateMediaStatusEnum.DOWNLOADED);
        map.put(VALUE_VALIDATING, UpdateMediaStatusEnum.VALIDATING);
        map.put(VALUE_IN_QUEUE, UpdateMediaStatusEnum.IN_QUEUE);
        map.put(VALUE_PROCESSING, UpdateMediaStatusEnum.PROCESSING);
        map.put(VALUE_READY, UpdateMediaStatusEnum.READY);
        map.put(VALUE_FAILED, UpdateMediaStatusEnum.FAILED);
        return map;
    }


    public enum UpdateMediaStatusEnum {

        CREATED(VALUE_CREATED),
        DOWNLOADING(VALUE_DOWNLOADING),
        DOWNLOADED(VALUE_DOWNLOADED),
        VALIDATING(VALUE_VALIDATING),
        IN_QUEUE(VALUE_IN_QUEUE),
        PROCESSING(VALUE_PROCESSING),
        READY(VALUE_READY),
        FAILED(VALUE_FAILED),;

        private final String value;

        private UpdateMediaStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
