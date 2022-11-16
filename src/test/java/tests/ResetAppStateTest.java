package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetAppStateTest extends TestBase{

    @Test
    public void resetAppStateTest(){
        app.getHeaderHelper().waitForHeaderToBeClickable();
        app.getHeaderHelper().clickMenuBtn();
        app.getMenuHelper().clickResetAppState();
        app.getMenuHelper().cancelResetAppState();
        app.getMenuHelper().clickResetAppState();
        app.getMenuHelper().confirmResetAppState();
    }
    @Test
    public void addItemAndResetAppStateTest() {
        app.getProductsContainerHelper().waitForLoad();
        app.getProductsContainerHelper().clickOnItemCard(1);
        app.getItemPageHelper().addToCart();
        app.getHeaderHelper().waitForAddedItemsCounterToAppear();
        Assert.assertTrue(app.getHeaderHelper().isAddedItemsCounterPresent(), "Items number badge appeared on the shopping cart icon.");
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "1", "Items number badge on the shopping cart icon shows: 1.");

        app.getHeaderHelper().clickMenuBtn();
        app.getMenuHelper().clickResetAppState();
        app.getMenuHelper().confirmResetAppState();
        app.getMenuHelper().waitToBeClickable();
        Assert.assertFalse(app.getHeaderHelper().isAddedItemsCounterPresent(), "Items number badge appeared on the shopping cart icon.");
    }
}
