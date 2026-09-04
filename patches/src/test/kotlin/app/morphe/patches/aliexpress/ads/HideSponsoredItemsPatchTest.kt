package app.morphe.patches.aliexpress.ads

import app.morphe.patches.aliexpress.utils.Constants.COMPATIBILITY_ALIEXPRESS
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
    fun verifyHideSponsoredItemsPatchDependencies() {
        assertTrue(hideSponsoredItemsPatch.dependencies.contains(app.morphe.patches.aliexpress.security.bypassSignatureCheckPatch))
        assertEquals(COMPATIBILITY_ALIEXPRESS, hideSponsoredItemsPatch.compatibleWith)
    }

    @Test
    fun verifyAdcReportFingerprintProperties() {
        assertEquals("V", AdcReportFingerprint.returnType)
        assertEquals(3, AdcReportFingerprint.strings!!.size)
    }
}
