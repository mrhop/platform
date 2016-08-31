package cn.hopever.platform.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/8/22.
 */
@Component
@ConfigurationProperties(prefix = "logging")
public class ExampleConfigProperties {

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

}
