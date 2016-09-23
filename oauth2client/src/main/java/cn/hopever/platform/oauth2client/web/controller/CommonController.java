package cn.hopever.platform.oauth2client.web.controller;

import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Donghui Huo on 2016/9/21.
 */
@Controller
@RequestMapping(produces = "text/html")
public class CommonController {

    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (commonMethods.validateUser((HttpServletRequest) request)) {
                //此处执行一个验证用户权限的操作，调用server的的资源，并进行用户在该场景下的合法性校验
                return "redirect:/index.html";
            } else {
                //需要重新指向到登陆页面 redirect
                return "redirect:/login.html";
            }
    }
}
