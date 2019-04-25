package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

/**
 * Parent class for every test classes.
 */
public class BaseTest {

    protected WebDriver driver; //private if code written right way
    protected LoginPage loginPage;

    /**
     * Method that launches ChromeDriver new page and opens LinkedIn site.
     */
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(driver);
    }

    /**
     * Method that closes ChromeDriver after finishing tests.
     */
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
