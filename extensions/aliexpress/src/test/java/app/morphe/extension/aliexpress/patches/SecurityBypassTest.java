package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

public class SecurityBypassTest {

    @Test
    public void shouldAllowLogin_alwaysReturnsTrue() {
        assertTrue(SecurityBypass.shouldAllowLogin());
    }

    @Test
    public void isPackageValid_alwaysReturnsTrue() {
        assertTrue(SecurityBypass.isPackageValid());
    }
}
