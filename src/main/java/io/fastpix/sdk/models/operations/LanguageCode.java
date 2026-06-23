package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

/**
 * LanguageCode
 * 
 * <p>Language codes (BCP 47 compliant) used for text files.
 */
public enum LanguageCode {
    EN("en"),
    IT("it"),
    PL("pl"),
    ES("es"),
    FR("fr"),
    RU("ru"),
    NL("nl");

    @JsonValue
    private final String value;

    LanguageCode(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<LanguageCode> fromValue(String value) {
        for (LanguageCode o: LanguageCode.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

