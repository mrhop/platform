package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.resources.ModuleRoleResource;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@ExposesResourceFor(ModuleRoleResource.class)
@RequestMapping(value = "/modulerole", produces = "application/json")
@CrossOrigin
public class ModuleRoleResourceController {
    Logger logger = LoggerFactory.getLogger(ModuleRoleResourceController.class);
    @Autowired
    private ModuleRoleTableService moduleRoleTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private ModuleRoleResourceAssembler moduleRoleResourceAssembler;
}
