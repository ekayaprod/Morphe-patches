package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class RemoveAdsPatchTest {

    static class AdItem {}
    static class SponsoredProduct {}
    static class AdvertisementInfo {}
    static class NormalProduct {}

    @Test
    public void filterAds_handlesNullList() {
        assertNull(RemoveAdsPatch.filterAds(null));
    }

    @Test
    public void filterAds_handlesEmptyList() {
        List<Object> empty = new ArrayList<>();
        assertEquals(empty, RemoveAdsPatch.filterAds(empty));
    }

    @Test
    public void filterAds_filtersAdItemsAndLeavesNormal() {
        List<Object> input = Arrays.asList(
            new NormalProduct(),
            new AdItem(),
            new SponsoredProduct(),
            new AdvertisementInfo(),
            new NormalProduct(),
            null
        );

        List<Object> filtered = RemoveAdsPatch.filterAds(input);

        assertEquals(3, filtered.size());
        assertTrue(filtered.get(0) instanceof NormalProduct);
        assertTrue(filtered.get(1) instanceof NormalProduct);
        assertNull(filtered.get(2));
    }
}
