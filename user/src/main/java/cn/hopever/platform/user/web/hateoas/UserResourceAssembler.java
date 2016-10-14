package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.ModuleRoleResource;
import cn.hopever.platform.user.resources.RoleResource;
import cn.hopever.platform.user.resources.UserResource;
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
public class UserResourceAssembler extends ResourceAssemblerSupport<UserTable, UserResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public UserResourceAssembler() {
        super(UserResourceController.class, UserResource.class);
    }

    @Override
    public UserResource toResource(UserTable userTable) {

        UserResource resource = createResource(userTable);
        // … do further mapping
        //关联其他资源
        if (userTable.getClients() != null) {
            Set<ClientResource> setCr = new LinkedHashSet<>();
            for (ClientTable ct : userTable.getClients()) {
                ClientResource clientResource = new ClientResource();
                clientResource.setInternalId(ct.getId());
                clientResource.setClientId(ct.getClientId());
                setCr.add(clientResource);
            }
            resource.setClients(setCr);
        }

        if (userTable.getAuthorities() != null) {
            Set<RoleResource> setRr = new LinkedHashSet<>();
            for (RoleTable rt : userTable.getAuthorities()) {
                RoleResource roleResource = new RoleResource();
                roleResource.setInternalId(rt.getId());
                roleResource.setAuthority(rt.getAuthority());
                setRr.add(roleResource);
            }
            resource.setAuthorities(setRr);
        }

        if (userTable.getModulesAuthorities() != null) {
            Set<ModuleRoleResource> setMrr = new LinkedHashSet<>();
            for (ModuleRoleTable mrt : userTable.getModulesAuthorities()) {
                ModuleRoleResource moduleRoleResource = new ModuleRoleResource();
                moduleRoleResource.setInternalId(mrt.getId());
                moduleRoleResource.setAuthority(mrt.getAuthority());
                setMrr.add(moduleRoleResource);
            }
            resource.setModulesAuthorities(setMrr);
        }
        return resource;
    }


    public Set<UserResource> toResources(Set<UserTable> userTables) {
        Set<UserResource> returnSet = new LinkedHashSet<>();
        for (UserTable ut : userTables) {
            returnSet.add(this.createResource(ut));
        }
        return returnSet;
    }

    private UserResource createResource(UserTable userTable) {
        UserResource userResource = null;
        if (userTable != null) {
            userResource = modelMapper.map(userTable, UserResource.class);
            userResource.setInternalId(userTable.getId());
            userResource.add(entityLinks.linkFor(UserResource.class).slash(userTable.getId()).withSelfRel());
        }
        return userResource;
    }

}
