package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.WebsiteTable;
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
import java.util.*;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/website", produces = "application/json")
public class WebsiteController {
    Logger logger = LoggerFactory.getLogger(WebsiteController.class);
    @Autowired
    private WebsiteTableService websiteTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<WebsiteTable> list;
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
        list = websiteTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (WebsiteTable wt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", wt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(wt.getTitle());
                listTmp.add(wt.getKeywords());
                listTmp.add(wt.getDescription());
                listTmp.add(wt.isEnabled() ? "Y" : "N");
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
        this.websiteTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        WebsiteTable wt = this.websiteTableService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", wt.getId());
        map.put("title", wt.getTitle());
        map.put("keywords", wt.getKeywords());
        map.put("description", wt.getDescription());
        map.put("enabled", wt.isEnabled());
        //此处应该有相关联的用户的勾选管理
        map.put("relatedUsernames", wt.getRelatedUsernames() == null ? null : wt.getRelatedUsernames().split(","));
        map.put("resourceAddress", wt.getResourceAddress());
        map.put("resourceUrlPrefix", wt.getResourceUrlPrefix());
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateWebsite(@RequestBody Map<String, Object> body, Principal principal) {
        long id = Long.valueOf(body.get("id").toString());
        WebsiteTable websiteTable = this.websiteTableService.get(id);
        if (body.get("title") != null) {
            websiteTable.setTitle(body.get("title").toString());
        }
        if (body.get("keywords") != null) {
            websiteTable.setKeywords(body.get("keywords").toString());
        }
        if (body.get("description") != null) {
            websiteTable.setDescription(body.get("description").toString());
        }
        if (body.get("enabled") != null && ((List) body.get("enabled")).size() > 0) {
            websiteTable.setEnabled(true);
        } else {
            websiteTable.setEnabled(false);
        }
        if (body.get("relatedUsernames") != null && ((List) body.get("relatedUsernames")).size() > 0) {
            StringBuilder str = new StringBuilder();
            for (Object username : (List) body.get("relatedUsernames")) {
                str.append(username.toString()).append(",");
            }
            websiteTable.setRelatedUsernames(str.substring(0, str.length() - 1));
        } else {
            websiteTable.setRelatedUsernames(null);
        }
        if (body.get("resourceAddress") != null) {
            websiteTable.setResourceAddress(body.get("resourceAddress").toString());
        }
        if (body.get("resourceUrlPrefix") != null) {
            websiteTable.setResourceUrlPrefix(body.get("resourceUrlPrefix").toString());
        }
        this.websiteTableService.save(websiteTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveWebsite(@RequestBody Map<String, Object> body, Principal principal) {
        long id = Long.valueOf(body.get("id").toString());
        WebsiteTable websiteTable = new WebsiteTable();
        if (body.get("title") != null) {
            websiteTable.setTitle(body.get("title").toString());
        }
        if (body.get("keywords") != null) {
            websiteTable.setKeywords(body.get("keywords").toString());
        }
        if (body.get("description") != null) {
            websiteTable.setDescription(body.get("description").toString());
        }
        if (body.get("enabled") != null && ((List) body.get("enabled")).size() > 0) {
            websiteTable.setEnabled(true);
        } else {
            websiteTable.setEnabled(false);
        }
        if (body.get("relatedUsernames") != null && ((List) body.get("relatedUsernames")).size() > 0) {
            StringBuilder str = new StringBuilder();
            for (Object username : (List) body.get("relatedUsernames")) {
                str.append(username.toString()).append(",");
            }
            websiteTable.setRelatedUsernames(str.substring(0, str.length() - 1));
        } else {
            websiteTable.setRelatedUsernames(null);
        }
        if (body.get("resourceAddress") != null) {
            websiteTable.setResourceAddress(body.get("resourceAddress").toString());
        }
        if (body.get("resourceUrlPrefix") != null) {
            websiteTable.setResourceUrlPrefix(body.get("resourceUrlPrefix").toString());
        }
        this.websiteTableService.save(websiteTable);
        return null;
    }
}
