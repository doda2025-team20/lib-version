package sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class VersionUtil {

    private static final String VERSION_FILE = "/version.txt";
    private static final String version = loadVersion();

    private VersionUtil() {
        // :P
    }

    private static String loadVersion() {
        try (InputStream in = VersionUtil.class.getResourceAsStream(VERSION_FILE)) {
            if (in == null) {
                return "UNKNOWN";
            }
            try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                String line = r.readLine();
                return (line == null || line.trim().isEmpty()) ? "UNKNOWN" : line.trim();
            }
        } catch (IOException e) {
            return "UNKNOWN";
        }
    }

    public static String getVersion() {
        return version;
    }
}
