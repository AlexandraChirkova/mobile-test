package tests;

import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.SearchPage;

public class OpenArticleTests extends BaseTest {

    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();

    @Test
    void openAnyArticleTest() {
        searchPage
                .openSearch()
                .typeSearchQuery("Appium")
                .openFirstResult();

        articlePage.shouldBeOpened();
    }
}
