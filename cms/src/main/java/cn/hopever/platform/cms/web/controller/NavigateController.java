package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.NavigateTable;
import cn.hopever.platform.cms.service.ArticleTableService;
import cn.hopever.platform.cms.service.NavigateTableService;
import cn.hopever.platform.cms.service.NewsTypeTableService;
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
@RequestMapping(value = "/navigate", produces = "application/json")
public class NavigateController {
    Logger logger = LoggerFactory.getLogger(NavigateController.class);
    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private NewsTypeTableService newsTypeTableService;
    @Autowired
    private ArticleTableService articleTableService;
    @Autowired
    private NavigateTableService navigateTableService;

    //NAVIGATE 需要一个生成tree的方式，用于选取parent的时候使用和前端生成json 对象的时候处理，使用block来对生成的json数据进行js处理和重塑


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<NavigateTable> list;
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
        filterMap.put("parent",filterMap.get("parent") != null?navigateTableService.get(Long.valueOf(filterMap.get("parent").toString())):null);
        list = navigateTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (NavigateTable nt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", nt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(nt.getTitle());
                if (nt.getParent() != null) {
                    listTmp.add(nt.getParent().getTitle());
                } else {
                    listTmp.add(null);
                }
                listTmp.add(nt.getLevel());
                listTmp.add(nt.getType());
                if (nt.getArticle() != null) {
                    listTmp.add(nt.getArticle().getTitle());
                } else {
                    listTmp.add(null);
                }
                if (nt.getNewsType() != null) {
                    listTmp.add(nt.getNewsType().getTitle());
                } else {
                    listTmp.add(null);
                }
                if (nt.getWebsite() != null) {
                    listTmp.add(nt.getWebsite().getTitle());
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
        if (websiteTableService.validatePermission(principal, navigateTableService.get(id).getWebsite())) {
            this.navigateTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, navigateTableService.get(id).getWebsite())) {
            this.navigateTableService.get(id);
            NavigateTable nt = this.navigateTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", nt.getId());
            map.put("title", nt.getTitle());
            map.put("level", nt.getLevel());
            map.put("orderNum", nt.getOrderNum());
            map.put("type", nt.getType());
            if (nt.getArticle() != null) {
                HashMap<String, Object> mapArticle = new HashMap<>();
                mapArticle.put("id",nt.getArticle().getId());
                mapArticle.put("title",nt.getArticle().getTitle());
                map.put("article", mapArticle);
            } else {
                map.put("article", null);
            }
            if (nt.getNewsType() != null) {
                HashMap<String, Object> mapNewsType = new HashMap<>();
                mapNewsType.put("id",nt.getNewsType().getId());
                mapNewsType.put("title",nt.getNewsType().getTitle());
                map.put("newsType", mapNewsType);
            } else {
                map.put("newsType", null);
            }
            if(nt.getWebsite()!=null){
                HashMap<String, Object> mapWebsite = new HashMap<>();
                mapWebsite.put("id",nt.getWebsite().getId());
                mapWebsite.put("title",nt.getWebsite().getTitle());
                map.put("website", mapWebsite);
            }else{
                map.put("website", null);
            }
            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateNavigate(@RequestBody Map<String,Object> body, Principal principal) {
        if (websiteTableService.validatePermission(principal, navigateTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            long id = Long.valueOf(body.get("id").toString());
            NavigateTable navigateTable = this.navigateTableService.get(id);
            if (body.get("title") != null) {
                navigateTable.setTitle(body.get("title").toString());
            }
            if (body.get("parent") != null) {
                navigateTable.setParent(navigateTableService.get(Long.valueOf(body.get("parent").toString())));
            }
            if (body.get("level") != null) {
                navigateTable.setOrderNum(Integer.valueOf(body.get("level").toString()));
            }
            if (body.get("orderNum") != null) {
                navigateTable.setOrderNum(Integer.valueOf(body.get("orderNum").toString()));
            }
            if (body.get("type") != null) {
                navigateTable.setOrderNum(Integer.valueOf(body.get("type").toString()));
            }
            if (body.get("article") != null) {
                navigateTable.setArticle(articleTableService.get(Long.valueOf(body.get("article").toString())));
            }
            if (body.get("newsType") != null) {
                navigateTable.setNewsType(newsTypeTableService.get(Long.valueOf(body.get("newsType").toString())));
            }
            this.navigateTableService.save(navigateTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveNavigate(@RequestBody Map<String,Object> body, Principal principal) {
        NavigateTable navigateTable = new NavigateTable();
        if (body.get("title") != null) {
            navigateTable.setTitle(body.get("title").toString());
        }
        if (body.get("parent") != null) {
            navigateTable.setParent(navigateTableService.get(Long.valueOf(body.get("parent").toString())));
        }
        if (body.get("level") != null) {
            navigateTable.setOrderNum(Integer.valueOf(body.get("level").toString()));
        }
        if (body.get("orderNum") != null) {
            navigateTable.setOrderNum(Integer.valueOf(body.get("orderNum").toString()));
        }
        if (body.get("type") != null) {
            navigateTable.setOrderNum(Integer.valueOf(body.get("type").toString()));
        }
        if (body.get("article") != null) {
            navigateTable.setArticle(articleTableService.get(Long.valueOf(body.get("article").toString())));
        }
        if (body.get("newsType") != null) {
            navigateTable.setNewsType(newsTypeTableService.get(Long.valueOf(body.get("newsType").toString())));
        }
        this.navigateTableService.save(navigateTable);
        return null;
    }
}
