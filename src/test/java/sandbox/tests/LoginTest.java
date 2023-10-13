package sandbox.tests;

import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import sandbox.pages.BaseClass;
import sandbox.pages.LoginPage;

public class LoginTest extends BaseClass {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.selectLanguage();
        loginPage.clickNextBtn();
        loginPage.createAccountBtn();
        loginPage.enterMobileNu();
        loginPage.clickOtp();
        loginPage.enterOTP();

    }

}
