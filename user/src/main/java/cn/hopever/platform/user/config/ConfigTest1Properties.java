package cn.hopever.platform.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/8/22.
 */
@Component
@ConfigurationProperties(prefix = "app")
public class ConfigTest1Properties {
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private String name;

}
