package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.resources.ClientTableResource;
import cn.hopever.platform.user.resources.UserTableResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class ClientTableAssembler extends ResourceAssemblerSupport<ClientTable, ClientTableResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public ClientTableAssembler() {
        super(ClientTableController.class, ClientTableResource.class);
    }
    @Override
    public ClientTableResource toResource(ClientTable clientTable) {

        ClientTableResource resource = createResource(clientTable);
        // … do further mapping
        return resource;
    }

    private ClientTableResource createResource(ClientTable clientTable){
        ClientTableResource clientTableResource = null;
        if(clientTable!=null){
            clientTableResource =  modelMapper.map(clientTable, ClientTableResource.class);
            clientTableResource.add( entityLinks.linkFor(UserTableResource.class).slash(clientTable.getId()).withSelfRel());
        }
        return clientTableResource;
    }

}
