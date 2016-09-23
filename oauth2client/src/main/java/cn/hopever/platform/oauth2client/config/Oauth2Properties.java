package cn.hopever.platform.oauth2client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/9/13.
 */
@Configuration
@ConfigurationProperties("config.oauth2")
@Data
public class Oauth2Properties {
    private String accessTokenUri;
    private String userAuthorizationUri;
    private String clientID;
    private String clientSecret;
    private List<String> clientScopes;
    private String domainName;
    private String secretKey;
    private String validateUserUri;
    private String getUserUri;
}
