package app.morphe.extension.aliexpress.patches;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class RemoveAdsPatch {

    public static boolean shouldShowAd() {
        return false;
    }

    public static List<Object> filterAds(List<Object> items) {
        if (items == null || items.isEmpty()) return items;
        List<Object> filtered = new ArrayList<>();
        for (Object item : items) {
            if (!ItemUtils.isAdOrSponsored(item)) {
                filtered.add(item);
            }
        }
        return filtered;
    }
}
