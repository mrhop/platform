package cn.hopever.platform.user.web.rest;

import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

/**
 * Created by Donghui Huo on 2016/9/6.
 */
@RestController
@RequestMapping(value = "/resources/principal", produces = "application/json")
public class PrincipalController {

    @PreAuthorize("hasRole('user')")
    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public CommonResult resource(Principal principal) {
        //此处应该获取用户的一些基本的信息，但是不包含其他信息
        CommonResult c = new CommonResult();
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        HashMap<String,Object> map = new HashMap<>();
        map.put("username",principal.getName());
        c.setResponseData(map);
        return c;
    }

    @PreAuthorize("hasRole('user') and #oauth2.hasScope('internal_client')")
    @RequestMapping(value = {"/check","/check/"},method = RequestMethod.GET)
    public CommonResult checkuserScope(Principal principal) {
        CommonResult c = new CommonResult();
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        HashMap<String,Object> map = new HashMap<>();
        map.put("available", true);
        c.setResponseData(map);
        return c;
    }
}
