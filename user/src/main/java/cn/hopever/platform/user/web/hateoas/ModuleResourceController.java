package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.service.ClientTableService;
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
@ExposesResourceFor(ClientResource.class)
@RequestMapping(value = "/module", produces = "application/json")
@CrossOrigin
public class ModuleResourceController {
    Logger logger = LoggerFactory.getLogger(ModuleResourceController.class);
    @Autowired
    private ClientTableService clientTableService;

    @Autowired
    EntityLinks entityLinks;

    @Autowired
    private ClientResourceAssembler clientResourceAssembler;
}
