package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.ArticleTable;
import cn.hopever.platform.cms.service.ArticleTableService;
import cn.hopever.platform.cms.service.TemplateTableService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/article", produces = "application/json")
public class ArticleController {
    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private TemplateTableService templateTableService;
    @Autowired
    private ArticleTableService articleTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<ArticleTable> list;
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
        filterMap.put("template", filterMap.get("template") != null ? templateTableService.get(Long.valueOf(filterMap.get("template").toString())) : null);
        list = articleTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (ArticleTable at : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", at.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(at.getTitle());
                listTmp.add(at.isPublished() ? "Y" : "F");
                listTmp.add(at.getPublishedDate() != null ? DateFormat.sdf.format(at.getPublishedDate()) : null);
                if (at.getWebsite() != null) {
                    listTmp.add(at.getWebsite().getTitle());
                } else {
                    listTmp.add(null);
                }
                if (at.getTemplate() != null) {
                    listTmp.add(at.getTemplate().getName());
                } else {
                    listTmp.add(null);
                }
                listTmp.add(at.getCreateUser());
                listTmp.add(DateFormat.sdf.format(at.getCreateDate()));
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
        if (websiteTableService.validatePermission(principal, articleTableService.get(id).getWebsite())) {
            this.articleTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, articleTableService.get(id).getWebsite())) {
            ArticleTable at = this.articleTableService.get(id);
            Map<String, Object> map = new HashMap<>();
            map.put("id", at.getId());
            map.put("title", at.getTitle());
            map.put("content", at.getContent());
            map.put("isPublished", at.isPublished());
            if (at.getTemplate() != null) {
                HashMap<String, Object> mapTemplate = new HashMap<>();
                mapTemplate.put("id", at.getTemplate().getId());
                mapTemplate.put("name", at.getTemplate().getName());
                map.put("template", mapTemplate);
            } else {
                map.put("template", null);
            }
            if (at.getWebsite() != null) {
                HashMap<String, Object> mapWebsite = new HashMap<>();
                mapWebsite.put("id", at.getWebsite().getId());
                mapWebsite.put("title", at.getWebsite().getTitle());
                map.put("website", mapWebsite);
            } else {
                map.put("website", null);
            }
            map.put("createUser", at.getCreateUser());
            map.put("createDate", at.getCreateDate());
            return map;
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateArticle(@RequestBody Map<String, Object> body, Principal principal) {
        if (websiteTableService.validatePermission(principal, articleTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            long id = Long.valueOf(body.get("id").toString());
            ArticleTable articleTable = this.articleTableService.get(id);
            if (body.get("title") != null) {
                articleTable.setTitle(body.get("title").toString());
            }
            if (body.get("content") != null) {
                articleTable.setContent(body.get("content").toString());
            }
            if (body.get("isPublished") != null && ((List) body.get("isPublished")).size() > 0) {
                articleTable.setPublished(true);
            } else {
                articleTable.setPublished(false);
            }
            if (body.get("template") != null) {
                articleTable.setTemplate(templateTableService.get(Long.valueOf(body.get("website").toString())));
            }
            if (body.get("website") != null) {
                articleTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
            }
            this.articleTableService.save(articleTable);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveArticle(@RequestBody Map<String, Object> body, Principal principal) {
        ArticleTable articleTable = new ArticleTable();
        if (body.get("title") != null) {
            articleTable.setTitle(body.get("title").toString());
        }
        if (body.get("content") != null) {
            articleTable.setContent(body.get("content").toString());
        }
        if (body.get("isPublished") != null && ((List) body.get("isPublished")).size() > 0) {
            articleTable.setPublished(true);
        } else {
            articleTable.setPublished(false);
        }
        if (body.get("template") != null) {
            articleTable.setTemplate(templateTableService.get(Long.valueOf(body.get("website").toString())));
        }
        if (body.get("website") != null) {
            articleTable.setWebsite(websiteTableService.get(Long.valueOf(body.get("website").toString())));
        }
        this.articleTableService.save(articleTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/preview", method = {RequestMethod.GET})
    public Map preview(@RequestParam Long id, Principal principal) {
        //根据template 获取到，然后进行 article的装配
        return null;
    }
}
