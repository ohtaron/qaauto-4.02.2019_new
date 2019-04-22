package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class MailPageLogin extends BasePage{


    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passField;

    @FindBy(xpath = "//div[@id=identifierNext']")
    private WebElement loginNext;

    @FindBy(xpath = "//div[@id=passwordNext']")
    private WebElement passNext;

    public MailPageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public <GenericPage> GenericPage recoverPassword (String userEmail){
        emailField.sendKeys("itea.ln.test");
        loginNext.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        passField.sendKeys("fghdfghd");
        passNext.click();
        if (driver.getCurrentUrl().contains("/checkpoint")) {
            return (GenericPage) new MailPageLogin(driver);
        } else {
            return (GenericPage) null;
        }
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("");
    }

}
