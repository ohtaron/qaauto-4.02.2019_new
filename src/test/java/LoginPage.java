import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //this = LoginPage.class
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

    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }
}
