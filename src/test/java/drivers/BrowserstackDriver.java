package drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import config.ConfigProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities ignored) {

        try {
            var cfg = ConfigProvider.config;
            String hub = cfg.bsHub()
                    .replace("https://", "")
                    .replace("http://", "");

            String remoteUrl =
                    "https://" + cfg.bsUser() + ":" + cfg.bsKey() + "@" + hub;

            Configuration.remote = remoteUrl;

            UiAutomator2Options options = new UiAutomator2Options();

            options.setCapability("appium:app", cfg.androidApp());
            options.setCapability("platformName", "Android");
            options.setCapability("appium:automationName", "UIAutomator2");
            options.setCapability("appium:deviceName", cfg.androidDevice());
            options.setCapability("appium:platformVersion", cfg.androidOsVersion());

            return new AndroidDriver(new URL(remoteUrl), options);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create BrowserStack driver", e);
        }
    }
}
