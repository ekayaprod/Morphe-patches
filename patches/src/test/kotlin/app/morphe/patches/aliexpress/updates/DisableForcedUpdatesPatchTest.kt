package app.morphe.patches.aliexpress.updates

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class DisableForcedUpdatesPatchTest {

    @Test
    fun verifyUpdateCheckFingerprintBoundaries() {
        val fingerprint = UpdateCheckFingerprint

        assertEquals("V", fingerprint.returnType)
        assertNotNull(fingerprint.strings)
        assertEquals(1, fingerprint.strings?.size)
        assertTrue(fingerprint.strings?.contains("checkUpdate") ?: false)
    }

    @Test
    fun verifyDisableForcedUpdatesPatchProperties() {
        val patch = disableForcedUpdatesPatch

        assertEquals("Disable forced updates", patch.name)
        assertEquals("Disables the forced update popup that prevents using older versions of the app.", patch.description)
        assertTrue(patch.default)

        assertNotNull(patch.dependencies)
        assertEquals(1, patch.dependencies?.size)
        assertTrue(patch.dependencies?.first()?.name == "Bypass signature check")

        assertNotNull(patch.compatibility)
        assertEquals(1, patch.compatibility?.size)
        assertTrue(patch.compatibility?.contains(app.morphe.patches.aliexpress.utils.Constants.COMPATIBILITY_ALIEXPRESS) ?: false)
    }
}
