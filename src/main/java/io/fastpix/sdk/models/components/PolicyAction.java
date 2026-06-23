package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * PolicyAction
 *
 * <p>Policy action type
 */
public class PolicyAction {

    private static final String VALUE_ALLOW = "allow";
    private static final String VALUE_DENY = "deny";

    public static final PolicyAction ALLOW = new PolicyAction(VALUE_ALLOW);
    public static final PolicyAction DENY = new PolicyAction(VALUE_DENY);

    // This map will grow whenever a Color gets created with a new
    // unrecognized value (a potential memory leak if the user is not
    // careful). Keep this field lower case to avoid clashing with
    // generated member names which will always be upper cased (Java
    // convention)
    private static final Map<String, PolicyAction> values = createValuesMap();
    private static final Map<String, PolicyActionEnum> enums = createEnumsMap();

    private final String value;

    private PolicyAction(String value) {
        this.value = value;
    }

    /**
     * Returns a PolicyAction with the given value. For a specific value the
     * returned object will always be a singleton so reference equality
     * is satisfied when the values are the same.
     *
     * @param value value to be wrapped as PolicyAction
     */
    @JsonCreator
    public static PolicyAction of(String value) {
        synchronized (PolicyAction.class) {
            return values.computeIfAbsent(value, PolicyAction::new);
        }
    }

    @JsonValue
    public String value() {
        return value;
    }

    public Optional<PolicyActionEnum> asEnum() {
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
        PolicyAction other = (PolicyAction) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "PolicyAction [value=" + value + "]";
    }

    // return an array just like an enum
    public static PolicyAction[] values() {
        synchronized (PolicyAction.class) {
            return values.values().toArray(new PolicyAction[] {});
        }
    }

    private static final Map<String, PolicyAction> createValuesMap() {
        Map<String, PolicyAction> map = new LinkedHashMap<>();
        map.put(VALUE_ALLOW, ALLOW);
        map.put(VALUE_DENY, DENY);
        return map;
    }

    private static final Map<String, PolicyActionEnum> createEnumsMap() {
        Map<String, PolicyActionEnum> map = new HashMap<>();
        map.put(VALUE_ALLOW, PolicyActionEnum.ALLOW);
        map.put(VALUE_DENY, PolicyActionEnum.DENY);
        return map;
    }


    public enum PolicyActionEnum {

        ALLOW(VALUE_ALLOW),
        DENY(VALUE_DENY),;

        private final String value;

        private PolicyActionEnum(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
