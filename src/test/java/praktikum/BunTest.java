package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    Bun bun;
    private final String BUN_NAME = "black bun";
    private final float PRICE = 100;

    @Before
    public void setup() {
        bun = new Bun(BUN_NAME, PRICE);
    }

    @Test
    public void getNameReturnBunName() {
        Assert.assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceReturnBunPrice() {
        Assert.assertEquals(PRICE, bun.getPrice(),0.0);
    }
}