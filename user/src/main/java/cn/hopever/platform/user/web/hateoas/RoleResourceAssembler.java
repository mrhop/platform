package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.RoleResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class RoleResourceAssembler extends ResourceAssemblerSupport<RoleTable, RoleResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public RoleResourceAssembler() {
        super(RoleResourceController.class, RoleResource.class);
    }

    @Override
    public RoleResource toResource(RoleTable roleTable) {
        RoleResource resource = createResource(roleTable);
        //关联其他资源,暂时不关联其他资源
        return resource;
    }

    public Set<RoleResource> toResources(Set<RoleTable> roleTables) {
        Set<RoleResource> returnSet = new LinkedHashSet<>();
        for (RoleTable rt : roleTables) {
            returnSet.add(this.createResource(rt));
        }
        return returnSet;
    }

    private RoleResource createResource(RoleTable roleTable) {
        RoleResource roleResource = null;
        if (roleTable != null) {
            roleResource = modelMapper.map(roleTable, RoleResource.class);
            roleResource.setInternalId(roleTable.getId());
            roleResource.add(entityLinks.linkFor(ClientResource.class).slash(roleTable.getId()).withSelfRel());
        }
        return roleResource;
    }
}
