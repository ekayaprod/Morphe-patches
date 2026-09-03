package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

public class PreferencesPatchTest {

    @Test
    public void preferencesReturnExpectedValues() {
        assertTrue(PreferencesPatch.removeAds());
        assertTrue(PreferencesPatch.disableAnalytics());
        assertTrue(PreferencesPatch.disableForcedUpdates());
        assertTrue(PreferencesPatch.disablePromotionsNotifications());
        assertFalse(PreferencesPatch.disableSplashScreen());
        assertTrue(PreferencesPatch.hideSponsoredItems());
        assertTrue(PreferencesPatch.removeCouponsPopup());
        assertTrue(PreferencesPatch.removeAffiliateTracking());
        assertFalse(PreferencesPatch.enableImageSaving());
        assertTrue(PreferencesPatch.bypassSignatureCheck());
    }
}
