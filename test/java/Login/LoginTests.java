package Login;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {

    @Test(description = "Successful Login Test")
    public void test_SuccessfulLogin() {
        LoginPage loginPage = hompage.clickformAuthLink();
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secAreaPage = loginPage.clickLogin();

        Assert.assertTrue(secAreaPage.VerifyStatus().contains(
                "You logged into a secure area!"),
                "Alert text is incorrect");
    }

    @Test(description = "Unsuccessful Login Test")
    public void test_UnSuccessfulLogin() {
        LoginPage loginPage = hompage.clickformAuthLink();
        loginPage.setUserName("tomsmith!");
        loginPage.setPassword("SuperSecretPassword");
        SecureAreaPage secAreaPage = loginPage.clickLogin();

        Assert.assertEquals(secAreaPage.VerifyStatus().contains(
                "Your username is invalid!"),
                "Alert text is incorrect");
    }
}
