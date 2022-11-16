package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderHelper extends HelperBase {
    public static final String ADDED_ITEMS_CART_BADGE_XPATH = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView";
    private static final String MENU_BTN_XPATH = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView";

    public HeaderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void clickMenuBtn() {
        tap(By.xpath(MENU_BTN_XPATH));
    }

    public void waitForHeaderToBeClickable() {
        waitUntilElementIsClickable(By.xpath(MENU_BTN_XPATH));
    }

    public boolean isAddedItemsCounterPresent() {
        return isElementPresent(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH));
    }

    public String getAddedItemsCounterNumber() {
        return driver.findElement(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH)).getText();
    }

    public void waitForAddedItemsCounterToAppear() {
        waitUntilElementIsPresent(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH));
    }
}
