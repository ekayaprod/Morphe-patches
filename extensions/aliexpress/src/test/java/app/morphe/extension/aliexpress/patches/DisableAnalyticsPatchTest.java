package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

public class DisableAnalyticsPatchTest {

    @Test
    public void rewriteAnalyticsUrl_handlesNullUrl() {
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl(null));
    }

    @Test
    public void rewriteAnalyticsUrl_blocksAnalyticsUrls() {
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl("https://api.aliexpress.com/analytics/event"));
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl("https://track.aliexpress.com/ping"));
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl("https://log.aliexpress.com/collect"));
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl("https://ump.aliexpress.com/log"));
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl("https://sensors.aliexpress.com/data"));
        assertNull(DisableAnalyticsPatch.rewriteAnalyticsUrl("https://umeng.aliexpress.com/track"));
    }

    @Test
    public void rewriteAnalyticsUrl_allowsNormalUrls() {
        assertEquals("https://api.aliexpress.com/product/details", DisableAnalyticsPatch.rewriteAnalyticsUrl("https://api.aliexpress.com/product/details"));
        assertEquals("https://m.aliexpress.com/", DisableAnalyticsPatch.rewriteAnalyticsUrl("https://m.aliexpress.com/"));
    }

    @Test
    public void shouldTrackEvent_alwaysReturnsFalse() {
        assertFalse(DisableAnalyticsPatch.shouldTrackEvent());
    }
}
