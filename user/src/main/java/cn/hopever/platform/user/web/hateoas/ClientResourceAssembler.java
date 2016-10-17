package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ClientRoleTable;
import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.ClientRoleResource;
import cn.hopever.platform.user.resources.ModuleResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class ClientResourceAssembler extends ResourceAssemblerSupport<ClientTable, ClientResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public ClientResourceAssembler() {
        super(ClientResourceController.class, ClientResource.class);
    }

    @Override
    public ClientResource toResource(ClientTable clientTable) {
        ClientResource resource = createResource(clientTable);
        //关联其他资源
        if (clientTable.getAuthoritiesBasic() != null) {
            Set<ClientRoleResource> sCrr = new LinkedHashSet<>();
            for (ClientRoleTable crt : clientTable.getAuthoritiesBasic()) {
                ClientRoleResource crr = new ClientRoleResource();
                crr.setInternalId(crt.getId());
                crr.setAuthority(crt.getAuthority());
                sCrr.add(crr);
            }
            resource.setAuthorities(sCrr);
        }
        if (clientTable.getModules() != null) {
            Set<ModuleResource> sMr = new LinkedHashSet<>();
            for (ModuleTable mt : clientTable.getModules()) {
                ModuleResource mr = new ModuleResource();
                mr.setInternalId(mt.getId());
                mr.setModuleName(mt.getModuleName());
                sMr.add(mr);
            }
            resource.setModules(sMr);
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
