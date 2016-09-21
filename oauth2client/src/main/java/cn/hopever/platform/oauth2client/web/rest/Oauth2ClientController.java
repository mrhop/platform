package cn.hopever.platform.oauth2client.web.rest;

import cn.hopever.platform.oauth2client.config.Oauth2Properties;
import cn.hopever.platform.utils.security.AesUtil;
import cn.hopever.platform.utils.security.DesECBUtil;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import cn.hopever.platform.utils.web.CookieUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private OAuth2ClientContext oauth2ClientContext;

    @Autowired
    @Qualifier("authorizationCodeRestTemplate")
    private OAuth2RestOperations authorizationCodeRestTemplate;

    @Autowired
    @Qualifier("clientRestTemplate")
    private OAuth2RestOperations clientRestTemplate;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping(value = "/gettokenbycode", method = RequestMethod.GET)
    public CommonResult getTokenByCode(HttpServletResponse response) {
        CommonResult c = new CommonResult();
        try {
            OAuth2AccessToken oa = authorizationCodeRestTemplate.getAccessToken();
            Cookie cookie = new Cookie("accesstoken", DesECBUtil.encryptDES(oa.getValue(), oauth2Properties.getSecretKey()));
            cookie.setPath("/");
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

    @RequestMapping(value = "/gettokenbyclient", method = RequestMethod.GET)
    public CommonResult getTokenByClient() {
        CommonResult c = new CommonResult();
        try {
            OAuth2AccessToken oa = clientRestTemplate.getAccessToken();
            c.setStatus(CommonResultStatus.SUCCESS.toString());
        } catch (Exception e) {
            c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            c.setMessage(e.getMessage());
        }
        return c;
    }

    @RequestMapping(value = "/gettokenbypassword", method = RequestMethod.POST)
    public CommonResult getTokenbyPassword(@RequestBody JsonNode body, HttpServletResponse response) {
        CommonResult c = new CommonResult();
        try {
            OAuth2AccessToken oa = getPasswordRestTemplate(body.get("data").get("username").asText(), body.get("data").get("password").asText()).getAccessToken();
            Cookie cookie = new Cookie("accesstoken", AesUtil.aesEncrypt(oa.getValue(), oauth2Properties.getSecretKey()));
            cookie.setPath("/");
            //设置domain，保证一键登陆的可行性--目前来看还不可设置，考虑localhost的重新指向来设置
            if (oauth2Properties.getDomainName() != null) {
                cookie.setDomain(oauth2Properties.getDomainName());
            }
            cookie.setMaxAge(oa.getExpiresIn());
            response.addCookie(cookie);
            c.setStatus(CommonResultStatus.SUCCESS.toString());
        } catch (Exception e) {
            c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            c.setMessage(e.getMessage());
        }
        return c;
    }

    @RequestMapping(value = "/postresource", method = RequestMethod.POST)
    public CommonResult postResource(@RequestBody JsonNode body, HttpServletRequest request) {
        Cookie c =  CookieUtil.getCookieByName("accesstoken",request.getCookies());
        if(c!=null){
            CommonResult cr =null;
            try{
                MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
                headers.add("Authorization", "Bearer " + AesUtil.aesDecrypt(c.getValue(), oauth2Properties.getSecretKey()));
                headers.add("Content-Type", "application/json;charset=UTF-8");
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpEntity<JsonNode> httpEntity = new HttpEntity<JsonNode>(body, headers);
                ResponseEntity<CommonResult> re = restTemplate.exchange(request.getHeader("resourceUrl"), HttpMethod.POST, httpEntity, CommonResult.class);
                return re.getBody();
            }catch(Exception e){
                cr = new CommonResult();
                cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
                cr.setMessage(e.getMessage());
            }
            return cr;
        }else{
                //需要重新指向到登陆页面 redirect
            return null;
        }
    }

    @RequestMapping(value = "/getresource", method = RequestMethod.GET)
    public CommonResult getResource(HttpServletRequest request) {
        Cookie c =  CookieUtil.getCookieByName("accesstoken",request.getCookies());
        if(c!=null){
            CommonResult cr =null;
            try{
                MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
                headers.add("Authorization", "Bearer " + DesECBUtil.decryptDES(c.getValue(), oauth2Properties.getSecretKey()));
                headers.add("Content-Type", "application/json;charset=UTF-8");
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpEntity<?> httpEntity = new HttpEntity<Object>( headers);
                ResponseEntity<CommonResult> re = restTemplate.exchange(request.getHeader("resourceUrl"), HttpMethod.GET, httpEntity, CommonResult.class);
                return re.getBody();
            }catch(Exception e){
                cr = new CommonResult();
                cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
                cr.setMessage(e.getMessage());
            }
            return cr;
        }else{
            //需要重新指向到登陆页面 redirect
            return null;
        }
    }



    private OAuth2RestOperations getPasswordRestTemplate(String username, String password) {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setClientId(oauth2Properties.getClientID());
        resource.setClientSecret(oauth2Properties.getClientSecret());
        resource.setAccessTokenUri(oauth2Properties.getAccessTokenUri());
        resource.setUsername(username);
        resource.setPassword(password);
        resource.setScope(oauth2Properties.getClientScopes());
        return new OAuth2RestTemplate(resource, oauth2ClientContext);
    }

}
