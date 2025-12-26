package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticlePage {

    private final String articleContentId = "org.wikipedia.alpha:id/page_contents_container";

    @Step("Проверить, что статья успешно открыта")
    public ArticlePage shouldBeOpened() {
        $(id(articleContentId)).shouldBe(visible);
        return this;
    }
}
