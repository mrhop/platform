package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ClientRoleTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.ClientRoleResource;
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
public class ClientRoleResourceAssembler extends ResourceAssemblerSupport<ClientRoleTable, ClientRoleResource> {

    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public ClientRoleResourceAssembler() {
        super(ClientRoleResourceController.class, ClientRoleResource.class);
        modelMapper = new ModelMapper();
        PropertyMap<ClientRoleTable, ClientRoleResource> map = new PropertyMap<ClientRoleTable, ClientRoleResource>() {
            protected void configure() {
                skip().setClients(null);
            }
        };
        modelMapper.addMappings(map);
    }

    @Override
    public ClientRoleResource toResource(ClientRoleTable clientRoleTable) {
        ClientRoleResource resource = createResource(clientRoleTable);
        return resource;
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
