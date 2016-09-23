package cn.hopever.platform.oauth2client.web.common;

import cn.hopever.platform.oauth2client.config.Oauth2Properties;
import cn.hopever.platform.utils.security.AesUtil;
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
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/22.
 */
@Component
public class CommonMethods {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private Oauth2Properties oauth2Properties;

    public CommonResult getResource(HttpServletRequest request) throws Exception {
        Object accesstoken = ((HttpServletRequest) request).getSession().getAttribute("accesstoken");
        if (validateUser(request)) {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Authorization", "Bearer " + ((Map<String, Object>) accesstoken).get("accesstoken").toString());
            headers.add("Content-Type", "application/json;charset=UTF-8");
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
            ResponseEntity<CommonResult> re = restTemplate.exchange(request.getHeader("resourceUrl"), HttpMethod.GET, httpEntity, CommonResult.class);
            return re.getBody();
        } else {
            CommonResult cr = new CommonResult();
            cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            cr.setMessage("401,Authorization Error");
            return cr;
        }
    }

    public CommonResult postResource(JsonNode body, HttpServletRequest request) throws Exception {
        Object accesstoken = ((HttpServletRequest) request).getSession().getAttribute("accesstoken");
        if (validateUser(request)) {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Authorization", "Bearer " + ((Map<String, Object>) accesstoken).get("accesstoken").toString());
            headers.add("Content-Type", "application/json;charset=UTF-8");
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<JsonNode> httpEntity = new HttpEntity<JsonNode>(body, headers);
            ResponseEntity<CommonResult> re = restTemplate.exchange(request.getHeader("resourceUrl"), HttpMethod.POST, httpEntity, CommonResult.class);
            return re.getBody();
        } else {
            CommonResult cr = new CommonResult();
            cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            cr.setMessage("401,Authorization Error");
            return cr;
        }
    }

    public boolean validateUser(HttpServletRequest request) throws Exception {
        Cookie c = CookieUtil.getCookieByName("accesstoken", request.getCookies());
        return validateUser(request,c);
    }

    public boolean validateUser(HttpServletRequest request,Cookie cookie) throws Exception {
        if (cookie != null) {
            Object accesstoken = ((HttpServletRequest) request).getSession().getAttribute("accesstoken");
            if (accesstoken == null) {
                //do validate
                return internalValidate(request,cookie);
            } else {
                String sessionAccesstoken = ((Map<String, Object>) accesstoken).get("accesstoken").toString();
                boolean available = (boolean) ((Map<String, Object>) accesstoken).get("available");
                if (AesUtil.aesDecrypt(cookie.getValue(), oauth2Properties.getSecretKey()).equals(sessionAccesstoken)) {
                    return available;
                } else {
                    //do validate
                    return internalValidate(request,cookie);
                }
            }
        } else {
            return false;
        }
    }

    private boolean internalValidate(HttpServletRequest request,Cookie cookie) throws Exception {
        String decryptAccesstoken = AesUtil.aesDecrypt(cookie.getValue(), oauth2Properties.getSecretKey());
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", "Bearer " + decryptAccesstoken);
        headers.add("Content-Type", "application/json;charset=UTF-8");
        HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
        ResponseEntity<CommonResult> re = restTemplate.exchange(oauth2Properties.getValidateUserUri(), HttpMethod.GET, httpEntity, CommonResult.class);
        CommonResult cr = re.getBody();
        Map<String, Object> map = cr.getResponseData();
        map.put("accesstoken", decryptAccesstoken);
        ((HttpServletRequest) request).getSession().setAttribute("accesstoken", map);
        return (boolean) map.get("available");
    }
}
