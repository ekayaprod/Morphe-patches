package app.morphe.patches.aliexpress.tracking

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class RemoveAffiliateTrackingPatchTest {

    @Test
    fun verifyTrackHelperFingerprintBoundaries() {
        val fingerprint = TrackHelperFingerprint

        assertEquals("V", fingerprint.returnType)
        assertNotNull(fingerprint.strings)
        assertEquals(2, fingerprint.strings?.size)
        assertTrue(fingerprint.strings?.contains("firebase_event_switch") ?: false)
        assertTrue(fingerprint.strings?.contains("app_config") ?: false)
    }

    @Test
    fun verifyRemoveAffiliateTrackingPatchProperties() {
        val patch = removeAffiliateTrackingPatch

        assertEquals("Remove affiliate tracking", patch.name)
        assertEquals("Removes affiliate tracking parameters from shared links.", patch.description)
        assertTrue(patch.default)
    }
}
