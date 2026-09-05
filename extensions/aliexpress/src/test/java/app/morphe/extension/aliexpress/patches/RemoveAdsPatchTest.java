package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

// Extracting mock classes to the top level prevents them from inheriting the test class's name
// (which contains "Ad" and "Patch") in their fully qualified name, avoiding false positives
// during case-insensitive reflection matching.
class NormalProductItem {}
class SponsoredProductItem {}
class CustomAdItemView {}
class RandomAdvertisementView {}
class MixedCaseADiTem {}
class UPPERCASEADITEM {}
class UPPERCASESPONSORED {}
class CamelCaseSponsoredItem {}

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

    @Test
    public void testFilterAds_CaseInsensitivityBoundaries() {
        List<Object> items = Arrays.asList(
            new NormalProductItem(),
            new UPPERCASEADITEM(),
            new UPPERCASESPONSORED(),
            new MixedCaseADiTem(),
            new CamelCaseSponsoredItem()
        );

        List<Object> result = RemoveAdsPatch.filterAds(items);

        assertNotNull("Result should not be null", result);
        assertEquals("Should filter out all ad-related items regardless of case", 1, result.size());
        assertEquals("Only NormalProductItem should remain", NormalProductItem.class, result.get(0).getClass());
    }
}
