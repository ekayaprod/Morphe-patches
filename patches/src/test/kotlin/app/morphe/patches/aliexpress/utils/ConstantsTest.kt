package app.morphe.patches.aliexpress.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class ConstantsTest {

    @Test
    fun verifyCompatibilityAliExpressBoundaries() {
        val compatibility = Constants.COMPATIBILITY_ALIEXPRESS

        // Shakedown explicit values
        assertEquals("com.alibaba.aliexpresshd", compatibility.packageName)
        assertEquals("AliExpress", compatibility.name)
        assertNull("Description should be explicitly null", compatibility.description)
        assertEquals(0xFF4747, compatibility.appIconColor)
        assertNull("Signatures should be explicitly null", compatibility.signatures)

        // Shakedown target array boundary
        assertNotNull(compatibility.targets)
        assertEquals(1, compatibility.targets.size)
        assertEquals("8.162.8", compatibility.targets.first().version)
    }

    @Test
    fun verifyPrefDescriptorConstant() {
        assertEquals("Lapp/morphe/extension/aliexpress/patches/PreferencesPatch;", Constants.PREF_DESCRIPTOR)
    }
}
