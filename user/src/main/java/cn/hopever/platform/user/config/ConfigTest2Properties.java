package cn.hopever.platform.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/8/22.
 */
@Component
@ConfigurationProperties(prefix = "my")
public class ConfigTest2Properties {

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

}
