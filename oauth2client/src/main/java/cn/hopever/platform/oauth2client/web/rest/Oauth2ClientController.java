package cn.hopever.platform.oauth2client.web.rest;

import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.config.Oauth2Properties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.oauth2client.web.common.ExposedResourceBundleMessageSource;
import cn.hopever.platform.oauth2client.web.common.LocaleMessageSource;
import cn.hopever.platform.utils.security.AesUtil;
import cn.hopever.platform.utils.security.DesECBUtil;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/6.
 */
//以cookie为准，并且cookie的值加密
//需要1.获取token 根据提供数据 获取token，并设置cookie（加密，用于多内部平台），session，用于client使用，并需要注意session的延期
//需要2.当判断失效时间以及baseoncode获取的token进行refresh
//需要3.需要client的get和post使用获取resource
//需要4.首次进入时，进入/，并根据cookie中提供的数据进行导向，如session有，则根据session中的来，如session无，则看cookie是否过期，如无过期则重新生成session，并按照session来
//统一的认证和单点的登陆考虑
//cookie的一致性和session的各自性
//不再使用session
@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin
public class Oauth2ClientController {

    @Autowired
    private Oauth2Properties oauth2Properties;

    @Autowired
    private CommonProperties commonProperties;

    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Autowired
    private ExposedResourceBundleMessageSource commonResources;

    @Resource
    private LocaleMessageSource localeMessageSource;

    @Autowired
    @Qualifier("authorizationCodeRestTemplate")
    private OAuth2RestOperations authorizationCodeRestTemplate;

    @Autowired
    @Qualifier("clientRestTemplate")
    private OAuth2RestOperations clientRestTemplate;

    @Autowired
    @Qualifier("passwordOAuth2ClientContext")
    private OAuth2ClientContext passwordOAuth2ClientContext;

    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/gettokenbycode", method = RequestMethod.GET)
    public CommonResult getTokenByCode(HttpServletRequest request, HttpServletResponse response) {
        CommonResult c = new CommonResult();
        try {
            OAuth2AccessToken oa = authorizationCodeRestTemplate.getAccessToken();
            Cookie cookie = new Cookie("accesstoken", DesECBUtil.encryptDES(oa.getValue(), oauth2Properties.getSecretKey()));
            //cookie.setPath(request.getContextPath());
            cookie.setMaxAge(oa.getExpiresIn());
            //设置domain，保证一键登陆的可行性--目前来看还不可设置，考虑localhost的重新指向来设置
            if (oauth2Properties.getDomainName() != null) {
                cookie.setDomain(oauth2Properties.getDomainName());
            }
            response.addCookie(cookie);
            c.setStatus(CommonResultStatus.SUCCESS.toString());
        } catch (Exception e) {
            c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            c.setMessage(e.getMessage());
        }
        return c;
    }

    @RequestMapping(value = "/initlogin", method = RequestMethod.GET)
    public CommonResult initLogin(HttpServletRequest request) {
        CommonResult c = new CommonResult();

        if (request.getSession().getAttribute("clientAccessToken") != null) {
            //说明已经进行过client的登录，否则进行登录
            HashMap<String, Object> rule = (HashMap) ((Map) commonProperties.getMapRules().get("formRules")).get("login");
            List<Map> list = (List<Map>) rule.get("structure");
            for (Map map : list) {
                if (map.get("label") != null && map.get("label") instanceof Map) {
                    map.put("label", localeMessageSource.getMessage(((Map) map.get("label")).get("key").toString(), request));
                }

                if (map.get("placeholder") != null && map.get("placeholder") instanceof Map) {
                    map.put("placeholder", localeMessageSource.getMessage(((Map) map.get("placeholder")).get("key").toString(), request));
                }

                if (map.get("validateRules") != null) {
                    for (Map mapValidate : (List<Map>) map.get("validateRules")) {
                        if (mapValidate.get("errorMsg") != null && mapValidate.get("errorMsg") instanceof Map) {
                            mapValidate.put("errorMsg", localeMessageSource.getMessage(((Map) mapValidate.get("errorMsg")).get("key").toString(), request));
                        }
                    }
                }
            }
            c.setResponseData(rule);
            c.setStatus(CommonResultStatus.SUCCESS.toString());
        } else {
            c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
        }
        return c;
    }


    @RequestMapping(value = "/gettokenbyclient", method = RequestMethod.GET)
    public CommonResult getTokenByClient(HttpServletRequest request) {
        CommonResult c = new CommonResult();
        if (request.getSession().getAttribute("clientAccessToken") != null) {
            //说明已经进行过client的登录，否则进行登录
            c.setStatus(CommonResultStatus.SUCCESS.toString());
        } else {
            OAuth2AccessToken oa = clientRestTemplate.getAccessToken();
            c.setStatus(CommonResultStatus.SUCCESS.toString());
            request.getSession().setAttribute("clientAccessToken", oa.getValue());
        }
        return c;
    }

    @RequestMapping(value = "/gettokenbypassword", method = RequestMethod.POST)
    public Object getTokenbyPassword(@RequestBody JsonNode body, HttpServletRequest request, HttpServletResponse response) {
        CommonResult c = new CommonResult();
        try {
            OAuth2AccessToken oa = getPasswordRestTemplate(body.get("data").get("username").asText(), body.get("data").get("password").asText()).getAccessToken();
            Cookie cookie = new Cookie("accesstoken", AesUtil.aesEncrypt(oa.getValue(), oauth2Properties.getSecretKey()));
            //cookie.setPath(request.getContextPath());
            //设置domain，保证一键登陆的可行性--目前来看还不可设置，考虑localhost的重新指向来设置
            if (oauth2Properties.getDomainName() != null) {
                cookie.setDomain(oauth2Properties.getDomainName());
            }
            cookie.setMaxAge(oa.getExpiresIn());
            //此处进行校验，并返回index
            if (commonMethods.validateUser(request, cookie)) {
                response.addCookie(cookie);
                //rest 里面如何sendredirect
                //必须使用前台ajax调用
                c.setStatus(CommonResultStatus.SUCCESS.toString());
                c.setMessage("to index");
                HashMap<String, Object> map = new HashMap<>();
                map.put("redirect", "index.html");
                c.setResponseData(map);
                //response.sendRedirect("/index.html");
                // return "redirect:/index.html";
            } else {
                c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
                c.setMessage("401,Authorization Error");
            }
        } catch (Exception e) {
            c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            c.setMessage(e.getMessage());
        }
        return c;
    }

    @RequestMapping(value = "/postresource", method = RequestMethod.POST)
    public CommonResult postResource(@RequestBody JsonNode body, HttpServletRequest request) throws Exception {
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/getresource", method = RequestMethod.GET)
    public CommonResult getResource(HttpServletRequest request) throws Exception {
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/leftmenu", method = RequestMethod.GET)
    public CommonResult getLeftmenu(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", oauth2Properties.getModuleList() + oauth2Properties.getClientID());
        return commonMethods.getResource(request);
    }


    private OAuth2RestOperations getPasswordRestTemplate(String username, String password) {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setClientId(oauth2Properties.getClientID());
        resource.setClientSecret(oauth2Properties.getClientSecret());
        resource.setAccessTokenUri(oauth2Properties.getAccessTokenUri());
        resource.setUsername(username);
        resource.setPassword(password);
        resource.setScope(oauth2Properties.getClientScopes());
        return new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
    }

}
