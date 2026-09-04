package app.morphe.patches.aliexpress.ads

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HideSponsoredItemsPatchTest {

    @Test
    fun verifyHideSponsoredItemsPatchProperties() {
        assertEquals("Remove sponsored items from search", hideSponsoredItemsPatch.name)
        assertEquals("Filters out sponsored and promoted products from search results.", hideSponsoredItemsPatch.description)
        assertTrue(hideSponsoredItemsPatch.default)
    }

    @Test
    fun verifyAdcReportFingerprintProperties() {
        assertEquals("V", AdcReportFingerprint.returnType)
        assertEquals(3, AdcReportFingerprint.strings!!.size)
    }
}
