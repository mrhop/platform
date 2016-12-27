package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.TemplateTable;
import cn.hopever.platform.cms.service.TemplateTableService;
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
@RestController
@RequestMapping(value = "/template", produces = "application/json")
public class TemplateController {
    Logger logger = LoggerFactory.getLogger(TemplateController.class);
    @Autowired
    private TemplateTableService templateTableService;

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
        Map<String, Object> filterMap = null;
        if (body.get("filters") != null && !body.get("filters").isNull()) {
            filterMap = JacksonUtil.mapper.convertValue(body.get("filters"), Map.class);
        }
        filterMap.put("website", websiteTableService.getWebsiteAsFilter(principal, filterMap.get("website") != null ? filterMap.get("website").toString() : null));
        list = templateTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (TemplateTable tt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", tt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
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
        //需要判断是否普通用户有相关的website可处理权
        if (websiteTableService.validatePermission(principal, templateTableService.get(id).getWebsite())) {
            this.templateTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, templateTableService.get(id).getWebsite())) {
            this.templateTableService.get(id);
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
    public Map updateTemplate(@RequestBody Map<String, Object> body, Principal principal) {
        if (websiteTableService.validatePermission(principal, templateTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveTemplate(@RequestBody Map<String, Object> body, Principal principal) {
        return null;
    }


}
