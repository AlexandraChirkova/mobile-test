package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends BaseTest {

    @Test
    void successfulSearchTest() {

        step("Skip onboarding if it appears", () -> {
            if ($(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).exists()) {
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"))
                        .shouldBe(visible)
                        .click();
            }

            if ($(accessibilityId("Skip")).exists()) {
                $(accessibilityId("Skip"))
                        .shouldBe(visible)
                        .click();
            }
        });

        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia"))
                    .shouldBe(visible)
                    .click();

            var input = $(id("org.wikipedia.alpha:id/search_src_text"));
            input.shouldBe(visible).click();
            input.toWebElement().sendKeys("Appium");
        });

        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }
}

