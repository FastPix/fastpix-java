package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * SourceAccessMediaMp4SupportStatus
 *
 * <p>Generation status of this MP4 rendition.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class SourceAccessMediaMp4SupportStatus {

    private static final String VALUE_PREPARING = "preparing";
    private static final String VALUE_READY = "ready";
    private static final String VALUE_FAILED = "failed";

    public static final SourceAccessMediaMp4SupportStatus PREPARING = new SourceAccessMediaMp4SupportStatus(VALUE_PREPARING);
    public static final SourceAccessMediaMp4SupportStatus READY = new SourceAccessMediaMp4SupportStatus(VALUE_READY);
    public static final SourceAccessMediaMp4SupportStatus FAILED = new SourceAccessMediaMp4SupportStatus(VALUE_FAILED);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, SourceAccessMediaMp4SupportStatus> values = createValuesMap();
    private static final Map<String, SourceAccessMediaMp4SupportStatusEnum> enums = createEnumsMap();

    private final String value;

    private SourceAccessMediaMp4SupportStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a SourceAccessMediaMp4SupportStatus with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as SourceAccessMediaMp4SupportStatus
     */
    @JsonCreator
    public static SourceAccessMediaMp4SupportStatus of(String value) {
        synchronized (SourceAccessMediaMp4SupportStatus.class) {
            return values.computeIfAbsent(value, SourceAccessMediaMp4SupportStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<SourceAccessMediaMp4SupportStatusEnum> asEnum() {
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
        SourceAccessMediaMp4SupportStatus other = (SourceAccessMediaMp4SupportStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "SourceAccessMediaMp4SupportStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static SourceAccessMediaMp4SupportStatus[] values() {
        synchronized (SourceAccessMediaMp4SupportStatus.class) {
            return values.values().toArray(new SourceAccessMediaMp4SupportStatus[] {});
        }
    }

    private static final Map<String, SourceAccessMediaMp4SupportStatus> createValuesMap() {
        Map<String, SourceAccessMediaMp4SupportStatus> map = new LinkedHashMap<>();
        map.put(VALUE_PREPARING, PREPARING);
        map.put(VALUE_READY, READY);
        map.put(VALUE_FAILED, FAILED);
        return map;
    }

    private static final Map<String, SourceAccessMediaMp4SupportStatusEnum> createEnumsMap() {
        Map<String, SourceAccessMediaMp4SupportStatusEnum> map = new HashMap<>();
        map.put(VALUE_PREPARING, SourceAccessMediaMp4SupportStatusEnum.PREPARING);
        map.put(VALUE_READY, SourceAccessMediaMp4SupportStatusEnum.READY);
        map.put(VALUE_FAILED, SourceAccessMediaMp4SupportStatusEnum.FAILED);
        return map;
    }


    public enum SourceAccessMediaMp4SupportStatusEnum {

        PREPARING(VALUE_PREPARING),
        READY(VALUE_READY),
        FAILED(VALUE_FAILED),;

        private final String value;

        private SourceAccessMediaMp4SupportStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
