package cn.hopever.platform.userclient.config;

import cn.hopever.platform.utils.json.JacksonUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Configuration
@ConfigurationProperties("config.user")
@Data
public class BaseConfig {

    public static Logger logger = LoggerFactory.getLogger(BaseConfig.class);

    private String personalinfo;
    private String userlist;
    private String rolelist;
    private Map<String,Object> mapRules;

    public BaseConfig(){
        mapRules = new HashMap<>();
        File file = new File(getClass().getClassLoader().getResource("config/tableRule.json").getFile());
        Map<String,Object> map = null;
        try {
            map = JacksonUtil.mapper.readValue(file,Map.class);
        } catch (IOException e) {
            logger.warn("read file error:"+e);
        }
        mapRules.put("tableRules",map==null?new HashMap<>():map);
    }
}
