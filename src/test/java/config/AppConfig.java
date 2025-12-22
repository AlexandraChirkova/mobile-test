package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:config.properties"
})
public interface AppConfig extends Config {

    @Key("bs.user") String bsUser();
    @Key("bs.key") String bsKey();
    @Key("bs.hub") String bsHub();

    @Key("android.app") String androidApp();
    @Key("android.device") String androidDevice();
    @Key("android.os_version") String androidOsVersion();
}
