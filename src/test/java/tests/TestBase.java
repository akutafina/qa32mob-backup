package tests;

import fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp()  {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
