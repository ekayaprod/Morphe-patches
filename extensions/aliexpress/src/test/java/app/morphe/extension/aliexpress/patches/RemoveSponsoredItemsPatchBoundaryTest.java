package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Extracting mock dummy classes to top-level to prevent inheriting test class name substrings.
class UPPERCASEADITEM2 {}
class UPPERCASESPONSORED2 {}
class MixedCaseADiTem2 {}
class CamelCaseSponsoredItem2 {}
class CompletelyNormalObject2 {}

public class RemoveSponsoredItemsPatchBoundaryTest {

    @Test
    public void testFilterSearchResults_ExtremeCaseInsensitivity() {
        List<Object> items = Arrays.asList(
            new UPPERCASEADITEM2(),
            new UPPERCASESPONSORED2(),
            new MixedCaseADiTem2(),
            new CamelCaseSponsoredItem2(),
            new CompletelyNormalObject2()
        );

        List<Object> result = RemoveSponsoredItemsPatch.filterSearchResults(items);

        assertNotNull("Result should not be null", result);
        assertEquals("Should filter out all ad/sponsored-related items regardless of case", 1, result.size());
        assertEquals("Only CompletelyNormalObject2 should remain", CompletelyNormalObject2.class, result.get(0).getClass());
    }

    @Test
    public void testFilterSearchResults_HandlingNullValuesInList() {
        List<Object> items = Arrays.asList(
            new CompletelyNormalObject2(),
            null,
            new MixedCaseADiTem2(),
            null
        );

        List<Object> result = RemoveSponsoredItemsPatch.filterSearchResults(items);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(CompletelyNormalObject2.class, result.get(0).getClass());
        assertEquals(null, result.get(1));
        assertEquals(null, result.get(2));
    }
}
