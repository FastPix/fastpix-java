package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * GroupBy
 * 
 * <p>Pass this value to group the metrics list by.
 */
public enum GroupBy {
    MINUTE("minute"),
    TEN_MINUTES("ten_minutes"),
    HOUR("hour"),
    DAY("day");

    @JsonValue
    private final String value;

    GroupBy(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<GroupBy> fromValue(String value) {
        for (GroupBy o: GroupBy.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

