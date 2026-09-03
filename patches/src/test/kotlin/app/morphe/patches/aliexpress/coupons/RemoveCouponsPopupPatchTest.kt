package app.morphe.patches.aliexpress.coupons

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RemoveCouponsPopupPatchTest {

    @Test
    fun verifyRemoveCouponsPopupPatchProperties() {
        assertEquals("Remove coupons popup", removeCouponsPopupPatch.name)
        assertEquals("Removes the coupon and promotion popup dialogs.", removeCouponsPopupPatch.description)
        assertTrue(removeCouponsPopupPatch.default)
    }

    @Test
    fun verifyCouponFatigueFingerprintProperties() {
        assertEquals("Z", CouponFatigueFingerprint.returnType)
        assertEquals(2, CouponFatigueFingerprint.strings.size)
        assertEquals("search_coupon_floor_fatigue_", CouponFatigueFingerprint.strings[0])
        assertEquals("618Coupon: ", CouponFatigueFingerprint.strings[1])
    }
}
