package cn.hopever.platform.user.web.rest;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.service.UserTableService;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UserTableService userTableService;

    @PreAuthorize("#oauth2.hasScope('internal_client') or #oauth2.hasScope('client')")
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public CommonResult resource(Principal principal) {
        //此处应该获取用户的一些基本的信息，但是不包含其他信息
        CommonResult c = new CommonResult();
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", principal.getName());
        c.setResponseData(map);
        return c;
    }

    @PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = {"/check/{clientId}"}, method = RequestMethod.GET)
    public CommonResult checkuserScope(Principal principal, @PathVariable String clientId) {
        //首先获取用户的角色，然后判断client，如果client正确，则返回，如果client不正确，则看用户是否是superadmin 或者该用户是否和该client有关系
        CommonResult c = new CommonResult();
        UserTable ut = userTableService.getUserByUsername(principal.getName());
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        HashMap<String, Object> map = new HashMap<>();
        map.put("available", false);
        map.put("userphoto",ut.getPhoto());
        //如果是super_admin
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        if ("ROLE_super_admin".equals(authority)) {
            map.put("available", true);
        }else{
            if(ut.getClients()!=null){
                for(ClientTable ct:ut.getClients()){
                    if(ct.getClientId().equals(clientId)){
                        map.put("available", true);
                        break;
                    }
                }
            }
        }
        //else if(){
        //执行clientId与user包含的client进行比对，如果包含则返回true
        //}
        c.setResponseData(map);
        return c;
    }
}
