package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage{


    @FindBy(xpath = "//tr[contains(@class, 'zA')]")
    private WebElement linkedMail;

    @FindBy(xpath = "//a[@target = '_blank')]")
    private WebElement verificationMail;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return false;
    }
}
