package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSponsoredItemsPatchTest {

    static class AdItem {}
    static class NormalProduct {}

    @Test
    public void filterSearchResults_handlesNullList() {
        assertNull(RemoveSponsoredItemsPatch.filterSearchResults(null));
    }

    @Test
    public void filterSearchResults_handlesEmptyList() {
        List<Object> empty = new ArrayList<>();
        assertEquals(empty, RemoveSponsoredItemsPatch.filterSearchResults(empty));
    }

    @Test
    public void filterSearchResults_filtersAdItems() {
        List<Object> input = Arrays.asList(
            new NormalProduct(),
            new AdItem(),
            new NormalProduct(),
            null
        );

        List<Object> filtered = RemoveSponsoredItemsPatch.filterSearchResults(input);

        assertEquals(3, filtered.size());
        assertTrue(filtered.get(0) instanceof NormalProduct);
        assertTrue(filtered.get(1) instanceof NormalProduct);
        assertNull(filtered.get(2));
    }
}
