package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * LiveMediaClipsMp4SupportStatus
 *
 * <p>Generation status of this MP4 rendition.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class LiveMediaClipsMp4SupportStatus {

    private static final String VALUE_PREPARING = "preparing";
    private static final String VALUE_READY = "ready";
    private static final String VALUE_FAILED = "failed";

    public static final LiveMediaClipsMp4SupportStatus PREPARING = new LiveMediaClipsMp4SupportStatus(VALUE_PREPARING);
    public static final LiveMediaClipsMp4SupportStatus READY = new LiveMediaClipsMp4SupportStatus(VALUE_READY);
    public static final LiveMediaClipsMp4SupportStatus FAILED = new LiveMediaClipsMp4SupportStatus(VALUE_FAILED);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, LiveMediaClipsMp4SupportStatus> values = createValuesMap();
    private static final Map<String, LiveMediaClipsMp4SupportStatusEnum> enums = createEnumsMap();

    private final String value;

    private LiveMediaClipsMp4SupportStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a LiveMediaClipsMp4SupportStatus with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as LiveMediaClipsMp4SupportStatus
     */
    @JsonCreator
    public static LiveMediaClipsMp4SupportStatus of(String value) {
        synchronized (LiveMediaClipsMp4SupportStatus.class) {
            return values.computeIfAbsent(value, LiveMediaClipsMp4SupportStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<LiveMediaClipsMp4SupportStatusEnum> asEnum() {
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
        LiveMediaClipsMp4SupportStatus other = (LiveMediaClipsMp4SupportStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "LiveMediaClipsMp4SupportStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static LiveMediaClipsMp4SupportStatus[] values() {
        synchronized (LiveMediaClipsMp4SupportStatus.class) {
            return values.values().toArray(new LiveMediaClipsMp4SupportStatus[] {});
        }
    }

    private static final Map<String, LiveMediaClipsMp4SupportStatus> createValuesMap() {
        Map<String, LiveMediaClipsMp4SupportStatus> map = new LinkedHashMap<>();
        map.put(VALUE_PREPARING, PREPARING);
        map.put(VALUE_READY, READY);
        map.put(VALUE_FAILED, FAILED);
        return map;
    }

    private static final Map<String, LiveMediaClipsMp4SupportStatusEnum> createEnumsMap() {
        Map<String, LiveMediaClipsMp4SupportStatusEnum> map = new HashMap<>();
        map.put(VALUE_PREPARING, LiveMediaClipsMp4SupportStatusEnum.PREPARING);
        map.put(VALUE_READY, LiveMediaClipsMp4SupportStatusEnum.READY);
        map.put(VALUE_FAILED, LiveMediaClipsMp4SupportStatusEnum.FAILED);
        return map;
    }


    public enum LiveMediaClipsMp4SupportStatusEnum {

        PREPARING(VALUE_PREPARING),
        READY(VALUE_READY),
        FAILED(VALUE_FAILED),;

        private final String value;

        private LiveMediaClipsMp4SupportStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
