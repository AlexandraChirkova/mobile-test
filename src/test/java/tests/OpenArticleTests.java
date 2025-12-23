package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;


public class OpenArticleTests extends BaseTest {

    @Test
    void openAnyArticleTest() {
        step("Open search and type query", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");

        });

        step("Open first search result", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });

        step("Verify article opened", () -> {
            $(id("org.wikipedia.alpha:id/page_contents_container")).shouldBe(visible);
        });
    }
}
