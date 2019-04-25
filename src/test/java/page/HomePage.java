package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * PageObject class for HomePage.
 */
public class HomePage extends BasePage{


    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavigationItem;
    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    /**
     * Constructor for HomePage object.
     * @param driver WebDriver instance from BaseTest.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if page was loaded.
     * @return true/false if page loaded or not.
     */
    public boolean isPageLoaded() {
        return profileNavigationItem.isDisplayed()
                && driver.getTitle().contains("Linked");
    }

    /**
     * Search method to search data by searchTerm variable.
     * @param searchTerm variable that contains data to fill up search line.
     * @return new SearchResultsPage.
     */
    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchResultsPage(driver);
    }
}
