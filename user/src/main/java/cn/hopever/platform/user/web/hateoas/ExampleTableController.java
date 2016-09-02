package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.resources.ExampleTableResource;
import cn.hopever.platform.user.service.ExampleTableService;
import cn.hopever.platform.utils.tools.BeanUtils;
import cn.hopever.platform.utils.web.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@ExposesResourceFor(ExampleTableResource.class)
@RequestMapping(value = "/example", produces = "application/json")
public class ExampleTableController {
    Logger logger = LoggerFactory.getLogger(ExampleTableController.class);
    @Autowired
    private ExampleTableService testTableService;

    @Autowired
    EntityLinks entityLinks;

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
        Resources<ExampleTableResource> wrapped = new Resources<ExampleTableResource>(resources, entityLinks.linkFor(ExampleTableResource.class)
                .withSelfRel());
        return new HttpEntity<>(wrapped);
    }

    @RequestMapping(value = "/paged/{size}/{number}", method = RequestMethod.GET)
    public HttpEntity<PagedResources<ExampleTableResource>> showAllPaged(@PathVariable("size") Integer size, @PathVariable("number") Integer number) {

        //here find paged data
        //find the total count
        Iterable<ExampleTable> list = testTableService.findAll();
        List<ExampleTableResource> resources = exampleTableAssembler.toResources(list);
        long totalElements = resources.size();
        long totalPages = totalElements / size + (totalElements % size > 0 ? 1 : 0);
        PagedResources.PageMetadata pageMetadata = new PagedResources.PageMetadata(size, number, totalElements, totalPages);
        PagedResources<ExampleTableResource> pagedResources = new PagedResources<ExampleTableResource>(resources, pageMetadata);
        pagedResources.add(entityLinks.linkFor(ExampleTableResource.class).slash(size).slash(number).withSelfRel());
        if (number < totalPages) {
            pagedResources.add(entityLinks.linkFor(ExampleTableResource.class).slash(size).slash(number + 1).withRel("next_page"));
        }
        if (number > 1) {
            pagedResources.add(entityLinks.linkFor(ExampleTableResource.class).slash(size).slash(number - 1).withRel("last_page"));
        }
        return new HttpEntity<>(pagedResources);
    }

    @RequestMapping(value = "/filter/{username}", method = RequestMethod.GET)
    public HttpEntity<Resources<ExampleTableResource>> filterByUserName(@PathVariable("username") String username) {
        Iterable<ExampleTable> list = testTableService.getByUserName(username);
        List<ExampleTableResource> resources = exampleTableAssembler.toResources(list);
        Resources<ExampleTableResource> wrapped = new Resources<>(resources, entityLinks.linkFor(ExampleTableResource.class).slash("filter").slash(username)
                .withSelfRel());
        return new HttpEntity<>(wrapped);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ExampleTableResource> getExampleTable(@PathVariable("id") Integer id) {
        ExampleTable exampleTable = testTableService.getOneById(id);
        if (exampleTable != null) {
            ExampleTableResource resource = exampleTableAssembler.toResource(exampleTable);
            if (resource != null) {
                resource.add(entityLinks.linkFor(ExampleTableResource.class).slash("update").slash(id).withRel("update"));
                resource.add(entityLinks.linkFor(ExampleTableResource.class).slash("delete").slash(id).withRel("delete"));
            }
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return null;
    }

    @RequestMapping(value = "/byname/{username}", method = RequestMethod.GET)
    public ResponseEntity<ExampleTableResource> getExampleTableByUserName(@PathVariable("username") String username) {
        ExampleTable exampleTable = testTableService.getOneByUserName(username);
        if (exampleTable != null) {
            ExampleTableResource resource = exampleTableAssembler.toResource(exampleTable);
            if (resource != null) {
                resource.add(entityLinks.linkFor(ExampleTableResource.class).slash("update").slash(exampleTable.getId()).withRel("update"));
                resource.add(entityLinks.linkFor(ExampleTableResource.class).slash("delete").slash(exampleTable.getId()).withRel("delete"));
                resource.add(entityLinks.linkFor(ExampleTableResource.class).slash("byname").slash(username).withRel("byname"));
            }
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
        return null;
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateExampleTable(@PathVariable("id") Integer id, @RequestBody ExampleTableResource resource) {
        //post json，然后返回单个resource的处理
        ExampleTable exampleTable = testTableService.getOneById(id);
        if (exampleTable != null) {
            BeanUtils.copyNotNullProperties(resource, exampleTable);
            try {
                exampleTable = testTableService.saveOne(exampleTable);
                return new CommonResult(true, "delete success");
            } catch (Exception e) {
                logger.error("deleteExampleTable error",e);
                return new CommonResult(false, "delete failure:" + e.getMessage());
            }
        }else{
            return new CommonResult(false, "update failure:no such ExampleTable entity of id - "+id);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public CommonResult deleteExampleTable(@PathVariable("id") Integer id) {
        //post json，然后返回单个resource的处理
        try {
            testTableService.deleteOne(id);
            return new CommonResult(true, "delete success");
        } catch (Exception e) {
            logger.error("deleteExampleTable error",e);
            return new CommonResult(false, "delete failure:" + e.getMessage());
        }
    }


}
