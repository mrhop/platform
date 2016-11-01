package cn.hopever.platform.oauth2client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/9/13.
 */
@Configuration
@ConfigurationProperties("config.common")
@Data
public class CommonProperties {
    private int pageSize;
}
