package app.morphe.extension.aliexpress.patches;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class RemoveSponsoredItemsPatch {

    public static List<Object> filterSearchResults(List<Object> results) {
        if (results == null || results.isEmpty()) return results;
        List<Object> filtered = new ArrayList<>();
        for (Object item : results) {
            if (!isSponsoredProduct(item)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    private static boolean isSponsoredProduct(Object item) {
        if (item == null) return false;
        String cls = item.getClass().getName();
        return cls.contains("AdItem") || cls.contains("Sponsored");
    }
}
