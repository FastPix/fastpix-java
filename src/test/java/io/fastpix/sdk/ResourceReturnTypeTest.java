package io.fastpix.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * Every resource method must declare the {@code <Op>Response} envelope that the
 * operation it constructs deserializes on the success path. Fails per method by name.
 */
class ResourceReturnTypeTest {

    private static final Path RESOURCES = Path.of("src/main/java/io/fastpix/sdk");
    private static final int EXPECTED_METHOD_COUNT = 140;

    private static final Pattern METHOD = Pattern.compile(
            "public (?:CompletableFuture<)?(\\w+Response)>? (\\w+)\\([^)]*\\)\\s*\\{[^}]*?new (\\w+)\\.(Sync|Async)\\(", Pattern.DOTALL);

    @Test
    void declaredReturnTypeMatchesDeserializedEnvelope() throws IOException {
        List<String> mismatches = new ArrayList<>();
        int scanned = 0;
        try (Stream<Path> files = Files.list(RESOURCES)) {
            for (Path file : (Iterable<Path>) files.filter(p -> p.toString().endsWith(".java"))::iterator) {
                String source = Files.readString(file);
                Matcher m = METHOD.matcher(source);
                while (m.find()) {
                    scanned++;
                    String declared = m.group(1);
                    String expected = m.group(3) + "Response";
                    if (!declared.equals(expected)) {
                        mismatches.add(file.getFileName() + "#" + m.group(2) + " declares " + declared + " but deserializes " + expected);
                    }
                    String pkg = m.group(4).equals("Async") ? "io.fastpix.sdk.models.operations.async." : "io.fastpix.sdk.models.operations.";
                    try {
                        Class.forName(pkg + declared);
                    } catch (ClassNotFoundException e) {
                        mismatches.add(file.getFileName() + "#" + m.group(2) + " return type " + pkg + declared + " does not exist");
                    }
                }
            }
        }
        assertTrue(mismatches.isEmpty(), () -> String.join("\n", mismatches));
        assertEquals(EXPECTED_METHOD_COUNT, scanned, "resource method scan count drifted; update the constant with the new operation");
    }
}
