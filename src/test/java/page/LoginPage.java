package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject class for LoginPage.
 */
public class LoginPage extends BasePage{


    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailRecoveryField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//button[@id = 'reset-password-submit-button']")
    private WebElement findAccountButton;

    /**
     * Constructor for LoginPage object.
     * @param driver WebDriver instance from BaseTest
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //this = page.LoginPage.class
    }

    public <GenericPage> GenericPage login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) PageFactory.initElements(driver, HomePage.class);
        }
        if (driver.getCurrentUrl().contains("/login-submit")) {
            return (GenericPage) new LoginSubmitPage(driver);
        } else {
            return (GenericPage) new LoginPage(driver);
        }
    }

    public <GenericPage> GenericPage recoverPassword (String userEmail){
        emailRecoveryField.sendKeys(userEmail);
        findAccountButton.click();
        if (driver.getCurrentUrl().contains("/checkpoint")) {
            return (GenericPage) new PassRecoveryPage(driver);
        } else {
            return (GenericPage) null;
        }
    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }
}
