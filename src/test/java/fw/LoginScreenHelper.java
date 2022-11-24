package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginScreenHelper extends HelperBase {

    public static final String LOGIN_INPUT_FIELD_XPATH = "//android.widget.EditText[@content-desc='Username input field']";
    public static final String PWD_INPUT_FIELD_XPATH = "//android.widget.EditText[@content-desc='Password input field']";
    public static final String LOGIN_BTN_XPATH = "//android.view.ViewGroup[@content-desc='Login button']";
    public static final String ERROR_MSG_XPATH = "//android.view.ViewGroup[@content-desc='generic-error-message']/android.widget.TextView";

    public LoginScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(String login, String pwd) {
        waitUntilElementIsClickable(By.xpath(LOGIN_INPUT_FIELD_XPATH));
        typeAndTapEnter(By.xpath(LOGIN_INPUT_FIELD_XPATH), login);
        waitUntilElementIsClickable(By.xpath(PWD_INPUT_FIELD_XPATH));
        typeAndTapEnter(By.xpath(PWD_INPUT_FIELD_XPATH), pwd);
//        hideKeyboard();
        tap(By.xpath(LOGIN_BTN_XPATH));
    }

    }

    public void waitForErrorMsgToAppear() {
        waitUntilElementIsPresent(By.xpath(ERROR_MSG_XPATH));
    }

    public String getErrorMsgText() {
        return getTextOfTheElement(By.xpath(ERROR_MSG_XPATH));
    }

}
