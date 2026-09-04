package app.morphe.patches.aliexpress.security

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BypassSignatureCheckPatchTest {

    @Test
    fun verifyBypassSignatureCheckPatchProperties() {
        assertEquals("Bypass signature check", bypassSignatureCheckPatch.name)
        assertEquals("Bypasses SecurityGuard integrity checks to restore login on patched APKs.", bypassSignatureCheckPatch.description)
        assertTrue(bypassSignatureCheckPatch.default)
    }

    @Test
    fun verifyTamperCheckFingerprintProperties() {
        assertEquals("Z", TamperCheckFingerprint.returnType)
        assertEquals(1, TamperCheckFingerprint.strings!!.size)
        assertEquals("may be malicious user illegally tamper data", TamperCheckFingerprint.strings!!.first())
    }
}
