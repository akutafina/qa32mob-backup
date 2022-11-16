package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;

    LoginScreenHelper loginScreenHelper;
    HeaderHelper headerHelper;
    MenuHelper menuHelper;

    ShopCartScreenHelper shopCartHelper;

    ItemPageHelper itemPageHelper;
    ProductsContainerHelper productsContainerHelper;

    public ProductsContainerHelper getProductsContainerHelper() {
        return productsContainerHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public MenuHelper getMenuHelper() {
        return menuHelper;
    }

    public LoginScreenHelper getLoginScreenHelper() {
        return loginScreenHelper;
    }


    public ItemPageHelper getItemPageHelper() {
        return itemPageHelper;
    }

    public ShopCartScreenHelper getShopCartHelper() {
        return shopCartHelper;
    }

    public void init() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa32mob");
        capabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        capabilities.setCapability("app", "/Users/akutafina/Documents/Tools/Demo244.apk");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        loginScreenHelper = new LoginScreenHelper(driver);
        menuHelper = new MenuHelper(driver);
        headerHelper = new HeaderHelper(driver);
        productsContainerHelper = new ProductsContainerHelper(driver);
        itemPageHelper = new ItemPageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
