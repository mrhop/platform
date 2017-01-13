package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.OperationTable;
import cn.hopever.platform.cms.service.OperationTableService;
import cn.hopever.platform.cms.service.WebsiteTableService;
import cn.hopever.platform.utils.json.JacksonUtil;
import cn.hopever.platform.utils.tools.DateFormat;
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
import java.util.*;

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
        Map<String, Object> filterMap = new HashMap<>();
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
                listTmp.add(ot.getRelatedOperation());
                listTmp.add(ot.getIp());
                listTmp.add(ot.getOperationUser());
                listTmp.add(DateFormat.sdf.format(ot.getOperationDate()));
                if (ot.getWebsite() != null) {
                    listTmp.add(ot.getWebsite().getTitle());
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

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限
        this.operationTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        OperationTable ot = this.operationTableService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", ot.getId());
        map.put("relatedOperation", ot.getRelatedOperation());
        map.put("relatedId", ot.getRelatedId());
        map.put("ip", ot.getIp());
        map.put("operationUser", ot.getIp());
        map.put("operationDate", DateFormat.sdf.format(ot.getOperationDate()));
        if (ot.getWebsite() != null) {
            map.put("website",  ot.getWebsite().getTitle());
        } else {
            map.put("website", null);
        }
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateOperation(@RequestBody Map<String, Object> body, Principal principal) {
        //不可执行更新处理
        long id = Long.valueOf(body.get("id").toString());
        OperationTable operationTable = this.operationTableService.get(id);
        this.operationTableService.save(operationTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveOperation(@RequestBody Map<String, Object> body, Principal principal) {
        //
        OperationTable operationTable = new OperationTable();
        if (body.get("relatedOperation") != null) {
            operationTable.setRelatedOperation(body.get("relatedOperation").toString());
        }
        if (body.get("relatedId") != null) {
            operationTable.setRelatedId(Long.valueOf(body.get("relatedId").toString()));
        }
        if (body.get("ip") != null) {
            operationTable.setIp(body.get("ip").toString());
        }
        if (body.get("operationUser") != null) {
            operationTable.setOperationUser(principal.getName());
        }
        if (body.get("operationDate") != null) {
            operationTable.setOperationDate(new Date());
        }
        if (body.get("website") != null) {
            operationTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        this.operationTableService.save(operationTable);
        return null;
    }

}
