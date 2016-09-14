package cn.hopever.platform.navigate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/9/14.
 */
@ConfigurationProperties("platform")
@Data
@Component
public class PlatformConfig {
    private final List<HashMap<String,String>> list = new ArrayList<>();
}
