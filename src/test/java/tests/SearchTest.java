package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTest extends BaseTest {

    @Test
    void successfulSearchTest() {

        step("Open search", () ->
                $(accessibilityId("Search Wikipedia"))
                        .shouldBe(visible)
                        .click()
        );

        step("Type search text", () -> {
            var input = $(id("org.wikipedia.alpha:id/search_src_text"));
            input.shouldBe(visible).click();
            input.toWebElement().sendKeys("Appium");
        });

        step("Verify results", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0))
        );
    }
}
