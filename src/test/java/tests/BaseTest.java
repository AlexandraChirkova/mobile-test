package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        Configuration.remoteConnectionTimeout = 10000;
        Configuration.remoteReadTimeout = 60000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.removeListener("AllureSelenide");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false));
        open();
    }

    @AfterEach
    void addAttachments() {
        try { Attach.screenshotAs("Last screenshot"); } catch (Exception ignored) {}
        try { Attach.pageSource(); } catch (Exception ignored) {}
        closeWebDriver();

    }
}
