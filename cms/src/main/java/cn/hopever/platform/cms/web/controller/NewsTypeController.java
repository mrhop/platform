package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.NewsTypeTable;
import cn.hopever.platform.cms.service.NewsTypeTableService;
import cn.hopever.platform.cms.service.WebsiteTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private NewsTypeTableService newsTypeTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public List getList(@RequestParam Long websiteId, Principal principal) {
        List<HashMap<String, Object>> listReturn = null;
        Iterable<NewsTypeTable> list = newsTypeTableService.getListByWebsites(websiteTableService.getWebsiteAsFilter(principal,websiteId!=null?websiteId.toString():null));
        if (list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (NewsTypeTable ntt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", ntt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                mapTemp.put("value", listTmp);
                listReturn.add(mapTemp);
            }
        }
        return listReturn;
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
            this.newsTypeTableService.get(id);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateNewsType(@RequestBody Map<String,Object> body, Principal principal) {
        if (websiteTableService.validatePermission(principal, newsTypeTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            //this.newsTypeTableService.save()
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveNewsType(@RequestBody Map<String,Object> body, Principal principal) {
        return null;
    }

}
