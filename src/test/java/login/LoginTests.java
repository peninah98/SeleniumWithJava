package login;

import org.example.LoginPage;
import org.example.SecureAreaPage;

import static org.testng.Assert.assertEquals;

import base.BaseTests;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage.getAlertText();
        assertEquals(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
