package tests;

import org.testng.annotations.Test;

public class DeepLinks extends TestBase{


    @Test
    public void DeepLinkDemo(){
        app.openDeepLink("login");
        app.getLoginScreenHelper().waitToLoad();
        app.openDeepLink("store-overview");
        app.getProductsContainerHelper().waitForLoad();
    }
}
