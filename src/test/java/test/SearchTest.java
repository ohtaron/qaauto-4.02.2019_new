package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultsPage;

import java.util.List;

public class SearchTest extends BaseTest{

    @Test
    public void basicSearchTest() {
        String userEmail = "ohta@i.ua";
        String userPassword = "fghdfghd";
        String searchTerm = "HR";
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResults page is not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10, "Results count is wrong");

        List<String> searchResults = searchResultsPage.getSearchResults();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm), "searchTerm: " + searchTerm + " not found in: \n" + searchResult);
        }


    }

}
