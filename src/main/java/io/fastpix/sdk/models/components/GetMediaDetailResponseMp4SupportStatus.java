package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * GetMediaDetailResponseMp4SupportStatus
 *
 * <p>Generation status of this MP4 rendition.
 *
 * <p>Wrapper for an "open" enum that can handle unknown values from API responses
 * without runtime errors. Instances are immutable singletons with reference equality.
 * Use {@code asEnum()} for switch expressions.
 */
public class GetMediaDetailResponseMp4SupportStatus {

    private static final String VALUE_PREPARING = "preparing";
    private static final String VALUE_READY = "ready";
    private static final String VALUE_FAILED = "failed";

    public static final GetMediaDetailResponseMp4SupportStatus PREPARING = new GetMediaDetailResponseMp4SupportStatus(VALUE_PREPARING);
    public static final GetMediaDetailResponseMp4SupportStatus READY = new GetMediaDetailResponseMp4SupportStatus(VALUE_READY);
    public static final GetMediaDetailResponseMp4SupportStatus FAILED = new GetMediaDetailResponseMp4SupportStatus(VALUE_FAILED);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, GetMediaDetailResponseMp4SupportStatus> values = createValuesMap();
    private static final Map<String, GetMediaDetailResponseMp4SupportStatusEnum> enums = createEnumsMap();

    private final String value;

    private GetMediaDetailResponseMp4SupportStatus(String value) {
        this.value = value;
    }

    /**
     * Returns a GetMediaDetailResponseMp4SupportStatus with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as GetMediaDetailResponseMp4SupportStatus
     */
    @JsonCreator
    public static GetMediaDetailResponseMp4SupportStatus of(String value) {
        synchronized (GetMediaDetailResponseMp4SupportStatus.class) {
            return values.computeIfAbsent(value, GetMediaDetailResponseMp4SupportStatus::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<GetMediaDetailResponseMp4SupportStatusEnum> asEnum() {
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
        GetMediaDetailResponseMp4SupportStatus other = (GetMediaDetailResponseMp4SupportStatus) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "GetMediaDetailResponseMp4SupportStatus [value=" + value + "]";
    }

    // return an array just like an enum
    public static GetMediaDetailResponseMp4SupportStatus[] values() {
        synchronized (GetMediaDetailResponseMp4SupportStatus.class) {
            return values.values().toArray(new GetMediaDetailResponseMp4SupportStatus[] {});
        }
    }

    private static final Map<String, GetMediaDetailResponseMp4SupportStatus> createValuesMap() {
        Map<String, GetMediaDetailResponseMp4SupportStatus> map = new LinkedHashMap<>();
        map.put(VALUE_PREPARING, PREPARING);
        map.put(VALUE_READY, READY);
        map.put(VALUE_FAILED, FAILED);
        return map;
    }

    private static final Map<String, GetMediaDetailResponseMp4SupportStatusEnum> createEnumsMap() {
        Map<String, GetMediaDetailResponseMp4SupportStatusEnum> map = new HashMap<>();
        map.put(VALUE_PREPARING, GetMediaDetailResponseMp4SupportStatusEnum.PREPARING);
        map.put(VALUE_READY, GetMediaDetailResponseMp4SupportStatusEnum.READY);
        map.put(VALUE_FAILED, GetMediaDetailResponseMp4SupportStatusEnum.FAILED);
        return map;
    }


    public enum GetMediaDetailResponseMp4SupportStatusEnum {

        PREPARING(VALUE_PREPARING),
        READY(VALUE_READY),
        FAILED(VALUE_FAILED),;

        private final String value;

        private GetMediaDetailResponseMp4SupportStatusEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
