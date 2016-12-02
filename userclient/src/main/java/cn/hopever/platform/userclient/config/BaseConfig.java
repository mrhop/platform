package cn.hopever.platform.userclient.config;

import cn.hopever.platform.utils.json.JacksonUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

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
    private String delete;
    private String info;
    private String update;
    private String updatepersonal;
    private String roleoptions;
    private String clientoptions;
    private String moduleroleoptions;
    private String save;
    //client
    private String clientlist;
    private String clientinfo;
    private String clientupdate;
    private String clientsave;
    private String clientdelete;

    //modulerole
    private String modulerolelist;
    private String moduleroleinfo;
    private String moduleroleupdate;
    private String modulerolesave;
    private String moduleroledelete;
    private String clientoptionsofmodulerole;

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
        File fileForm = new File(getClass().getClassLoader().getResource("config/formRule.json").getFile());
        Map<String,Object> mapForm = null;
        try {
            mapForm = JacksonUtil.mapper.readValue(fileForm,Map.class);
        } catch (IOException e) {
            logger.warn("read file error:"+e);
        }
        mapRules.put("formRules",mapForm==null?new HashMap<>():mapForm);
    }

    public  Map<String,Object> getTableRule(String key){
        Map rule =  (HashMap) ((Map) this.mapRules.get("tableRules")).get(key);
        Map ruleReturn =(Map) SerializationUtils.deserialize(SerializationUtils.serialize(rule));
        return ruleReturn;
    }
    public  Map<String,Object> getFormRule(String key){
        Map rule =  (HashMap) ((Map) this.mapRules.get("formRules")).get(key);
        Map ruleReturn =(Map) SerializationUtils.deserialize(SerializationUtils.serialize(rule));
        return ruleReturn;
    }
}
