package cn.hopever.platform.cmsclient.config;

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
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Configuration
@ConfigurationProperties("config.cms")
@Data
public class BaseConfig {

    public static Logger logger = LoggerFactory.getLogger(BaseConfig.class);

    //    #website
    private String websitelist;
    private String websiteinfo;
    private String websiteupdate;
    private String websitesave;
    private String websitedelete;
    //    #resource
    private List<String> resourceTypes;
    private String resourcelist;
    private String resourceinfo;
    private String resourceupdate;
    private String resourcesave;
    private String resourcedelete;
    //    #template
    private List<String> templateLayoutTypes;
    private List<String> templateLayoutScales;
    private String templatelist;
    private String templateinfo;
    private String templateupdate;
    private String templatesave;
    private String templatedelete;
    //    #block
    private List<String> blockTypes;
    private String blocklist;
    private String blockinfo;
    private String blockupdate;
    private String blocksave;
    private String blockdelete;
    //    #news
    private String newslist;
    private String newsinfo;
    private String newsupdate;
    private String newssave;
    private String newsdelete;
    //    #newsType
    private String newstypelist;
    private String newstypeinfo;
    private String newstypeupdate;
    private String newstypesave;
    private String newstypedelete;
    //    #poll
    private String polllist;
    private String pollinfo;
    private String pollupdate;
    private String pollsave;
    private String polldelete;
    //    #pollOption
    private String polloptionlist;
    private String polloptioninfo;
    private String polloptionupdate;
    private String polloptionsave;
    private String polloptiondelete;
    //    #operation
    private List<String> relatedOperations;
    private String optionlist;
    private String optioninfo;
    private String optionupdate;
    private String optionsave;
    private String optiondelete;
    //    #navigate
    private List<String> navigateTypes;
    private String navigatelist;
    private String navigateinfo;
    private String navigateupdate;
    private String navigatesave;
    private String navigatedelete;
    //    #fileLibrary
    private String filelibrarylist;
    private String filelibraryinfo;
    private String filelibraryupdate;
    private String filelibrarysave;
    private String filelibrarydelete;
    //    #fileLibraryType
    private String filelibrarytypelist;
    private String filelibrarytypeinfo;
    private String filelibrarytypeupdate;
    private String filelibrarytypesave;
    private String filelibrarytypedelete;
    //    #article
    private String articlelist;
    private String articleinfo;
    private String articleupdate;
    private String articlesave;
    private String articledelete;

    private Map<String, Object> mapRules;

    public BaseConfig() {
        mapRules = new HashMap<>();
        File file = new File(getClass().getClassLoader().getResource("config/tableRule.json").getFile());
        Map<String, Object> map = null;
        try {
            map = JacksonUtil.mapper.readValue(file, Map.class);
        } catch (IOException e) {
            logger.warn("read file error:" + e);
        }
        mapRules.put("tableRules", map == null ? new HashMap<>() : map);
        File fileForm = new File(getClass().getClassLoader().getResource("config/formRule.json").getFile());
        Map<String, Object> mapForm = null;
        try {
            mapForm = JacksonUtil.mapper.readValue(fileForm, Map.class);
        } catch (IOException e) {
            logger.warn("read file error:" + e);
        }
        mapRules.put("formRules", mapForm == null ? new HashMap<>() : mapForm);
    }

    public Map<String, Object> getTableRule(String key) {
        Map rule = (HashMap) ((Map) this.mapRules.get("tableRules")).get(key);
        Map ruleReturn = (Map) SerializationUtils.deserialize(SerializationUtils.serialize(rule));
        return ruleReturn;
    }

    public Map<String, Object> getFormRule(String key) {
        Map rule = (HashMap) ((Map) this.mapRules.get("formRules")).get(key);
        Map ruleReturn = (Map) SerializationUtils.deserialize(SerializationUtils.serialize(rule));
        return ruleReturn;
    }
}
