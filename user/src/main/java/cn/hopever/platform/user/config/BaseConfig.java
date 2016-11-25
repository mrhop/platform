package cn.hopever.platform.user.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Configuration
@ConfigurationProperties("app")
@Data
public class BaseConfig {

    private String name;
    private String passwordRandom;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
