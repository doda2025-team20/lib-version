package sms;

import java.io.InputStream;
import java.util.Properties;

public final class VersionUtil {

    private static final String VERSION_PROPERTIES_FILE = "/version.properties";
    private static final String version = loadVersion();

    private VersionUtil() {
        // :P
    }

    private static String loadVersion() {
        Properties props = new Properties();
        try (InputStream in = VersionUtil.class.getResourceAsStream(VERSION_PROPERTIES_FILE)) {
            if (in != null) {
                props.load(in);
            }
        } catch (Exception e) {
            return "UNKNOWN";
        }

        return props.getProperty("version", "UNKNOWN");
    }

    public static String getVersion() {
        return version;
    }
}
