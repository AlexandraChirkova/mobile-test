package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AppConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities ignored) {

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", config.bsUser());
        caps.setCapability("browserstack.key", config.bsKey());

        caps.setCapability("app", config.androidApp());

        caps.setCapability("deviceName", config.androidDevice());
        caps.setCapability("platformVersion", config.androidOsVersion());

        try {
            return new RemoteWebDriver(
                    new URL(config.bsHub()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
