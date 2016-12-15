package cn.hopever.platform.oauth2client.web.controller;

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
public class CommonController {

    @Autowired
    private CommonMethods commonMethods;

    @Autowired
    private ExposedResourceBundleMessageSource commonResources;

    @Autowired
    private LocaleResolver localeResolver;


    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) throws Exception {
        if (commonMethods.validateUser((HttpServletRequest) request)) {
                //此处执行一个验证用户权限的操作，调用server的的资源，并进行用户在该场景下的合法性校验
                return indexPage(request,response,model);
            } else {
                //需要重新指向到登陆页面 redirect
            return loginPage(request,response,model);
            }
    }

    @RequestMapping(value = {"index.html"}, method = RequestMethod.GET)
    public String indexPage(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) throws Exception {
        Map messages = commonResources.getKeyValues("common/messages/index",localeResolver.resolveLocale(request));

        messages.put("user.photo",((Map)request.getSession().getAttribute("accesstoken")).get("userphoto"));
        model.put("messagesStr",JacksonUtil.mapper.writeValueAsString(messages));
        model.put("messages",messages);
        return "index";
    }
    @RequestMapping(value = {"login.html"}, method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) throws Exception {
        Map messages = commonResources.getKeyValues("common/messages/login",localeResolver.resolveLocale(request));
        model.put("messagesStr",JacksonUtil.mapper.writeValueAsString(messages));
        model.put("messages",messages);
        return "login";
    }

    @RequestMapping(value = {"error/404.html"}, method = RequestMethod.GET)
    public String error404Page(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) throws Exception {
        Map messages = commonResources.getKeyValues("common/messages/error",localeResolver.resolveLocale(request));
        model.put("messagesStr", JacksonUtil.mapper.writeValueAsString(messages));
        model.put("messages", messages);
        return "error/404";
    }

}
