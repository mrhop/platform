package cn.hopever.platform.oauth2client.web.common;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Donghui Huo on 2016/11/7.
 */
@Component("messageSource")
public class ExposedResourceBundleMessageSource extends ResourceBundleMessageSource {


    private static final Resource[] NO_RESOURCES = {};

    private String[] basename = {"messages","common/messages/index","common/messages/login","common/messages/error"};

    private Charset encoding = Charset.forName("UTF-8");

    private int cacheSeconds = -1;
    private boolean fallbackToSystemLocale = true;

    private boolean alwaysUseMessageFormat = false;

    public ExposedResourceBundleMessageSource(){
        this.setBasenames(this.basename);
        if (this.encoding != null) {
            this.setDefaultEncoding(this.encoding.name());
        }
        this.setFallbackToSystemLocale(this.fallbackToSystemLocale);
        this.setCacheSeconds(this.cacheSeconds);
        this.setAlwaysUseMessageFormat(this.alwaysUseMessageFormat);
        this.setDefaultEncoding("utf-8");
    }

    public static final String WHOLE = "whole";
    private List<String> baseNames;
    private Map<String,Map> cachedData = new HashMap();

    public Set getKeys(String baseName, Locale locale) {
        ResourceBundle bundle = getResourceBundle(baseName, locale);
        return bundle.keySet();
    }

    public Map getKeyValues(String basename, Locale locale) {
        String cacheKey = basename + locale.getCountry();
        if (cachedData.containsKey(cacheKey)) {
            return cachedData.get(cacheKey);
        }
        ResourceBundle bundle = getResourceBundle(basename, locale);
        HashMap hashMap = new HashMap();
        for (String key : bundle.keySet()) {
            hashMap.put(key, this.getMessage(key,null,locale));
        }
        cachedData.put(cacheKey, hashMap);
        return hashMap;
    }

    public Map getKeyValues(Locale locale) {
        String cacheKey = WHOLE + locale.getCountry();
        if (cachedData.containsKey(cacheKey)) {
            return cachedData.get(cacheKey);
        }
        HashMap hashMap = new HashMap();
        for (String baseName : baseNames) {
            hashMap.putAll(getKeyValues(baseName, locale));
        }
        cachedData.put(cacheKey, hashMap);
        return hashMap;
    }

    public void setBasenames(String[] basenames) {
        baseNames = CollectionUtils.arrayToList(basenames);
        super.setBasenames(basenames);
    }
}
