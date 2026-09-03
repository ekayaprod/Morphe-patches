package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

class NormalProductItem {}
class SponsoredProductItem {}
class CustomAdItemView {}
class RandomAdvertisementView {}

public class RemoveAdsPatchTest {

    @Test
    public void testShouldShowAd() {
        assertFalse(RemoveAdsPatch.shouldShowAd());
    }

    @Test
    public void testFilterAds_WithNull() {
        assertNull("Null list should return null", RemoveAdsPatch.filterAds(null));
    }

    @Test
    public void testFilterAds_WithEmptyList() {
        List<Object> empty = new ArrayList<>();
        List<Object> result = RemoveAdsPatch.filterAds(empty);
        assertTrue("Empty list should return empty list", result.isEmpty());
    }

    @Test
    public void testFilterAds_WithMixedItems() {
        List<Object> items = Arrays.asList(
            new NormalProductItem(),
            new SponsoredProductItem(),
            new CustomAdItemView(),
            new NormalProductItem(),
            new RandomAdvertisementView()
        );

        List<Object> result = RemoveAdsPatch.filterAds(items);

        assertEquals("Filtered list should only contain normal products", 2, result.size());
        for (Object item : result) {
            assertEquals("Only NormalProductItem should remain", NormalProductItem.class, item.getClass());
        }
    }

    @Test
    public void testFilterAds_WithNullItemsInList() {
        List<Object> items = Arrays.asList(
            new NormalProductItem(),
            null,
            new SponsoredProductItem()
        );

        List<Object> result = RemoveAdsPatch.filterAds(items);

        assertEquals("Filtered list should retain normal and null items", 2, result.size());
        assertEquals("First item should be NormalProductItem", NormalProductItem.class, result.get(0).getClass());
        assertNull("Second item should be null", result.get(1));
    }
}
