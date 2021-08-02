package qaguru.test.owner;

import org.aeonbits.owner.Config;

import java.net.URL;
@Config.Sources({
        "classpath:${stage}.properties"
})
@Config.LoadPolicy(Config.LoadType.MERGE)

public interface SeleniumConfig extends Config {

    @DefaultValue("http://selenoid:4444/wd/hub")
    @Key("url")
    URL getRemoteUrl();

    @DefaultValue("false")
    @Key("remote")
    boolean isRemote();

    @DefaultValue("chrome")
    @Key("browser")
    String isBrowser();

    @DefaultValue("84.8")
    @Key("version")
    String isVersion();

}