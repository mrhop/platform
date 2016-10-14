package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ClientRoleTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.ClientRoleResource;
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
public class ClientRoleResourceAssembler extends ResourceAssemblerSupport<ClientRoleTable, ClientRoleResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public ClientRoleResourceAssembler() {
        super(ClientRoleResourceController.class, ClientRoleResource.class);
    }

    @Override
    public ClientRoleResource toResource(ClientRoleTable clientRoleTable) {
        ClientRoleResource resource = createResource(clientRoleTable);
        return resource;
    }

    public Set<ClientRoleResource> toResources(Set<ClientRoleTable> clientRoleTables) {
        Set<ClientRoleResource> returnSet = new LinkedHashSet<>();
        for (ClientRoleTable crt : clientRoleTables) {
            returnSet.add(this.createResource(crt));
        }
        return returnSet;
    }

    private ClientRoleResource createResource(ClientRoleTable clientRoleTable) {
        ClientRoleResource clientRoleResource = null;
        if (clientRoleTable != null) {
            clientRoleResource = modelMapper.map(clientRoleTable, ClientRoleResource.class);
            clientRoleResource.setInternalId(clientRoleTable.getId());
            clientRoleResource.add(entityLinks.linkFor(ClientResource.class).slash(clientRoleTable.getId()).withSelfRel());
        }
        return clientRoleResource;
    }
}
