package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;
import cn.hopever.platform.cms.service.FileLibraryTypeTableService;
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
@RequestMapping(value = "/filelibrarytype", produces = "application/json")
public class FileLibraryTypeController {
    Logger logger = LoggerFactory.getLogger(FileLibraryTypeController.class);
    @Autowired
    private WebsiteTableService websiteTableService;
    @Autowired
    private FileLibraryTypeTableService fileLibraryTypeTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public List getList(@RequestParam Long websiteId, Principal principal) {
        List<HashMap<String, Object>> listReturn = null;
        Iterable<FileLibraryTypeTable> list = fileLibraryTypeTableService.getListByWebsites(websiteTableService.getWebsiteAsFilter(principal,websiteId!=null?websiteId.toString():null));
        if (list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (FileLibraryTypeTable fltt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", fltt.getId());
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
        if (websiteTableService.validatePermission(principal, fileLibraryTypeTableService.get(id).getWebsite())) {
            this.fileLibraryTypeTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        if (websiteTableService.validatePermission(principal, fileLibraryTypeTableService.get(id).getWebsite())) {
            this.fileLibraryTypeTableService.get(id);
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateFileLibraryType(@RequestBody Map<String,Object> body, Principal principal) {
        if (websiteTableService.validatePermission(principal, fileLibraryTypeTableService.get(Long.valueOf(body.get("id").toString())).getWebsite())) {
            //do update
            //this.fileLibraryTypeTableService.save()
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveFileLibraryType(@RequestBody Map<String,Object> body, Principal principal) {
        return null;
    }
}
