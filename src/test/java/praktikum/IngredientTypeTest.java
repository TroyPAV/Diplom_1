package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IngredientTypeTest {

    @Test
    public void valuesReturnIngredientTypesListSize() {
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        Assert.assertEquals(2, ingredientTypes.size());
    }
}