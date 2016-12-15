package cn.hopever.platform.oauth2client.web.common;

import cn.hopever.platform.oauth2client.config.Oauth2Properties;
import cn.hopever.platform.utils.security.AesUtil;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import cn.hopever.platform.utils.web.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/22.
 */
@Component
public class CommonMethods {

    Logger logger = LoggerFactory.getLogger(CommonMethods.class);

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private Oauth2Properties oauth2Properties;

    @SuppressWarnings("unchecked")
    public CommonResult getResource(HttpServletRequest request) throws Exception {
        Object accesstoken = request.getSession().getAttribute("accesstoken");
        if (validateUser(request)) {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Authorization", "Bearer " + ((Map<String, Object>) accesstoken).get("accesstoken").toString());
            headers.add("Content-Type", "application/json;charset=UTF-8");
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<?> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<Object> re = restTemplate.exchange(request.getAttribute("resourceUrl").toString(), HttpMethod.GET, httpEntity, Object.class);
            CommonResult cr = new CommonResult();
            HashMap<String, Object> responseData = new HashMap<>();
            responseData.put("data", re.getBody());
            cr.setStatus(CommonResultStatus.SUCCESS.toString());
            cr.setMessage("success");
            cr.setResponseData(responseData);
            return cr;
        } else {
            CommonResult cr = new CommonResult();
            cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            cr.setMessage("401,Authorization Error");
            return cr;
        }
    }

    @SuppressWarnings("unchecked")
    public CommonResult postResource(Object body, HttpServletRequest request) throws Exception {
        Object accesstoken = request.getSession().getAttribute("accesstoken");
        if (validateUser(request)) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + ((Map<String, Object>) accesstoken).get("accesstoken").toString());
            headers.add("Content-Type", "application/json;charset=UTF-8");
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            HttpEntity<Object> httpEntity = new HttpEntity<>(body, headers);
            ResponseEntity<Object> re = restTemplate.exchange(request.getAttribute("resourceUrl").toString(), HttpMethod.POST, httpEntity, Object.class);
            CommonResult cr = new CommonResult();
            HashMap<String, Object> responseData = new HashMap<>();
            responseData.put("data", re.getBody());
            cr.setStatus(CommonResultStatus.SUCCESS.toString());
            cr.setMessage("success");
            cr.setResponseData(responseData);
            return cr;
        } else {
            CommonResult cr = new CommonResult();
            cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            cr.setMessage("401,Authorization Error");
            return cr;
        }
    }

    @SuppressWarnings("unchecked")
    public CommonResult postFile(HttpServletRequest request, MultipartFile[] files) throws Exception {
        Object accesstoken = request.getSession().getAttribute("accesstoken");
        if (validateUser(request)) {
            LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            try {
                for (MultipartFile file : files) {
                    String[] fileName = file.getOriginalFilename().split("\\.");
                    String filePrefix = new Date().getTime() + "" + (int) (Math.random() * 1000);
                    String fileSuffix = fileName[fileName.length - 1];
                    File fileTmp = File.createTempFile(filePrefix, "." + fileSuffix);
                    file.transferTo(fileTmp);
                    map.add("files", new FileSystemResource(fileTmp));
                }
                map.add("filePath", request.getAttribute("filePath"));
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);
                headers.add("Authorization", "Bearer " + ((Map<String, Object>) accesstoken).get("accesstoken").toString());
                HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
                ResponseEntity<Object> re = restTemplate.exchange(request.getAttribute("resourceUrl").toString(), HttpMethod.POST, requestEntity, Object.class);
                CommonResult cr = new CommonResult();
                HashMap<String, Object> responseData = new HashMap<>();
                responseData.put("data", re.getBody());
                cr.setStatus(CommonResultStatus.SUCCESS.toString());
                cr.setMessage("success");
                cr.setResponseData(responseData);
                return cr;
            } catch (IOException e) {
                logger.error("系统错误", e);
                CommonResult cr = new CommonResult();
                cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
                cr.setMessage("系统错误");
                return cr;
            }
        } else {
            CommonResult cr = new CommonResult();
            cr.setStatus(CommonResultStatus.SERVERFAILURE.toString());
            cr.setMessage("401,Authorization Error");
            return cr;
        }
    }

    public boolean validateUser(HttpServletRequest request) throws Exception {
        Cookie c = CookieUtil.getCookieByName("accesstoken", request.getCookies());
        return validateUser(request, c);
    }

    @SuppressWarnings("unchecked")
    public boolean validateUser(HttpServletRequest request, Cookie cookie) throws Exception {
        if (cookie != null) {
            Object accesstoken = request.getSession().getAttribute("accesstoken");
            if (accesstoken == null) {
                //do validate
                return internalValidate(request, cookie);
            } else {
                String sessionAccesstoken = ((Map<String, Object>) accesstoken).get("accesstoken").toString();
                boolean available = (boolean) ((Map<String, Object>) accesstoken).get("available");
                if (AesUtil.aesDecrypt(cookie.getValue(), oauth2Properties.getSecretKey()).equals(sessionAccesstoken)) {
                    return available;
                } else {
                    //do validate
                    return internalValidate(request, cookie);
                }
            }
        } else {
            return false;
        }
    }

    private boolean internalValidate(HttpServletRequest request, Cookie cookie) throws Exception {
        String decryptAccesstoken = AesUtil.aesDecrypt(cookie.getValue(), oauth2Properties.getSecretKey());
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", "Bearer " + decryptAccesstoken);
        headers.add("Content-Type", "application/json;charset=UTF-8");
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<CommonResult> re = restTemplate.exchange(oauth2Properties.getValidateUserUri() + oauth2Properties.getClientID(), HttpMethod.GET, httpEntity, CommonResult.class);
        CommonResult cr = re.getBody();
        Map<String, Object> map = cr.getResponseData();
        map.put("accesstoken", decryptAccesstoken);
        request.getSession().setAttribute("accesstoken", map);
        return (boolean) map.get("available");
    }
}
