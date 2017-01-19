package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.NewsTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.service.NewsTypeTableService;
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
@RequestMapping(value = "/newstype", produces = "application/json")
public class NewsTypeController {
    Logger logger = LoggerFactory.getLogger(NewsTypeController.class);
    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private TemplateTableService templateTableService;
    @Autowired
    private NewsTypeTableService newsTypeTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {

        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<NewsTypeTable> list;
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
        list = newsTypeTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (NewsTypeTable ntt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", ntt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(ntt.getTitle());
                if (ntt.getNewsListTemplate() != null) {
                    listTmp.add(ntt.getNewsListTemplate().getName());
                } else {
                    listTmp.add(null);
                }
                if (ntt.getNewsTemplate() != null) {
                    listTmp.add(ntt.getNewsTemplate().getName());
                } else {
                    listTmp.add(null);
                }
                if (ntt.getWebsite() != null) {
                    listTmp.add(ntt.getWebsite().getTitle());
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
    @RequestMapping(value = "/options/bywebsite", method = {RequestMethod.GET})
    public List optionsofwebsite(@RequestParam Long websiteId, Principal principal) {
        List<Map> listOptions = null;
        List<WebsiteTable> listWebsite = new ArrayList<>();
        listWebsite.add(websiteTableService.get(websiteId));
        List<NewsTypeTable> list = newsTypeTableService.getListByWebsites(listWebsite);
        if (list != null && list.size() > 0) {
            listOptions = new ArrayList<>();
            for (NewsTypeTable ntt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", ntt.getTitle());
                mapOption.put("value", ntt.getId());
                listOptions.add(mapOption);
            }
        }
        return listOptions;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限
        if (websiteTableService.validatePermission(principal, newsTypeTableService.get(id).getWebsite())) {
            this.newsTypeTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, newsTypeTableService.get(id).getWebsite())) {
            NewsTypeTable ntt = this.newsTypeTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", ntt.getId());
            map.put("title", ntt.getTitle());
            if (ntt.getWebsite() != null) {
                map.put("website", ntt.getWebsite().getId());
            } else {
                map.put("website", null);
            }
            if (ntt.getNewsListTemplate() != null) {
                map.put("newsListTemplate", ntt.getNewsListTemplate().getId());
            } else {
                map.put("newsListTemplate", null);
            }
            if (ntt.getNewsTemplate() != null) {
                map.put("newsTemplate", ntt.getNewsTemplate().getId());
            } else {
                map.put("newsTemplate", null);
            }
            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateNewsType(@RequestBody Map<String, Object> bodyOriginal, Principal principal) {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        if (websiteTableService.validatePermission(principal, newsTypeTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            //this.newsTypeTableService.save()
            long id = Long.valueOf(body.get("id").toString());
            NewsTypeTable newsTypeTable = this.newsTypeTableService.get(id);
            if (body.get("title") != null) {
                newsTypeTable.setTitle(body.get("title").toString());
            }
            if (body.get("newsListTemplate") != null) {
                newsTypeTable.setNewsListTemplate(templateTableService.get(Long.valueOf(body.get("newsListTemplate").toString())));
            }
            if (body.get("newsTemplate") != null) {
                newsTypeTable.setNewsTemplate(templateTableService.get(Long.valueOf(body.get("newsTemplate").toString())));
            }
            if (body.get("website") != null) {
                newsTypeTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
            }
            this.newsTypeTableService.save(newsTypeTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveNewsType(@RequestBody Map<String, Object> bodyOriginal, Principal principal) {
        Map body = JacksonUtil.mapper.convertValue(bodyOriginal.get("data"), Map.class);
        NewsTypeTable newsTypeTable = new NewsTypeTable();
        if (body.get("title") != null) {
            newsTypeTable.setTitle(body.get("title").toString());
        }
        if (body.get("newsListTemplate") != null) {
            newsTypeTable.setNewsListTemplate(templateTableService.get(Long.valueOf(body.get("newsListTemplate").toString())));
        }
        if (body.get("newsTemplate") != null) {
            newsTypeTable.setNewsTemplate(templateTableService.get(Long.valueOf(body.get("newsTemplate").toString())));
        }
        if (body.get("website") != null) {
            newsTypeTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        this.newsTypeTableService.save(newsTypeTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/preview", method = {RequestMethod.GET})
    public Map preview(@RequestParam Long id, Principal principal) {
        //需要根据resource，news，template等结合获取，并展示
        return null;
    }
}
