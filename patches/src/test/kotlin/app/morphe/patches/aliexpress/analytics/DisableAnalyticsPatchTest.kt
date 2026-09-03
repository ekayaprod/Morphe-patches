package app.morphe.patches.aliexpress.analytics

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class DisableAnalyticsPatchTest {

    @Test
    fun verifyAnalyticsInitFingerprintBoundaries() {
        val fingerprint = AnalyticsInitFingerprint

        assertEquals("V", fingerprint.returnType)
        assertNotNull(fingerprint.strings)
        assertEquals(2, fingerprint.strings?.size)
        assertTrue(fingerprint.strings?.contains("setGlobalProperty") ?: false)
        assertTrue(fingerprint.strings?.contains("key is null or key is empty or value is null,please check it!") ?: false)
    }

    @Test
    fun verifyDisableAnalyticsPatchProperties() {
        val patch = disableAnalyticsPatch

        assertEquals("Disable analytics", patch.name)
        assertEquals("Blocks analytics and tracking sent to AliExpress servers.", patch.description)
        assertTrue(patch.default)
    }
}
