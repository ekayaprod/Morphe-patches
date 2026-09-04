package app.morphe.extension.aliexpress.patches;

class ItemUtils {
    static boolean isAdOrSponsored(Object item) {
        if (item == null) return false;
        String cls = item.getClass().getName().toLowerCase(java.util.Locale.ROOT);
        return cls.contains("aditem")
            || cls.contains("sponsored")
            || cls.contains("advertisement");
    }
}
