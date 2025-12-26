package tests;

import org.junit.jupiter.api.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    SearchPage searchPage = new SearchPage();

    @Test
    void successfulSearchTest() {
        searchPage
                .openSearch()
                .typeSearchQuery("Appium")
                .shouldHaveResults();
    }
}
