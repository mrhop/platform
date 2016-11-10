package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ClientRoleTable;
import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.ClientRoleResource;
import cn.hopever.platform.user.resources.ModuleResource;
import cn.hopever.platform.user.resources.ModuleRoleResource;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class ClientResourceAssembler extends ResourceAssemblerSupport<ClientTable, ClientResource> {

    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public ClientResourceAssembler() {
        super(ClientResourceController.class, ClientResource.class);
        modelMapper = new ModelMapper();
        PropertyMap<ClientTable, ClientResource> map = new PropertyMap<ClientTable, ClientResource>() {
            protected void configure() {
                skip().setAuthorities(null);
                skip().setModules(null);
                skip().setModuleRoles(null);
                skip().setUsers(null);
            }
        };
        modelMapper.addMappings(map);
    }

    @Override
    public ClientResource toResource(ClientTable clientTable) {
        ClientResource resource = createResource(clientTable);
        //关联其他资源
        if (clientTable.getAuthoritiesBasic() != null) {
            ArrayList<ClientRoleResource> sCrr = new ArrayList<>();
            for (ClientRoleTable crt : clientTable.getAuthoritiesBasic()) {
                ClientRoleResource crr = new ClientRoleResource();
                crr.setInternalId(crt.getId());
                crr.setAuthority(crt.getAuthority());
                sCrr.add(crr);
            }
            resource.setAuthorities(sCrr);
        }
        if (clientTable.getModules() != null) {
            ArrayList<ModuleResource> sMr = new ArrayList<>();
            for (ModuleTable mt : clientTable.getModules()) {
                ModuleResource mr = new ModuleResource();
                mr.setInternalId(mt.getId());
                mr.setModuleName(mt.getModuleName());
                sMr.add(mr);
            }
            resource.setModules(sMr);
        }
        if (clientTable.getModuleRoles() != null) {
            ArrayList<ModuleRoleResource> sMr = new ArrayList<>();
            for (ModuleRoleTable mt : clientTable.getModuleRoles()) {
                ModuleRoleResource mr = new ModuleRoleResource();
                mr.setInternalId(mt.getId());
                mr.setName(mt.getName());
                sMr.add(mr);
            }
            resource.setModuleRoles(sMr);
        }
        return resource;
    }

    public List<ClientResource> toResourcesCustomized(Iterable<ClientTable> clientTables) {
        List<ClientResource> returnList = new ArrayList<>();
        for (ClientTable ct : clientTables) {
            returnList.add(this.createResource(ct));
        }
        return returnList;
    }

    private ClientResource createResource(ClientTable clientTable) {
        ClientResource clientResource = null;
        if (clientTable != null) {
            clientResource = modelMapper.map(clientTable, ClientResource.class);
            clientResource.setInternalId(clientTable.getId());
            clientResource.add(entityLinks.linkFor(ClientResource.class).slash(clientTable.getId()).withSelfRel());
        }
        return clientResource;
    }
}
