package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void LoginPositiveTest(){
        String validEmail = "bob@example.com";
        String validPwd = "10203040";

        app.getHeaderHelper().waitForHeaderToBeClickable();
        app.getHeaderHelper().clickMenuBtn();
        app.getMenuHelper().clickLogInOption();
        app.getLoginScreenHelper().login(validEmail, validPwd);
        Assert.assertNotEquals(app.getProductsContainerHelper().waitForLoad(), null, "Items container os loaded." );
    }

    @Test
    public void LoginNegativeTest(){
        String validEmail = "invalid_email.com";
        String validPwd = "10203040";
        String expectedErrMsgTxt = "Provided credentials do not match any user in this service.";

        app.getHeaderHelper().waitForHeaderToBeClickable();
        app.getHeaderHelper().clickMenuBtn();
        app.getMenuHelper().clickLogInOption();
        app.getLoginScreenHelper().login(validEmail, validPwd);
        app.getLoginScreenHelper().waitForErrorMsgToAppear();
        Assert.assertEquals(app.getLoginScreenHelper().getErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");
    }
}
