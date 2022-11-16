package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase{

    @Test
    public void addItemToShoppingCartPositive(){
        app.getProductsContainerHelper().waitForLoad();
        app.getProductsContainerHelper().clickOnItemCard(1);
        app.getItemPageHelper().addToCart();
        app.getHeaderHelper().waitForAddedItemsCounterToAppear();
        Assert.assertTrue(app.getHeaderHelper().isAddedItemsCounterPresent(), "Items number badge appeared on the shopping cart icon.");
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "1", "Items number badge on the shopping cart icon shows: 1.");
        //app.getShopCartHelper();
        //Assert.assertEquals(app.getShopCartHelper().getCardsAmount(),1, "Amount of items cards shown in the shopping cart: 1.");
    }
}
