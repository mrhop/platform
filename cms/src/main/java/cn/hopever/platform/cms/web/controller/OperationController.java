package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.OperationTable;
import cn.hopever.platform.cms.service.OperationTableService;
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
//操作表只有管理员可用
@RestController
@RequestMapping(value = "/operation", produces = "application/json")
public class OperationController {
    Logger logger = LoggerFactory.getLogger(OperationController.class);
    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private OperationTableService operationTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<OperationTable> list;
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
        list = operationTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (OperationTable ot : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", ot.getId());
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

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限
            this.operationTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
            this.operationTableService.get(id);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateOperation(@RequestBody Map<String,Object> body, Principal principal) {
            //do update
            //this.operationTableService.save()

        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveOperation(@RequestBody Map<String,Object> body, Principal principal) {
        //this.operationTableService.save()
        return null;
    }

}
