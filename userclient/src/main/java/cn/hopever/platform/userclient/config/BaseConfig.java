package cn.hopever.platform.userclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Configuration
@ConfigurationProperties("config.user")
@Data
public class BaseConfig {
    private String personalinfo;
    private String userlist;
}
