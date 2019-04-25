package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.LoginSubmitPage;

/**
 * Test class for LinkedIn login test.
 */
public class LinkedinLoginTest extends BaseTest {

    /**
     * Method with DataProvider TestNG feature with variables to insert.
     * @return input values.
     */
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                //{ "linkedin.tst.yanina@gmail.com", "Test123!" },
                //{ "linkedin.TST.yanina@gmail.com", "Test123!" },
                { " linkedin.TST.yanina@gmail.com ", "Test123!" }
        };
    }

    /**
     * Method that assert page is loaded with correct values.
     * @param userEmail login data.
     * @param userPassword password data.
     */
    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }

    /**
     * Method with DataProvider TestNG feature with variables to insert.
     * @return input values.
     */
    @DataProvider
    public Object[][] emptyValuesProvider() {
        return new Object[][]{
                { "", "" },
                { "linkedin.TST.yanina@gmail.com", "" },
                { "", "Test123!" }
        };
    }

    /**
     * Method that assert page is loaded with empty values.
     * @param userEmail login data.
     * @param userPassword password data.
     */
    @Test(dataProvider = "emptyValuesProvider")
    public void negativeWithEmptyValuesTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        LoginPage newLoginPage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(newLoginPage.isPageLoaded(), "Login page is not loaded.");
    }

    /**
     * Method with DataProvider TestNG feature with variables to insert.
     * @return input values.
     */
    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "12345", "", "Hmm, that's not the right password. Please try again or request a new one."},
                { "linkedin.tst.yanina@@gmail.com", "Test123!", "Hmm, we don't recognize that email. Please try again.", ""},
        };
    }

    /**
     * Method that assert page is loaded with wrong values.
     * @param userEmail login data.
     * @param userPassword password data.
     * @param expectedEmailValidation validation of correct login values.
     * @param expectedPasswordValidation validation of correct password values.
     */
    @Test(dataProvider = "invalidDataProvider")
    public void negativeNavigatesToLoginSubmitTest(String userEmail,
                                                   String userPassword,
                                                   String expectedEmailValidation,
                                                   String expectedPasswordValidation) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(), expectedEmailValidation,
                "userEmail validation message is incorrect.");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationMessage(), expectedPasswordValidation,
                "userPassword validation message is incorrect.");
    }
}
