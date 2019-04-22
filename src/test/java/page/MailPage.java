package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage{


    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public <GenericPage> GenericPage recoverPassword (String userEmail){
        emailField.sendKeys(userEmail);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/checkpoint")) {
            return (GenericPage) new MailPage(driver);
        } else {
            return (GenericPage) null;
        }
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("");
    }
}
