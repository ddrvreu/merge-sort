package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class TestUtils {

    public static InputStream createInputStream(String... inputs) {
        return new ByteArrayInputStream(String.join("\n", inputs).getBytes());
    }

    public static String getActualString(ByteArrayOutputStream output) {
        return (new String(output.toByteArray())
                .replaceAll("[\r\n]+", " "))
                .trim();
    }
}
