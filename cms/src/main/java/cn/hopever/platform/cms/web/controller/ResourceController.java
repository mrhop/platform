package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.ResourceTable;
import cn.hopever.platform.cms.service.ResourceTableService;
import cn.hopever.platform.cms.service.WebsiteTableService;
import cn.hopever.platform.utils.json.JacksonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
//当是admin的时候，website可以为空，此处到client时需要考虑
@RestController
@RequestMapping(value = "/resource", produces = "application/json")
public class ResourceController {
    Logger logger = LoggerFactory.getLogger(ResourceController.class);

    //只有resource 有global，是的
    @Autowired
    private WebsiteTableService websiteTableService;

    @Autowired
    private ResourceTableService resourceTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<ResourceTable> list;
        PageRequest pageRequest;
        if (body.get("sort") == null || body.get("sort").isNull()) {
            pageRequest = new PageRequest(body.get("currentPage").asInt(), body.get("rowSize").asInt(), Sort.Direction.ASC, "id");
        } else {
            pageRequest = new PageRequest(body.get("currentPage").asInt(), body.get("rowSize").asInt(), Sort.Direction.fromString(body.get("sort").get("sortDirection").textValue()), body.get("sort").get("sortName").textValue());
        }
        Map<String, Object> filterMap = new HashMap<>();
        if (body.get("filters") != null && !body.get("filters").isNull()) {
            filterMap = JacksonUtil.mapper.convertValue(body.get("filters"), Map.class);
        }
        if(filterMap.get("website") != null){
            filterMap.put("website", websiteTableService.getWebsiteAsFilter(principal, filterMap.get("website").toString()));
        }
        list = resourceTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (ResourceTable rt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", rt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(rt.getName());
                listTmp.add(rt.getUrl());
                listTmp.add(rt.getType());
                if(rt.getWebsite()!=null){
                    listTmp.add(rt.getWebsite().getTitle());
                }else{
                    listTmp.add(null);
                }
                mapTemp.put("value", listTmp);
                listReturn.add(mapTemp);
            }
            map.put("data", listReturn);
            map.put("totalCount", list.getTotalElements());
            map.put("rowSize", body.get("rowSize").asInt());
            map.put("currentPage", list.getNumber());
        } else {
            map.put("data", null);
            map.put("totalCount", 0);
            map.put("rowSize", body.get("rowSize").asInt());
            map.put("currentPage", 0);
        }
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, resourceTableService.get(id).getWebsite())) {
            this.resourceTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, resourceTableService.get(id).getWebsite())) {
            ResourceTable rt = this.resourceTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", rt.getId());
            map.put("name", rt.getName());
            map.put("url", rt.getUrl());
            map.put("type", rt.getType());
            if(rt.getWebsite()!=null){
                map.put("website", rt.getWebsite().getId());
            }else{
                map.put("website", null);
            }
            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateResource(@RequestBody Map<String, Object> bodyOriginal, Principal principal) {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        if (websiteTableService.validatePermission(principal, resourceTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            long id = Long.valueOf(body.get("id").toString());
            ResourceTable resourceTable = this.resourceTableService.get(id);
            if (body.get("name") != null) {
                resourceTable.setName(body.get("name").toString());
            }
            if (body.get("url") != null) {
                resourceTable.setUrl(body.get("url").toString());
            }
            if (body.get("type") != null) {
                resourceTable.setType(body.get("type").toString());
            }
            if (body.get("website") != null ) {
                resourceTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
            }
            this.resourceTableService.save(resourceTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveResource(@RequestBody Map<String, Object> bodyOriginal, Principal principal) {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        long id = Long.valueOf(body.get("id").toString());
        ResourceTable resourceTable = new ResourceTable();
        if (body.get("name") != null) {
            resourceTable.setName(body.get("name").toString());
        }
        if (body.get("url") != null) {
            resourceTable.setUrl(body.get("url").toString());
        }
        if (body.get("type") != null) {
            resourceTable.setType(body.get("type").toString());
        }
        if (body.get("website") != null ) {
            resourceTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        this.resourceTableService.save(resourceTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/options", method = {RequestMethod.GET})
    public List getOptionList(@RequestParam Long websiteId,Principal principal) {
        List<Map> listOptions = null;
        Iterable<ResourceTable> list = resourceTableService.getListByWebsite(websiteId);
        if (list != null && list.iterator().hasNext()) {
            listOptions = new ArrayList<>();
            for (ResourceTable rt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", rt.getName());
                mapOption.put("value", rt.getId());
                listOptions.add(mapOption);
            }
        }
        return listOptions;
    }

}
