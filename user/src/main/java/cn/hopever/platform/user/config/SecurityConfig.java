package cn.hopever.platform.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * Created by Donghui Huo on 2016/9/5.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BaseConfig baseConfig;

    public static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);


    @Autowired
    @Qualifier("userTableService")
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder pe = null;
        try {
            pe = new BCryptPasswordEncoder(4, new SecureRandom(baseConfig.getPasswordRandom().getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            pe = new BCryptPasswordEncoder(4, new SecureRandom(baseConfig.getPasswordRandom().getBytes()));
        }
        return pe;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        org.springframework.security.oauth2.client.token.AccessTokenRequest a;
        org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter b;
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    @Autowired // <-- This is crucial otherwise Spring Boot creates its own
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //logger.info("Defining inMemoryAuthentication (2 users)");
        //使用
        auth
                .authenticationProvider(authenticationProvider())
//                .inMemoryAuthentication()
//                .withUser("user").password("password")
//                .roles("user")
//                .and()
//                .withUser("admin").password("password")
//                .roles("user", "admin")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .httpBasic().disable()
                .anonymous().disable()
                .authorizeRequests()
                // .antMatchers("/role/**","/module/**").permitAll()
                .anyRequest().authenticated();
    }
//    public static void main(String args[]){
//        try {
//            PasswordEncoder pe = new BCryptPasswordEncoder(4, new SecureRandom("hopever".getBytes("UTF-8")));
//            PasswordEncoder pe1 = new BCryptPasswordEncoder(4, new SecureRandom("hopever".getBytes("UTF-8")));
//            System.out.println(pe1.matches("admin@","$2a$04$D1cv4KmBEGHGGQFZG/UXf.Tu/yauxK1rJwahfvPgxC4XGvZCUsW96"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//    }
}
