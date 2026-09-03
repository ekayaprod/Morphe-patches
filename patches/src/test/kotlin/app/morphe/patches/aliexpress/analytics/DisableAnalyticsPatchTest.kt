package app.morphe.patches.aliexpress.analytics

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DisableAnalyticsPatchTest {

    @Test
    fun verifyDisableAnalyticsPatchProperties() {
        assertEquals("Disable analytics", disableAnalyticsPatch.name)
        assertEquals("Blocks analytics and tracking sent to AliExpress servers.", disableAnalyticsPatch.description)
        assertTrue(disableAnalyticsPatch.default)
    }

    @Test
    fun verifyAnalyticsInitFingerprintProperties() {
        assertEquals("V", AnalyticsInitFingerprint.returnType)
        assertEquals(2, AnalyticsInitFingerprint.strings!!.size)
        assertEquals("setGlobalProperty", AnalyticsInitFingerprint.strings!![0])
        assertEquals("key is null or key is empty or value is null,please check it!", AnalyticsInitFingerprint.strings!![1])
    }
}
