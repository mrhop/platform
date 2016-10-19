package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.resources.RoleResource;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class RoleResourceAssembler extends ResourceAssemblerSupport<RoleTable, RoleResource> {

    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public RoleResourceAssembler() {
        super(RoleResourceController.class, RoleResource.class);
        modelMapper = new ModelMapper();
        PropertyMap<RoleTable, RoleResource> map = new PropertyMap<RoleTable, RoleResource>() {
            protected void configure() {
                skip().setUsers(null);
            }
        };
        modelMapper.addMappings(map);
    }


    @Override
    public RoleResource toResource(RoleTable roleTable) {
        RoleResource resource = createResource(roleTable);
        //关联其他资源,暂时不关联其他资源
        return resource;
    }

    private RoleResource createResource(RoleTable roleTable) {
        RoleResource roleResource = null;
        if (roleTable != null) {
            roleResource = modelMapper.map(roleTable,RoleResource.class);
            roleResource.setInternalId(roleTable.getId());
            roleResource.add(entityLinks.linkFor(RoleResource.class).slash(roleTable.getId()).withSelfRel());
        }
        return roleResource;
    }
}
