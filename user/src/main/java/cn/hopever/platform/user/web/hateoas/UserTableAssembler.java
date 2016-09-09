package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.UserTable;
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
public class UserTableAssembler extends ResourceAssemblerSupport<UserTable, UserTableResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public UserTableAssembler() {
        super(UserTableController.class, UserTableResource.class);
    }
    @Override
    public UserTableResource toResource(UserTable userTable) {

        UserTableResource resource = createResource(userTable);
        // … do further mapping
        return resource;
    }

    private UserTableResource createResource(UserTable userTable){
        UserTableResource userTableResource = null;
        if(userTable!=null){
            userTableResource =  modelMapper.map(userTable, UserTableResource.class);
            userTableResource.add( entityLinks.linkFor(UserTableResource.class).slash(userTable.getId()).withSelfRel());
        }
        return userTableResource;
    }

}
