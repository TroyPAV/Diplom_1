package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][] {
                {IngredientType.SAUCE, "Майонез", 100500},
                {IngredientType.FILLING, "Колбаса вареная", 500100}
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceReturnPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameReturnName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeReturnType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}