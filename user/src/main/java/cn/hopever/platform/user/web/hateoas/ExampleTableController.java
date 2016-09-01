package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.resources.ExampleTableResource;
import cn.hopever.platform.user.service.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/example", produces = "application/json")
public class ExampleTableController {
    @Autowired
    private ExampleTableService testTableService;


    @Autowired
    private ExampleTableAssembler exampleTableAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<ExampleTableResource>> showAll() {
        Iterable<ExampleTable> list = testTableService.findAll();
        List<ExampleTableResource> resources = exampleTableAssembler.toResources(list);
        return new HttpEntity<>(resources);
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public HttpEntity<Resources<ExampleTableResource>> showAllAsResources() {
        Iterable<ExampleTable> list = testTableService.findAll();
        List<ExampleTableResource> resources = exampleTableAssembler.toResources(list);
        Resources<ExampleTableResource> wrapped = new Resources<ExampleTableResource>(resources, linkTo(ExampleTableController.class)
                .withSelfRel());
        return new HttpEntity<>(wrapped);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<ExampleTableResource> getOne(@PathVariable("id") Integer id) {
        ExampleTable exampleTable = testTableService.getOneById(id);
        ExampleTableResource resource = exampleTableAssembler.toResource(exampleTable);
        return new HttpEntity<>(resource);
    }


//    @RequestMapping(value = "/save/{userName}", method = RequestMethod.GET)
//    public ResponseEntity<ExampleTableDto> saveOne(@PathVariable("userName") String userName) {
//        ExampleTable exampleTable = new ExampleTable(userName);
//        exampleTable = testTableService.addOne(exampleTable);
//        return new ResponseEntity<>(modelMapper.map(exampleTable, ExampleTableDto.class), HttpStatus.OK);
//    }
//
//    @RequestMapping( method = RequestMethod.GET)
//    public ResponseEntity<ExampleTableDto> getAll() {
//        Iterable<ExampleTable> list = testTableService.findAll();
//        return new ResponseEntity<>(modelMapper.map(list, ExampleTableDto.class), HttpStatus.OK);
//    }
}
