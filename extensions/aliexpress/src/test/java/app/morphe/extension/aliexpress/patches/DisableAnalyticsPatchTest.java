package app.morphe.extension.aliexpress.patches;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

public class DisableAnalyticsPatchTest {

    @Test
    public void testShouldTrackEvent() {
        assertFalse(DisableAnalyticsPatch.shouldTrackEvent());
    }

    @Test
    public void testRewriteAnalyticsUrl_WithNull() {
        assertNull("Null URL should return null", DisableAnalyticsPatch.rewriteAnalyticsUrl(null));
    }

    @Test
    public void testRewriteAnalyticsUrl_WithEmptyString() {
        assertEquals("Empty string should be returned as-is", "", DisableAnalyticsPatch.rewriteAnalyticsUrl(""));
    }

    @Test
    public void testRewriteAnalyticsUrl_WithBenignUrls() {
        String[] benignUrls = {
            "https://aliexpress.com/api/products",
            "https://gw.alicdn.com/imgextra/i3/O1CN01...",
            "https://login.aliexpress.com",
            "/local/cache/images"
        };

        for (String url : benignUrls) {
            assertEquals("Benign URL should not be blocked", url, DisableAnalyticsPatch.rewriteAnalyticsUrl(url));
        }
    }

    @Test
    public void testRewriteAnalyticsUrl_WithTrackingUrls() {
        String[] trackingUrls = {
            "https://acs.aliexpress.com/gw/mtop.aliexpress.analytics.collect/1.0/",
            "https://log.aliexpress.com/track/event",
            "https://umeng.com/api/v1/collect",
            "https://sensorsdata.aliexpress.com",
            "https://ump.aliexpress.com/report"
        };

        for (String url : trackingUrls) {
            assertNull("Tracking URL should be blocked (returned as null)", DisableAnalyticsPatch.rewriteAnalyticsUrl(url));
        }
    }
}
