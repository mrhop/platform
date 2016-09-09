package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.resources.UserTableResource;
import cn.hopever.platform.user.service.UserTableService;
import cn.hopever.platform.utils.tools.BeanUtils;
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
@ExposesResourceFor(UserTableResource.class)
@RequestMapping(value = "/user", produces = "application/json")
@CrossOrigin
public class UserTableController {
    Logger logger = LoggerFactory.getLogger(UserTableController.class);
    @Autowired
    private UserTableService userTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private UserTableAssembler userTableAssembler;


    //client 应该是内部应用才可以使用注册
    //外部client 应该只能使用用户的一些基本信息，仅限于用户部分
    //考虑内部scope和外部scope的que
    @PreAuthorize("#oauth2.hasScope('internal_client')")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult createUserTable(@RequestBody UserTableResource resource,Principal principal) {
        //post json，
        //下一步里面需要根据client id 给予基本的role， user and client_id 相关的基本操作role
        //根据client给用户填上基本的role
        //
        UserTable userTable = new UserTable();
        BeanUtils.copyNotNullProperties(resource, userTable);
        try {
            userTableService.saveOne(userTable);
            return new CommonResult(true, "create success");
        } catch (Exception e) {
            logger.error("createUserTable error", e);
            return new CommonResult(false, "create failure:" + e.getMessage());
        }
    }


    //用户登录授权完成后获取用户的信息,每一个用户都有一个role 标明为user，标明是登录用户，才可获取基本信息
    @PreAuthorize("hasRole('user')")
    @RequestMapping("/user")
    public UserTableResource get(Principal principal) {

        return null;
    }


}
