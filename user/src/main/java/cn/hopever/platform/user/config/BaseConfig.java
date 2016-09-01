package cn.hopever.platform.user.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Configuration
public class BaseConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
