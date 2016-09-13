package cn.hopever.platform.oauth2client.web.controller;

import cn.hopever.platform.oauth2client.config.Oauth2Properties;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Donghui Huo on 2016/9/6.
 */
//暂时不考虑refresh token
@RestController
@RequestMapping(value = "/oauth2client", produces = "application/json")
public class Oauth2ClientController {

    @Autowired
    private Oauth2Properties oauth2Properties;

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    private OAuth2RestOperations authorizationCodeRestTemplate;

    @Autowired
    private OAuth2RestOperations clientRestTemplate;

    @Value("${config.oauth2.principalURI}")
    private String principalURI;

    @RequestMapping(value = "/byauthorizationcode",method = RequestMethod.POST)
    public JsonNode byAuthorizationCode(@RequestBody JsonNode body) {
        JsonNode js=authorizationCodeRestTemplate.getForObject(body.get("resourceUrl").asText(), JsonNode.class);
        return js;
    }

    @RequestMapping(value = "/byclient",method = RequestMethod.POST)
    public JsonNode byClient(@RequestBody JsonNode body) {
        JsonNode js=clientRestTemplate.getForObject(body.get("resourceUrl").asText(), JsonNode.class);
        return js;
    }

    @RequestMapping(value = "/bypassword",method = RequestMethod.POST)
    public JsonNode byPassword(@RequestBody JsonNode body) {
        JsonNode js=getPasswordRestTemplate(body.get("username").asText(),body.get("password").asText()).getForObject(body.get("resourceUrl").asText(), JsonNode.class);
        return js;
    }


    //仅仅用于返回脚本，并执行，然后将accesstoken放置在cookie里面
    @RequestMapping(value = "/getaccesstokenbyimplicit")
    @ResponseBody
    public String getAccesstokenByimplicit() {
        return "<script>alert(123);</script>";
    }

    @RequestMapping(value = "/refreshtoken")
    @ResponseBody
    public String refreshToken(@RequestBody JsonNode body) {
        return "<script>alert(123);</script>";
    }


    private OAuth2RestOperations getPasswordRestTemplate(String username,String password){
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
