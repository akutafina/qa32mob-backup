package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsContainerHelper extends HelperBase {

    public static final String ITEM_CARDS_XPATH = "(//android.view.ViewGroup[@content-desc='store item'])";
    public static final String ITEM_CARD_XPATH = "(//android.view.ViewGroup[@content-desc='store item'])[$idx]//android.widget.ImageView";

    public ProductsContainerHelper(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForLoad() {
        return waitUntilElementIsPresent(By.xpath(ITEM_CARDS_XPATH + "[1]"));
    }

    public void clickOnItemCard(Integer idx) {
        waitUntilElementIsClickable(By.xpath(ITEM_CARD_XPATH.replace("$idx", idx.toString())));
        tap(By.xpath(ITEM_CARD_XPATH.replace("$idx", idx.toString())));
    }

    public void scrollToItemName(String productTitle) {
        swipeToElementWithText("store item", productTitle);
        System.out.println("Text of the elem:"+ getTextOfTheElement(By.xpath(ITEM_CARDS_XPATH)));
    }
}
