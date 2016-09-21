package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.resources.ClientTableResource;
import cn.hopever.platform.user.service.ClientTableService;
import cn.hopever.platform.utils.web.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@ExposesResourceFor(ClientTableResource.class)
@RequestMapping(value = "/client", produces = "application/json")
@CrossOrigin
public class ClientTableController {
    Logger logger = LoggerFactory.getLogger(ClientTableController.class);
    @Autowired
    private ClientTableService clientTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private ClientTableAssembler clientTableAssembler;


    //注册内部client，角色为 超级用户
    @PreAuthorize("hasRole('super_admin') and  #oauth2.hasScope('super_admin_client')")
    @RequestMapping(value = "/internal/register", method = RequestMethod.POST)
    public CommonResult createClientTable(@RequestBody ClientTableResource resource) {
       return null;
    }

    //注册普通外部client，无限制，但是client的可用性，需要验证完手机号后才可使用
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult createClientTableOuter(@RequestBody ClientTableResource resource) {
        return null;
    }
    //提供一个验证外部client的流程

    //获取角色信息，使用client方式登陆后获取
    @PreAuthorize("#oauth2.hasScope('internal_client')  or #oauth2.hasScope('outer_client')")
    public ClientTableResource get(Principal principal) {
        return null;
    }
}
