package app.morphe.patches.aliexpress.media

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class EnableImageSavingPatchTest {

    @Test
    fun verifyEnableImageSavingPatchProperties() {
        assertEquals("Enable image saving", enableImageSavingPatch.name)
        assertEquals("Enables saving product images directly to the device gallery.", enableImageSavingPatch.description)
        assertFalse(enableImageSavingPatch.default)
    }

    @Test
    fun verifyMediaSaveFingerprintProperties() {
        assertEquals("V", MediaSaveFingerprint.returnType)
        assertEquals(1, MediaSaveFingerprint.strings!!.size)
        assertEquals("FileServerUploadResult", MediaSaveFingerprint.strings!!.first())
    }
}
