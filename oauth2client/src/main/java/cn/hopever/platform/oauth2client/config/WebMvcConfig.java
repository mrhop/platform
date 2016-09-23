package cn.hopever.platform.oauth2client.config;

import cn.hopever.platform.oauth2client.web.filter.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

/**
 * Created by Donghui Huo on 2016/9/21.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(commonFilter());
        registration.addUrlPatterns("*.html");
        registration.setName("commonFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "commonFilter")
    public Filter commonFilter() {
        return new CommonFilter();
    }
}