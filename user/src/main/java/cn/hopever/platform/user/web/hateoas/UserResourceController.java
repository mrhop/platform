package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.resources.UserResource;
import cn.hopever.platform.user.service.UserTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@ExposesResourceFor(UserResource.class)
@RequestMapping(value = "/user", produces = "application/json")
@CrossOrigin
public class UserResourceController {
    Logger logger = LoggerFactory.getLogger(UserResourceController.class);
    @Autowired
    private UserTableService userTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private UserResourceAssembler userTableAssembler;


    //下午把用户功能实现了，同时提供一些样例用户，需要加一个字段 create_user!!

    //personal个人信息，获取个人的信息，以供修改，个人无法删除自身账户
    @PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping({"/",""})
    public UserResource get(Principal principal) {
        UserResource ur = userTableAssembler.toResource(userTableService.getUserByUsername(principal.getName()));
        ur.removeLinks();
        ur.add(linkTo(UserResourceController.class).withSelfRel());
        return ur;
    }

    //管理员获取列表，获取其可控制的用户列表，包含普通用户，以及由其创建的普通admin【针对普通admin而言】
    //针对super_admin,可以控制一切,把自身的user过滤掉
    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping("/list")
    public Resources<UserResource> list(Principal principal) {
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        List<UserResource> list = new ArrayList<>();
        if("ROLE_super_admin".equals(authority)){
            list = userTableAssembler.toResourcesCustomized(userTableService.getListWithOutSelf(principal.getName()));
        }else{
            list = userTableAssembler.toResourcesCustomized(userTableService.getSubList(principal.getName()));
        }
        Resources<UserResource> wrapped = new Resources<UserResource>(list, linkTo(UserResourceController.class).slash("/list")
                .withSelfRel());
        return wrapped;
    }

    //管理员获取个人信息【为更新做准备，获取的同时获取其可指定的client作为备选】
    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping("/{id}")
    public UserResource get(@PathVariable Long id) {
        return null;
    }

    //更新自身信息，电话，邮箱之类的【邮箱和电话保证唯一】
    @PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/update/personal", method = {RequestMethod.POST})
    public UserResource updatePersonal(Principal principal, @RequestBody UserResource userResource) {
        //需要比对name和id一致性
        return null;
    }

    //管理员更新个人信息--更新权限之类的
    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update/user", method = {RequestMethod.POST})
    public UserResource updateUser(@RequestBody UserResource userResource) {
        return null;
    }

    //管理员添加用户，在客户端为其指定client，添加到自身的client下面，作为普通用户存在,同时变更module-role，并给其指定role
    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/add/user", method = {RequestMethod.POST})
    public UserResource addUser(@RequestBody UserResource userResource) {
        return null;
    }
    //不开放注册用户
    //删除用户,注意不可删除自身以及其创建人
    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/delete/user", method = {RequestMethod.GET})
    public UserResource deleteUser(@PathVariable Long id) {
        return null;
    }
}
