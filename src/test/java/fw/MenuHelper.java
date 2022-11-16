package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MenuHelper extends HelperBase {

    public static final String LOG_OUT_XPATH = "//android.view.ViewGroup[@content-desc='menu item log out']";
    public static final String LOG_IN_XPATH = "//android.view.ViewGroup[@content-desc='menu item log in']";

    public static final String RESET_APP_STATE_XPATH = "//android.view.ViewGroup[@content-desc='menu item reset app']";

    public static final String RESET_APP_STATE_CONFIRM_BTN_XPATH = "//android.widget.Button[2]";
    public static final String RESET_APP_STATE_CANCEL_BTN_XPATH = "//android.widget.Button[1]";

    public MenuHelper(AppiumDriver driver) {
        super(driver);
    }

    public void clickLogInOption() {
        waitUntilElementIsClickable(By.xpath(LOG_IN_XPATH));
        tap(By.xpath(LOG_IN_XPATH));
    }

    public void waitToBeClickable() {
        waitUntilElementIsClickable(By.xpath(RESET_APP_STATE_XPATH));
    }

    public void clickLogOutOption() {
        waitUntilElementIsClickable(By.xpath(LOG_OUT_XPATH));
    }

    public void clickResetAppState() {
        waitUntilElementIsClickable(By.xpath(RESET_APP_STATE_XPATH));
        tap(By.xpath(RESET_APP_STATE_XPATH));
    }

    public void confirmResetAppState() {
        waitUntilElementIsClickable(By.xpath(RESET_APP_STATE_CONFIRM_BTN_XPATH));
        tap(By.xpath(RESET_APP_STATE_CONFIRM_BTN_XPATH));

        waitUntilElementIsPresent(By.id("android:id/alertTitle"));
        tap(By.id("android:id/button1"));
    }

    public void cancelResetAppState() {
        waitUntilElementIsClickable(By.xpath(RESET_APP_STATE_CANCEL_BTN_XPATH));
        tap(By.xpath(RESET_APP_STATE_CANCEL_BTN_XPATH));
    }
}
