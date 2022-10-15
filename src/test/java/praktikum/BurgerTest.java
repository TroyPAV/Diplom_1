package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredient1Mock;
    @Mock
    Ingredient ingredient2Mock;
    private Burger burger;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void setBunsExpectedBunIsSet() {
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientExpectedIngredientsListIsNotEmpty() {
        Assert.assertTrue(burger.ingredients.isEmpty());
        burger.addIngredient(ingredient1Mock);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientExpectedIngredientsListIsEmpty() {
        burger.addIngredient(ingredient1Mock);
        Assert.assertFalse(burger.ingredients.isEmpty());
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientExpectedIngredientsAreMoved() {
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);
        Mockito.when(ingredient2Mock.getType()).thenReturn(IngredientType.FILLING);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredient2Mock.getType(), burger.ingredients.get(0).getType());
    }

    @Test
    public void getPriceExpectedPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1Mock);
        Mockito.when(bunMock.getPrice()).thenReturn(111F);
        Mockito.when(ingredient1Mock.getPrice()).thenReturn(100F);
        Assert.assertEquals(322, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptExpectedReceipt() {
        String bunName = "Батон Нарезной";
        String ingredientType = "sauce";
        String ingredientName = "Майонез";
        float price = 100500F;
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn(bunName);
        burger.addIngredient(ingredient1Mock);
        Mockito.when(ingredient1Mock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1Mock.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn(price);
        String receipt=
                String.format("(==== %s ====)\n", bunName)
               + String.format("= %s %s =\n", ingredientType, ingredientName)
               + String.format("(==== %s ====)\n", bunName)
               + "\nPrice: 100500,000000\n";
        Assert.assertEquals(receipt, burger.getReceipt());
    }
}