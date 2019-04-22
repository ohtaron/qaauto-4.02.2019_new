package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.MailPageLogin;

import static java.lang.Thread.sleep;

public class LinkedInVerificationMail extends BasePage{


    @FindBy(xpath = "//tr[contains(@class, 'zA')]")
    private WebElement linkedMail;

    @FindBy(xpath = "//a[@target = '_blank')]")
    private WebElement verificationMail;

    public LinkedInVerificationMail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public <GenericPage> GenericPage linkedGMail (){
        linkedMail.click();
        verificationMail.click();

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
