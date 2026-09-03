package app.morphe.patches.aliexpress.ads

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RemoveAdsPatchTest {

    @Test
    fun verifyRemoveAdsPatchProperties() {
        assertEquals("Remove ads", removeAdsPatch.name)
        assertEquals("Removes sponsored products and advertisements from the AliExpress home feed and search results.", removeAdsPatch.description)
        assertTrue(removeAdsPatch.default)
    }

    @Test
    fun verifyAdcInitFingerprintProperties() {
        assertEquals("V", AdcInitFingerprint.returnType)
        assertEquals(1, AdcInitFingerprint.parameters.size)
        assertEquals("Landroid/app/Application;", AdcInitFingerprint.parameters.first())
    }
}
