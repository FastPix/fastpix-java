package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * SortOrder
 * 
 * <p>The values in the list can be arranged in two ways: DESC (Descending) or ASC (Ascending).
 */
public enum SortOrder {
    ASC("asc"),
    DESC("desc");

    @JsonValue
    private final String value;

    SortOrder(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<SortOrder> fromValue(String value) {
        for (SortOrder o: SortOrder.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

