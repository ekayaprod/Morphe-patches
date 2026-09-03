package app.morphe.extension.aliexpress.patches;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Extracting mock dummy classes to top-level to prevent inheriting test class name substrings.
class UPPERCASEADITEM {}
class UPPERCASESPONSORED {}
class UPPERCASEADVERTISEMENT {}
class MixedCaseADiTem {}
class CamelCaseSponsoredItem {}
class PascalCaseAdvertisementView {}
class CompletelyNormalObject {}

public class RemoveAdsPatchBoundaryTest {

    @Test
    public void testFilterAds_ExtremeCaseInsensitivity() {
        List<Object> items = Arrays.asList(
            new UPPERCASEADITEM(),
            new UPPERCASESPONSORED(),
            new UPPERCASEADVERTISEMENT(),
            new MixedCaseADiTem(),
            new CamelCaseSponsoredItem(),
            new PascalCaseAdvertisementView(),
            new CompletelyNormalObject()
        );

        List<Object> result = RemoveAdsPatch.filterAds(items);

        assertNotNull("Result should not be null", result);
        assertEquals("Should filter out all ad-related items regardless of case", 1, result.size());
        assertEquals("Only CompletelyNormalObject should remain", CompletelyNormalObject.class, result.get(0).getClass());
    }

    @Test
    public void testFilterAds_HandlingNullValuesInList() {
        List<Object> items = Arrays.asList(
            new CompletelyNormalObject(),
            null,
            new MixedCaseADiTem(),
            null
        );

        List<Object> result = RemoveAdsPatch.filterAds(items);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(CompletelyNormalObject.class, result.get(0).getClass());
        assertEquals(null, result.get(1));
        assertEquals(null, result.get(2));
    }
}
