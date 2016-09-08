package cn.hopever.platform.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Donghui Huo on 2016/8/19.
 */
@SpringBootApplication
//@ComponentScan("cn.hopever.platform")
public class Oauth2ClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Oauth2ClientApplication.class);
    }
}
