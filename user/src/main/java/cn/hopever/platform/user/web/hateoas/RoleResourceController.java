package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.RoleResource;
import cn.hopever.platform.user.service.RoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@ExposesResourceFor(ClientResource.class)
@RequestMapping(value = "/role", produces = "application/json")
@CrossOrigin
public class RoleResourceController {
    Logger logger = LoggerFactory.getLogger(RoleResourceController.class);
    @Autowired
    private RoleTableService roleTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private RoleResourceAssembler roleResourceAssembler;

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('super_admin')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Resources<RoleResource>  getList(){
        Resources<RoleResource> wrapped = new Resources<RoleResource>(roleResourceAssembler.toResources(roleTableService.getList()), linkTo(RoleResourceController.class)
                .withSelfRel());
        return wrapped;
    }
}
