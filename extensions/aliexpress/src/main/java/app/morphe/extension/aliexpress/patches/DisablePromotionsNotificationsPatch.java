package app.morphe.extension.aliexpress.patches;

@SuppressWarnings("unused")
public final class DisablePromotionsNotificationsPatch {

    public static boolean shouldShowNotification() {
        return false;
    }

    public static boolean isPromotionalNotification(String title, String body) {
        if (title == null) title = "";
        if (body == null) body = "";
        String lowerTitle = title.toLowerCase(java.util.Locale.ROOT);
        String lowerBody = body.toLowerCase(java.util.Locale.ROOT);
        return lowerTitle.contains("promotion")
            || lowerTitle.contains("coupon")
            || lowerTitle.contains("deal")
            || lowerTitle.contains("sale")
            || lowerBody.contains("promotion")
            || lowerBody.contains("coupon")
            || lowerBody.contains("discount");
    }
}
