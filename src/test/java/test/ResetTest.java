package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class ResetTest extends BaseTest{

    @Test
    public void basicSearchTest() {
        String userEmail = "itea.ln.test@gmail.com";
        String userPassword = "fghdfgh";
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded.");

        PassRecoveryPage passRecoveryPage = loginPage.recoverPassword(userEmail);

        Assert.assertTrue(passRecoveryPage.isPageLoaded(), "PassRecovery page is not loaded.");

        MailPage mailPage = new MailPage(driver);

        Assert.assertTrue(mailPage.isPageLoaded(), "PassRecovery page is not loaded.");

        MailPageLogin mailPageLogin = new MailPageLogin(driver);

        Assert.assertTrue(mailPageLogin.isPageLoaded(), "PassRecovery page is not loaded.");

        LinkedInVerificationMail linkedInVerificationMail = new LinkedInVerificationMail(driver);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);

        SuccessfulChangedPass successfulChangedPass = new SuccessfulChangedPass(driver);

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");

    }
}
