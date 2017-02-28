package cn.hopever.platform.cmsclient.web.controller;

import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.oauth2client.web.common.ExposedResourceBundleMessageSource;
import cn.hopever.platform.utils.json.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/21.
 */
@Controller
@RequestMapping(produces = "text/html")
public class CmsController {

    @Autowired
    private CommonMethods commonMethods;

    @Autowired
    private ExposedResourceBundleMessageSource commonResources;

    @Autowired
    private LocaleResolver localeResolver;


    @RequestMapping(value = {"filebrowser.html"}, method = RequestMethod.GET)
    public String filebrowserPage(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) throws Exception {
        Map messages = commonResources.getKeyValues("common/messages/index", localeResolver.resolveLocale(request));
        model.put("messagesStr", JacksonUtil.mapper.writeValueAsString(messages));
        model.put("messages", messages);
        return "filebrowser";
    }

}
