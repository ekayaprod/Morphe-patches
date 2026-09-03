package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

public class DisablePromotionsNotificationsPatchTest {

    @Test
    public void isPromotionalNotification_handlesNullInputs() {
        assertFalse(DisablePromotionsNotificationsPatch.isPromotionalNotification(null, null));
        assertFalse(DisablePromotionsNotificationsPatch.isPromotionalNotification("normal", null));
        assertFalse(DisablePromotionsNotificationsPatch.isPromotionalNotification(null, "normal"));
    }

    @Test
    public void isPromotionalNotification_identifiesPromotions() {
        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Check out this promotion!", "Great deals inside"));
        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Here is your coupon", "Claim it now"));
        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Big deal today", "Save 50%"));
        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Flash sale", "Hurry up!"));

        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Normal title", "We have a promotion for you"));
        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Normal title", "Use this coupon code"));
        assertTrue(DisablePromotionsNotificationsPatch.isPromotionalNotification("Normal title", "Get a discount on your next order"));
    }

    @Test
    public void isPromotionalNotification_ignoresNormalNotifications() {
        assertFalse(DisablePromotionsNotificationsPatch.isPromotionalNotification("Your order shipped", "Track it here"));
        assertFalse(DisablePromotionsNotificationsPatch.isPromotionalNotification("Message from seller", "Your item is out of stock"));
        assertFalse(DisablePromotionsNotificationsPatch.isPromotionalNotification("Account update", "Password changed successfully"));
    }
}
