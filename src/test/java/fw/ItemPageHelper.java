package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ItemPageHelper extends HelperBase {

    public static final String ADD_TO_CART_BTN_XPATH = "//android.view.ViewGroup[@content-desc='Add To Cart button']";

    public ItemPageHelper(AppiumDriver driver) {
        super(driver);
    }

    public void addToCart() {
        //swipeScreen(Direction.DOWN);
        swipeDown();
        waitUntilElementIsClickable(By.xpath(ADD_TO_CART_BTN_XPATH));
        tap(By.xpath(ADD_TO_CART_BTN_XPATH));
    }

}
