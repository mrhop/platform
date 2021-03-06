package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.PollTable;
import cn.hopever.platform.cms.service.PollTableService;
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
@RequestMapping(value = "/poll", produces = "application/json")
public class PollController {
    Logger logger = LoggerFactory.getLogger(PollController.class);
    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private PollTableService pollTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<PollTable> list;
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
        list = pollTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (PollTable pt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", pt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(pt.getTitle());
                if(pt.getWebsite()!=null){
                    listTmp.add(pt.getWebsite().getTitle());
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
        //需要判断是否普通用户有相关的website可处理权限
        if (websiteTableService.validatePermission(principal, pollTableService.get(id).getWebsite())) {
            this.pollTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, pollTableService.get(id).getWebsite())) {
            PollTable pt = this.pollTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", pt.getId());
            map.put("title", pt.getTitle());
            if(pt.getWebsite()!=null){
                map.put("website", pt.getWebsite().getId());
            }else{
                map.put("website", null);
            }
            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updatePoll(@RequestBody Map<String,Object> bodyOriginal, Principal principal) {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        if (websiteTableService.validatePermission(principal, pollTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            //this.pollTableService.save()
            long id = Long.valueOf(body.get("id").toString());
            PollTable pollTable = this.pollTableService.get(id);
            if (body.get("title") != null) {
                pollTable.setTitle(body.get("title").toString());
            }
            if (body.get("website") != null ) {
                pollTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
            }
            this.pollTableService.save(pollTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map savePoll(@RequestBody Map<String,Object> bodyOriginal, Principal principal) {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        PollTable pollTable = new PollTable();
        if (body.get("title") != null) {
            pollTable.setTitle(body.get("title").toString());
        }
        if (body.get("website") != null ) {
            pollTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        this.pollTableService.save(pollTable);
        return null;
    }
    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/options", method = {RequestMethod.GET})
    public List getOptionList(@RequestParam Long websiteId,Principal principal) {
        List<Map> listOptions = null;
        Iterable<PollTable> list = pollTableService.getListByWebsite(websiteId);
        if (list != null && list.iterator().hasNext()) {
            listOptions = new ArrayList<>();
            for (PollTable pt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", pt.getTitle());
                mapOption.put("value", pt.getId());
                listOptions.add(mapOption);
            }
        }
        return listOptions;
    }


}
