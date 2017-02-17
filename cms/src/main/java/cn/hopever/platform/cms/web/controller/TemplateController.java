package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.TemplateBlockTable;
import cn.hopever.platform.cms.domain.TemplateResourceTable;
import cn.hopever.platform.cms.domain.TemplateTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.service.BlockTableService;
import cn.hopever.platform.cms.service.ResourceTableService;
import cn.hopever.platform.cms.service.TemplateTableService;
import cn.hopever.platform.cms.service.WebsiteTableService;
import cn.hopever.platform.utils.json.JacksonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/template", produces = "application/json")
public class TemplateController {
    Logger logger = LoggerFactory.getLogger(TemplateController.class);
    @Autowired
    private TemplateTableService templateTableService;
    @Autowired
    private BlockTableService blockTableService;
    @Autowired
    private ResourceTableService resourceTableService;
    @Autowired
    private WebsiteTableService websiteTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<TemplateTable> list;
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
        List listWebsite = websiteTableService.getWebsiteAsFilter(principal, filterMap.get("website") != null ? filterMap.get("website").toString() : null);
        if(listWebsite!=null){
            filterMap.put("website", listWebsite);
        }
        list = templateTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (TemplateTable tt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", tt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(tt.getName());
                listTmp.add(tt.getLayoutType());
                listTmp.add(tt.getLayoutScale());
                listTmp.add(tt.getContentPosition());
                if (tt.getWebsite() != null) {
                    listTmp.add(tt.getWebsite().getTitle());
                } else {
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

    @RequestMapping(value = "/options/bywebsite", method = {RequestMethod.GET})
    public List getList(@RequestParam Long websiteId, Principal principal) {
        List<Map> listOptions = null;
        WebsiteTable wt = websiteTableService.get(websiteId);
        List<TemplateTable> list = templateTableService.getListByWebsiteOrNull(wt);
        if (list != null && list.size() > 0) {
            listOptions = new ArrayList<>();
            for (TemplateTable tt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", tt.getName());
                mapOption.put("value", tt.getId());
                listOptions.add(mapOption);
            }
        }
        return listOptions;
    }


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权
        if (websiteTableService.validatePermission(principal, templateTableService.get(id).getWebsite())) {
            this.templateTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) throws IOException {
        if (websiteTableService.validatePermission(principal, templateTableService.get(id).getWebsite())) {
            TemplateTable tt = this.templateTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", tt.getId());
            map.put("name", tt.getName());
            map.put("description", tt.getDescription());
            map.put("layoutType", tt.getLayoutType());
            map.put("layoutScale", tt.getLayoutScale());
            map.put("contentPosition", tt.getContentPosition());
            map.put("contentScript", tt.getContentScript());
            if (tt.getWebsite() != null) {
                map.put("website", tt.getWebsite().getId());
            } else {
                map.put("website", null);
            }
            if (tt.getTemplateBlocks() != null) {
                List<Long> templateBlocks = new ArrayList<>();
                Map<String,Object> blocksPosition = new HashMap<>();

                for (TemplateBlockTable tbt : tt.getTemplateBlocks()) {
                    templateBlocks.add(tbt.getBlock().getId());
                    blocksPosition.put("block_id_"+tbt.getBlock().getId(),JacksonUtil.mapper.readValue(tbt.getBlockPosition(),new TypeReference<HashMap<String,List>>(){}));
                }
                map.put("templateBlocks", templateBlocks);
                map.put("blocksPosition", blocksPosition);
            } else {
                map.put("templateBlocks", null);
                map.put("blocksPosition", null);
            }
            if (tt.getTemplateResources() != null) {
                List<Long> templateResources = new ArrayList<>();
                Map<String,Object> resources = new HashMap<>();

                for (TemplateResourceTable trt : tt.getTemplateResources()) {
                    templateResources.add(trt.getResource().getId());
                    String position = "{\"location\":\""+(trt.isTop()?"head":"foot")+"\",\"order\":"+trt.getOrderNum()+"}";
                    resources.put("resource_id_"+trt.getResource().getId(),JacksonUtil.mapper.readValue(position,new TypeReference<HashMap<String,Object>>(){}));
                }
                map.put("templateResources", templateResources);
                map.put("resources", resources);
            } else {
                map.put("templateResources", null);
                map.put("resources", null);
            }
            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/preview", method = {RequestMethod.GET})
    public Map preview(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, templateTableService.get(id).getWebsite())) {
            //do preview
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateTemplate(@RequestBody Map<String, Object> bodyOriginal, Principal principal) throws JsonProcessingException {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        if (websiteTableService.validatePermission(principal, templateTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            long id = Long.valueOf(body.get("id").toString());
            TemplateTable templateTable = this.templateTableService.get(id);
            if (body.get("name") != null) {
                templateTable.setName(body.get("name").toString());
            }
            if (body.get("description") != null) {
                templateTable.setDescription(body.get("description").toString());
            }
            if (body.get("layoutType") != null) {
                templateTable.setLayoutType(body.get("layoutType").toString());
            }
            if (body.get("layoutScale") != null) {
                templateTable.setLayoutScale(body.get("layoutScale").toString());
            }
            if (body.get("contentPosition") != null) {
                templateTable.setContentPosition(body.get("contentPosition").toString());
            }
            if (body.get("contentScript") != null) {
                templateTable.setContentScript(body.get("contentScript").toString());
            }
            if (body.get("website") != null) {
                templateTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
            }
            templateTableService.deleteTemplateBlockByTemplate(templateTable);
            if (body.get("templateBlocks") != null) {
                List<Integer> templateBlocks = (List) body.get("templateBlocks");
                Map<String,Map> blocksPosition = (Map)body.get("blocksPosition");
                if (templateBlocks.size() > 0) {
                    List<TemplateBlockTable> list = new ArrayList<>();
                    for (Integer blockId : templateBlocks) {
                        TemplateBlockTable tbt = new TemplateBlockTable();
                        tbt.setBlock(blockTableService.get(Long.valueOf(blockId.toString())));
                        tbt.setTemplate(templateTable);
                        tbt.setBlockPosition(JacksonUtil.mapper.writeValueAsString(blocksPosition.get("block_id_"+blockId)));
                        list.add(tbt);
                    }
                    templateTable.setTemplateBlocks(list);
                } else {
                    templateTable.setTemplateBlocks(null);
                }
            } else {
                templateTable.setTemplateBlocks(null);
            }
            templateTableService.deleteTemplateResourceByTemplate(templateTable);
            if (body.get("templateResources") != null) {
                List<Integer> templateResources = (List) body.get("templateResources");
                Map<String,Map> resources = (Map)body.get("resources");
                if (templateResources.size() > 0) {
                    List<TemplateResourceTable> list = new ArrayList<>();
                    for (Integer resourceId : templateResources) {
                        TemplateResourceTable trt = new TemplateResourceTable();
                        trt.setResource(resourceTableService.get(Long.valueOf(resourceId.toString())));
                        trt.setTemplate(templateTable);
                        Map<String,Object> position =  resources.get("resource_id_"+resourceId);
                        trt.setOrderNum(Integer.valueOf(position.get("order").toString()));
                        trt.setTop(position.get("location")==null||"head".equals(position.get("location")));
                        list.add(trt);
                    }
                    templateTable.setTemplateResources(list);
                } else {
                    templateTable.setTemplateResources(null);
                }
            } else {
                templateTable.setTemplateResources(null);
            }
            this.templateTableService.save(templateTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveTemplate(@RequestBody Map<String, Object> bodyOriginal, Principal principal) throws JsonProcessingException {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        TemplateTable templateTable = new TemplateTable();
        if (body.get("name") != null) {
            templateTable.setName(body.get("name").toString());
        }
        if (body.get("description") != null) {
            templateTable.setDescription(body.get("description").toString());
        }
        if (body.get("layoutType") != null) {
            templateTable.setLayoutType(body.get("layoutType").toString());
        }
        if (body.get("layoutScale") != null) {
            templateTable.setLayoutScale(body.get("layoutScale").toString());
        }
        if (body.get("contentPosition") != null) {
            templateTable.setContentPosition(body.get("contentPosition").toString());
        }
        if (body.get("contentScript") != null) {
            templateTable.setContentScript(body.get("contentScript").toString());
        }
        if (body.get("website") != null) {
            templateTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        if (body.get("templateBlocks") != null) {
            List<Integer> templateBlocks = (List) body.get("templateBlocks");
            Map<String,Map> blocksPosition = (Map)body.get("blocksPosition");

            if (templateBlocks.size() > 0) {
                List<TemplateBlockTable> list = new ArrayList<>();
                for (Integer blockId : templateBlocks) {
                    TemplateBlockTable tbt = new TemplateBlockTable();
                    tbt.setBlock(blockTableService.get(Long.valueOf(blockId.toString())));
                    tbt.setTemplate(templateTable);
                    tbt.setBlockPosition(JacksonUtil.mapper.writeValueAsString(blocksPosition.get("block_id_"+blockId)));
                    list.add(tbt);
                }
                templateTable.setTemplateBlocks(list);
            } else {
                templateTable.setTemplateBlocks(null);
            }
        } else {
            templateTable.setTemplateBlocks(null);
        }
        if (body.get("templateResources") != null) {
            List<Integer> templateResources = (List) body.get("templateResources");
            Map<String,Map> resources = (Map)body.get("resources");
            if (templateResources.size() > 0) {
                List<TemplateResourceTable> list = new ArrayList<>();
                for (Integer resourceId : templateResources) {
                    TemplateResourceTable trt = new TemplateResourceTable();
                    trt.setResource(resourceTableService.get(Long.valueOf(resourceId.toString())));
                    trt.setTemplate(templateTable);
                    Map<String,Object> position =  resources.get("resource_id_"+resourceId);
                    trt.setOrderNum(Integer.valueOf(position.get("order").toString()));
                    trt.setTop(position.get("location")==null||"head".equals(position.get("location")));
                    list.add(trt);
                }
                templateTable.setTemplateResources(list);
            } else {
                templateTable.setTemplateResources(null);
            }
        } else {
            templateTable.setTemplateResources(null);
        }
        this.templateTableService.save(templateTable);
        return null;
    }


}
