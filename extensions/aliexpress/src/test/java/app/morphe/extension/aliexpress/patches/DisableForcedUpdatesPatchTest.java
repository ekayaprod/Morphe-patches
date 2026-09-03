package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

public class DisableForcedUpdatesPatchTest {

    @Test
    public void shouldShowUpdateDialog_alwaysReturnsFalse() {
        assertFalse(DisableForcedUpdatesPatch.shouldShowUpdateDialog());
    }

    @Test
    public void getMinSupportedVersionCode_returnsMaxInt() {
        assertEquals(Integer.MAX_VALUE, DisableForcedUpdatesPatch.getMinSupportedVersionCode(1));
        assertEquals(Integer.MAX_VALUE, DisableForcedUpdatesPatch.getMinSupportedVersionCode(999999));
        assertEquals(Integer.MAX_VALUE, DisableForcedUpdatesPatch.getMinSupportedVersionCode(-1));
    }
}
