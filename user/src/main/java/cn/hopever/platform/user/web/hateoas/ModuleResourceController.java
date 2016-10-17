package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.resources.ModuleResource;
import cn.hopever.platform.user.service.ModuleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@ExposesResourceFor(ModuleResource.class)
@RequestMapping(value = "/module", produces = "application/json")
@CrossOrigin
public class ModuleResourceController {
    Logger logger = LoggerFactory.getLogger(ModuleResourceController.class);
    @Autowired
    private ModuleTableService moduleTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private ModuleResourceAssembler moduleResourceAssembler;

    @PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/list/{clientId}", method = RequestMethod.GET)
    public Resources<ModuleResource> getList(Principal principal, @PathVariable String clientId) {
        //首先获取到role，然后获取到clientId相关的
        //user client和其他client不一样，user client使用role表，而其他client使用module-role，然后关联module
        //先做user_client的
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (authorities != null && authorities.size() > 0) {
            Iterable<ModuleTable> moduleTables = null;
            String authority = authorities.iterator().next().getAuthority();
            moduleTables = moduleTableService.getListByClientAndAuthorityAndUser(clientId, authority, principal.getName());
            //接下来做resource的转换工作，然后测试获取，并进行装配到html中，然后进行每个页面的实现

        }
        return null;
    }
}
