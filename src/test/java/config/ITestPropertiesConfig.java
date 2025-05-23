package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default_local.properties"
})
public interface ITestPropertiesConfig extends Config {

    @Key("isRemote")
    Boolean isRemote();

}
