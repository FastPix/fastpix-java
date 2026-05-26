package io.fastpix.sdk.utils;

final class NameValue {
    private final String name;
    private final String value;

    NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    String name() {
        return name;
    }

    String value() {
        return value;
    }
}