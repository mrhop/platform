package cn.hopever.platform.oauth2client.config;

import cn.hopever.platform.utils.json.JacksonUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/13.
 */
@Configuration
@ConfigurationProperties("config.common")
@Data
public class CommonProperties {
    public static Logger logger = LoggerFactory.getLogger(CommonProperties.class);
    private int pageSize;
    private String relatedusers;
    private String imageUpload;
    private String fileUpload;
    private String docUpload;
    private String imageDel;
    private String fileDel;
    private String docDel;
    private String imagePathPrev;
    private String filePathPrev;
    private String docPathPrev;
    private String defaultUserPhoto;
    private Map<String,Object> mapRules;
    public CommonProperties(){
        mapRules = new HashMap<>();
        Map<String,Object> mapForm = null;
        try {
            mapForm = JacksonUtil.mapper.readValue(getClass().getClassLoader().getResourceAsStream("config/formRule-common.json"),Map.class);
        } catch (IOException e) {
            logger.warn("read file error:"+e);
        }
        mapRules.put("formRules",mapForm==null?new HashMap<>():mapForm);
    }
}
