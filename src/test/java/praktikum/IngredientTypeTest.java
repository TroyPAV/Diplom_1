package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType ingredientType;
    private String type;

    public IngredientTypeTest(IngredientType ingredientType, String type) {
        this.ingredientType = ingredientType;
        this.type = type;
    }

    @Parameterized.Parameters (name = "Тестовые данные: {0}, {1}")
    public static Object[][] getType() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void valueOfReturnIngredientTypes() {
        Assert.assertEquals(IngredientType.valueOf(type), ingredientType);
    }

    @Test
    public void valuesReturnIngredientTypesListSize() {
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        Assert.assertEquals(2, ingredientTypes.size());
    }
}