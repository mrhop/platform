package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.BlockTable;
import cn.hopever.platform.cms.service.*;
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
@RequestMapping(value = "/block", produces = "application/json")
public class BlockController {
    Logger logger = LoggerFactory.getLogger(BlockController.class);

    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private NewsTypeTableService newsTypeTableService;
    @Autowired
    private PollTableService pollTableService;
    @Autowired
    private FileLibraryTypeTableService fileLibraryTypeTableService;
    @Autowired
    private BlockTableService blockTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<BlockTable> list;
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
        list = blockTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (BlockTable bt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", bt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(bt.getName());
                listTmp.add(bt.getType());
                if (bt.getWebsite() != null) {
                    listTmp.add(bt.getWebsite().getTitle());
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

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限
        if (websiteTableService.validatePermission(principal, blockTableService.get(id).getWebsite())) {
            this.blockTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, blockTableService.get(id).getWebsite())) {
            BlockTable bt = this.blockTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", bt.getId());
            map.put("name", bt.getName());
            if (bt.getWebsite() != null) {
                map.put("website",  bt.getWebsite().getId());
            } else {
                map.put("website", null);
            }
            map.put("type", bt.getType());
            map.put("content", bt.getContent());
            map.put("dataUrl", bt.getDataUrl());
            map.put("script", bt.getScript());
            if (bt.getNewsType() != null) {
                map.put("newsType",  bt.getNewsType().getId());
            } else {
                map.put("newsType", null);
            }
            map.put("newsNumber", bt.getNewsNumber());
            if (bt.getPoll() != null) {
                map.put("poll", bt.getPoll().getId());
            } else {
                map.put("poll", null);
            }
            if (bt.getFileLibraryType() != null) {
                map.put("fileLibraryType", bt.getFileLibraryType().getId());
            } else {
                map.put("fileLibraryType", null);
            }
            map.put("fileLibraryNumber", bt.getFileLibraryNumber());

            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateBlock(@RequestBody Map<String, Object> body, Principal principal) {
        if (websiteTableService.validatePermission(principal, blockTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            long id = Long.valueOf(body.get("id").toString());
            BlockTable blockTable = this.blockTableService.get(id);
            if (body.get("name") != null) {
                blockTable.setName(body.get("name").toString());
            }
            if (body.get("type") != null) {
                blockTable.setType(body.get("type").toString());
            }
            if (body.get("content") != null) {
                blockTable.setContent(body.get("content").toString());
            }
            if (body.get("dataUrl") != null) {
                blockTable.setDataUrl(body.get("dataUrl").toString());
            }
            if (body.get("script") != null) {
                blockTable.setScript(body.get("script").toString());
            }
            if (body.get("newsType") != null) {
                blockTable.setNewsType(newsTypeTableService.get(Long.valueOf(body.get("newsType").toString())));
            }
            if (body.get("newsNumber") != null) {
                blockTable.setNewsNumber(Integer.valueOf(body.get("newsNumber").toString()));
            }
            if (body.get("poll") != null) {
                blockTable.setPoll(pollTableService.get(Long.valueOf(body.get("poll").toString())));
            }
            if (body.get("fileLibraryType") != null) {
                blockTable.setFileLibraryType(fileLibraryTypeTableService.get(Long.valueOf(body.get("fileLibraryType").toString())));
            }
            if (body.get("fileLibraryNumber") != null) {
                blockTable.setFileLibraryNumber(Integer.valueOf(body.get("fileLibraryNumber").toString()));
            }
            if (body.get("website") != null) {
                blockTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
            }
            this.blockTableService.save(blockTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveBlock(@RequestBody Map<String, Object> body, Principal principal) {
        BlockTable blockTable = new BlockTable();
        if (body.get("name") != null) {
            blockTable.setName(body.get("name").toString());
        }
        if (body.get("type") != null) {
            blockTable.setType(body.get("type").toString());
        }
        if (body.get("content") != null) {
            blockTable.setContent(body.get("content").toString());
        }
        if (body.get("dataUrl") != null) {
            blockTable.setDataUrl(body.get("dataUrl").toString());
        }
        if (body.get("script") != null) {
            blockTable.setScript(body.get("script").toString());
        }
        if (body.get("newsType") != null) {
            blockTable.setNewsType(newsTypeTableService.get(Long.valueOf(body.get("newsType").toString())));
        }
        if (body.get("newsNumber") != null) {
            blockTable.setNewsNumber(Integer.valueOf(body.get("newsNumber").toString()));
        }
        if (body.get("poll") != null) {
            blockTable.setPoll(pollTableService.get(Long.valueOf(body.get("poll").toString())));
        }
        if (body.get("fileLibraryType") != null) {
            blockTable.setFileLibraryType(fileLibraryTypeTableService.get(Long.valueOf(body.get("fileLibraryType").toString())));
        }
        if (body.get("fileLibraryNumber") != null) {
            blockTable.setFileLibraryNumber(Integer.valueOf(body.get("fileLibraryNumber").toString()));
        }
        if (body.get("website") != null) {
            blockTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        this.blockTableService.save(blockTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/options", method = {RequestMethod.GET})
    public List getOptionList(@RequestParam Long websiteId,Principal principal) {
        List<Map> listOptions = null;
        Iterable<BlockTable> list = blockTableService.getListByWebsite(websiteId);
        if (list != null && list.iterator().hasNext()) {
            listOptions = new ArrayList<>();
            for (BlockTable bt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", bt.getName());
                mapOption.put("value", bt.getId());
                listOptions.add(mapOption);
            }
        }
        return listOptions;
    }
}
