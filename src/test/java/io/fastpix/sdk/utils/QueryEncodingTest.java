package io.fastpix.sdk.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class QueryEncodingTest {

    @Test
    void joinsParametersWithAmpersand() {
        String q = QueryEncoding.formatQuery(
                Arrays.asList(new NameValue("a", "1"), new NameValue("b", "2")),
                StandardCharsets.UTF_8, false);
        assertEquals("a=1&b=2", q);
    }

    @Test
    void percentEncodesReservedCharacters() {
        String q = QueryEncoding.formatQuery(
                Collections.singletonList(new NameValue("q", "a b&c")),
                StandardCharsets.UTF_8, false);
        assertEquals("q=a%20b%26c", q);
    }

    @Test
    void encodesBlankAsPlusWhenRequested() {
        String q = QueryEncoding.formatQuery(
                Collections.singletonList(new NameValue("q", "a b")),
                StandardCharsets.UTF_8, true);
        assertEquals("q=a+b", q);
    }

    @Test
    void omitsSeparatorWhenValueIsNull() {
        String q = QueryEncoding.formatQuery(
                Collections.singletonList(new NameValue("flag", null)),
                StandardCharsets.UTF_8, false);
        assertEquals("flag", q);
    }
}
