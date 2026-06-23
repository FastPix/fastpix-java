package io.fastpix.sdk.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class BigDecimalStringTest {

    @Test
    void stringConstructorParsesValue() {
        BigDecimalString v = new BigDecimalString("12.34");
        assertEquals(new BigDecimal("12.34"), v.value());
        assertEquals("12.34", v.toString());
    }

    @Test
    void bigDecimalConstructorRetainsValue() {
        BigDecimal d = new BigDecimal("0.001");
        assertEquals(d, new BigDecimalString(d).value());
    }

    @Test
    void equalsAndHashCodeFollowValue() {
        BigDecimalString a = new BigDecimalString("5.0");
        BigDecimalString b = new BigDecimalString(new BigDecimal("5.0"));
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, new BigDecimalString("5.00"));
    }

    @Test
    void jacksonRoundTripsAsString() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        BigDecimalString original = new BigDecimalString("987654321.123456789");
        String json = mapper.writeValueAsString(original);
        assertEquals("\"987654321.123456789\"", json);
        assertEquals(original, mapper.readValue(json, BigDecimalString.class));
    }
}
