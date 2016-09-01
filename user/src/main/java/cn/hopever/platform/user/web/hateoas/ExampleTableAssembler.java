package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.resources.ExampleTableResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class ExampleTableAssembler extends ResourceAssemblerSupport<ExampleTable, ExampleTableResource> {

    @Autowired
    private ModelMapper modelMapper;

    public ExampleTableAssembler() {
        super(ExampleTableController.class, ExampleTableResource.class);
    }
    @Override
    public ExampleTableResource toResource(ExampleTable exampleTable) {

        ExampleTableResource resource = createResource(exampleTable);
        // … do further mapping
        return resource;
    }

    private ExampleTableResource createResource(ExampleTable exampleTable){
        ExampleTableResource exampleTableResource = null;
        if(exampleTable!=null){
            exampleTableResource =  modelMapper.map(exampleTable, ExampleTableResource.class);
            exampleTableResource.add(linkTo(ExampleTableController.class).slash(exampleTable.getId()).withSelfRel());
        }
        return exampleTableResource;
    }

}