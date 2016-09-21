package cn.hopever.platform.oauth2client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Donghui Huo on 2016/9/6.
 */
@Configuration
@EnableOAuth2Client
//@EnableWebMvc
public class ClientSecurityConfig {

    @Autowired
    private Oauth2Properties oauth2Properties;

    @Bean(name = "authorizationCodeRestTemplate")
    public OAuth2RestOperations restCodeTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resource(), oauth2ClientContext);
    }


    @Bean(name = "clientRestTemplate")
    public OAuth2RestOperations restClientTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resourceClient(), oauth2ClientContext);
    }

    @Bean(name = "restTemplate")
    public RestTemplate restSimpleTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private OAuth2ProtectedResourceDetails resource() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId(oauth2Properties.getClientID());
        resource.setClientSecret(oauth2Properties.getClientSecret());
        resource.setAccessTokenUri(oauth2Properties.getAccessTokenUri());
        resource.setUserAuthorizationUri(oauth2Properties.getUserAuthorizationUri());
        resource.setScope(oauth2Properties.getClientScopes());
        return resource;
    }


    private OAuth2ProtectedResourceDetails resourceClient() {
        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
        resource.setClientId(oauth2Properties.getClientID());
        resource.setClientSecret(oauth2Properties.getClientSecret());
        resource.setAccessTokenUri(oauth2Properties.getAccessTokenUri());
        resource.setScope(oauth2Properties.getClientScopes());
        return resource;
    }


//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/static/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
//
//    @Override
//    public void configureDefaultServletHandling(
//            DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

}
