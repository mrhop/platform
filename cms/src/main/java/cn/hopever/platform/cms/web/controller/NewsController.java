package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.NewsTable;
import cn.hopever.platform.cms.domain.NewsTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.service.NewsTableService;
import cn.hopever.platform.cms.service.NewsTypeTableService;
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
@RestController
@RequestMapping(value = "/news", produces = "application/json")
public class NewsController {
    Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private NewsTypeTableService newsTypeTableService;
    @Autowired
    private NewsTableService newsTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<NewsTable> list;
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
        if(filterMap.get("newsType") != null){
            filterMap.put("newsType", newsTypeTableService.get(Long.valueOf(filterMap.get("newsType").toString())));
        }
        if(filterMap.get("website") != null){
            filterMap.put("website", websiteTableService.getWebsiteAsFilter(principal, filterMap.get("website").toString()));
        }
        list = newsTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (NewsTable nt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", nt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(nt.getTitle());
                listTmp.add(nt.getSubtitle());
                listTmp.add(nt.getWebsite()!=null?nt.getWebsite().getTitle():null);
                listTmp.add(nt.getNewsType()!=null?nt.getNewsType().getTitle():null);
                listTmp.add(nt.getClickTimes());
                listTmp.add(nt.isPublished() ? "Y" : "N");
                listTmp.add(nt.getPublishDate() != null ? DateFormat.sdf.format(nt.getPublishDate()) : null);
                listTmp.add(nt.getCreateUser());
                listTmp.add(DateFormat.sdf.format(nt.getCreateDate()));
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
        newsTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        NewsTable nt = newsTableService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", nt.getId());
        map.put("title", nt.getTitle());
        if (nt.getWebsite() != null) {
            map.put("website", nt.getWebsite().getId());
        } else {
            map.put("website", null);
        }
        if (nt.getNewsType() != null) {
            map.put("newsType", nt.getNewsType().getId());
        } else {
            map.put("newsType", null);
        }

        map.put("clickTimes", nt.getClickTimes());
        map.put("isPublished", nt.isPublished());
        map.put("publishDate", nt.getPublishDate());
        map.put("createUser", nt.getCreateUser());
        map.put("createDate", nt.getCreateDate());
        //日期是否需要格式化

        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateNews(@RequestBody Map<String, Object> body, Principal principal) {
        //newsTableService.save();
        long id = Long.valueOf(body.get("id").toString());
        NewsTable newsTable = this.newsTableService.get(id);
        if (body.get("title") != null) {
            newsTable.setTitle(body.get("title").toString());
        }
        if (body.get("subtitle") != null) {
            newsTable.setSubtitle(body.get("subtitle").toString());
        }
        if (body.get("content") != null) {
            newsTable.setContent(body.get("content").toString());
        }
        if (body.get("website") != null) {
            WebsiteTable websiteTable = websiteTableService.get(Long.valueOf(body.get("website").toString()));
            newsTable.setWebsite(websiteTable);
        }
        if (body.get("newsType") != null) {
            NewsTypeTable newsTypeTable = newsTypeTableService.get(Long.valueOf(body.get("newsType").toString()));
            newsTable.setNewsType(newsTypeTable);
        }
        if (body.get("clickTimes") != null) {
            newsTable.setClickTimes(Integer.valueOf(body.get("clickTimes").toString()));
        }
        if (body.get("isPublished") != null && ((List) body.get("isPublished")).size() > 0) {
            newsTable.setPublished(true);
        } else {
            newsTable.setPublished(false);
        }
        if (body.get("publishDate") != null) {
            newsTable.setPublishDate(new Date(Long.valueOf(body.get("publishDate").toString())));
        }
        this.newsTableService.save(newsTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveNews(@RequestBody Map<String, Object> body, Principal principal) {
        //newsTableService.save();
        NewsTable newsTable = new NewsTable();
        if (body.get("title") != null) {
            newsTable.setTitle(body.get("title").toString());
        }
        if (body.get("subtitle") != null) {
            newsTable.setSubtitle(body.get("subtitle").toString());
        }
        if (body.get("content") != null) {
            newsTable.setContent(body.get("content").toString());
        }
        if (body.get("website") != null) {
            WebsiteTable websiteTable = websiteTableService.get(Long.valueOf(body.get("website").toString()));
            newsTable.setWebsite(websiteTable);
        }
        if (body.get("newsType") != null) {
            NewsTypeTable newsTypeTable = newsTypeTableService.get(Long.valueOf(body.get("newsType").toString()));
            newsTable.setNewsType(newsTypeTable);
        }
        if (body.get("clickTimes") != null) {
            newsTable.setClickTimes(Integer.valueOf(body.get("clickTimes").toString()));
        }
        if (body.get("isPublished") != null && ((List) body.get("isPublished")).size() > 0) {
            newsTable.setPublished(true);
        } else {
            newsTable.setPublished(false);
        }
        if (body.get("publishDate") != null) {
            newsTable.setPublishDate(new Date(Long.valueOf(body.get("publishDate").toString())));
        }
        newsTable.setCreateUser(principal.getName());
        newsTable.setCreateDate(new Date());
        this.newsTableService.save(newsTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/preview", method = {RequestMethod.GET})
    public Map preview(@RequestParam Long id, Principal principal) {
        //需要根据resource，news，template等结合获取，并展示
        return null;
    }

}
