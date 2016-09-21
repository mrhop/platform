package cn.hopever.platform.oauth2client.web.controller;

import cn.hopever.platform.utils.web.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Donghui Huo on 2016/9/21.
 */
@Controller
@RequestMapping(produces = "text/html")
public class CommonController {

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
            Cookie c = CookieUtil.getCookieByName("accesstoken", request.getCookies());
            if (c != null) {
                return "redirect:/index.html";
            } else {
                //需要重新指向到登陆页面 redirect
                return "redirect:/login.html";
            }
    }
}
