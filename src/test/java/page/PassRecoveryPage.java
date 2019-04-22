package page;

import org.openqa.selenium.WebDriver;
import page.LoginPage;


public class PassRecoveryPage extends BasePage{


    LoginPage loginPage;

    public PassRecoveryPage(WebDriver driver) {

    }


    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("");
    }

    public void urlGmail() {
        driver.get("https://www.linkedin.com/");
    }

}

