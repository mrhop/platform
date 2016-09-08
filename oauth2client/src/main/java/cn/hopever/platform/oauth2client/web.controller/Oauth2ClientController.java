package cn.hopever.platform.oauth2client.web.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghui Huo on 2016/9/6.
 */
@RestController
@RequestMapping(value = "/login", produces = "application/json")
public class Oauth2ClientController {
    @Autowired
    private OAuth2RestOperations authorizationCodeRestTemplate;

    @Autowired
    private OAuth2RestOperations implicitRestTemplate;

    @Value("${config.oauth2.principalURI}")
    private String principalURI;

    @RequestMapping("")
    public JsonNode getPrincipal() {
        JsonNode js=authorizationCodeRestTemplate.getForObject(principalURI, JsonNode.class);
        return js;
    }
}
