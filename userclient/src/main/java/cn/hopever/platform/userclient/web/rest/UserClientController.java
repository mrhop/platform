package cn.hopever.platform.userclient.web.rest;

import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.userclient.config.BaseConfig;
import cn.hopever.platform.utils.web.CommonResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin
public class UserClientController {
    @Autowired
    private BaseConfig baseConfig;

    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/user/personalinfo", method = {RequestMethod.GET})
    public CommonResult getPersonalInfo(HttpServletRequest request) throws Exception{
        request.setAttribute("resourceUrl",baseConfig.getPersonalinfo());
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/user/list", method = {RequestMethod.GET})
    public CommonResult getUserList(HttpServletRequest request) throws Exception{
        request.setAttribute("resourceUrl",baseConfig.getUserlist());
        return commonMethods.getResource(request);
    }
}
