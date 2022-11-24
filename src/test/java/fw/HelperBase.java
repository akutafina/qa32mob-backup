package fw;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    public static final int EXPL_WAIT_TIMEOUT_SEC = 10;
    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            waitUntilElementIsPresent(locator);
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void sleep(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void typeAndTapEnter(By locator, String text) {
        if (text != null) {
            waitUntilElementIsPresent(locator);
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
            //or use "Go"
            //http://appium.io/docs/en/writing-running-appium/android/android-ime
        }
    }

    public WebElement waitUntilElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPL_WAIT_TIMEOUT_SEC);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilElementIsPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPL_WAIT_TIMEOUT_SEC);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String getTextOfTheElement(By locator) {
        return driver.findElement(locator).getText();
    }

    public void swipeScreen(Direction dir) {
        //https://appium.io/docs/en/writing-running-appium/tutorial/swipe/simple-screen/
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions
        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 2000; // ms

        final int PRESS_TIME = 1000; // ms

        int edgeBorder = 30; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .longPress(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            System.out.println("Swiped " + dir);
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public void swipeDown() {
        try {
            String scrollableList = "product screen";
            String elementClassName = "android.widget.TextView";
            String anyText = "Add To Cart button";

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().description(\"" + scrollableList + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + anyText + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }

    public void swipeToElementWithText(String parentContDesc, String elementText) {
        try {
            String elementClassName = "android.widget.TextView";
    driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().description(\"" + parentContDesc + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + elementText + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
