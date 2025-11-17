import org.junit.Test;
import sms.VersionUtil;

import static org.junit.Assert.assertNotEquals;

public class VersionUtilTest {

    @Test
    public void
    getVersion_shouldBeKnown() {
        assertNotEquals("UNKNOWN", VersionUtil.getVersion());
    }
}
