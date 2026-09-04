package app.morphe.patches.aliexpress.splash

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class DisableSplashScreenPatchTest {

    @Test
    fun verifySplashShowFingerprintProperties() {
        val fingerprint = SplashShowFingerprint

        assertEquals("V", fingerprint.returnType)
        assertNotNull(fingerprint.strings)
        assertEquals(2, fingerprint.strings?.size)
        assertTrue(fingerprint.strings?.contains("/splash_img.jpg") ?: false)
        assertTrue(fingerprint.strings?.contains("splash_img_url") ?: false)
    }

    @Test
    fun verifyDisableSplashScreenPatchProperties() {
        val patch = disableSplashScreenPatch

        assertEquals("Disable splash screen", patch.name)
        assertEquals("Skips the splash screen on app launch.", patch.description)
        assertEquals(false, patch.default)
    }
}
