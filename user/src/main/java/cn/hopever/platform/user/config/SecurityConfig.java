package cn.hopever.platform.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Donghui Huo on 2016/9/5.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    @Autowired // <-- This is crucial otherwise Spring Boot creates its own
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("Defining inMemoryAuthentication (2 users)");
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password")
                .roles("USER")
                .and()
                .withUser("admin").password("password")
                .roles("USER", "ADMIN")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .httpBasic().disable()
                .anonymous().disable()
                .authorizeRequests().anyRequest().authenticated();
    }
}
