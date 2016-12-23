package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.service.TemplateTableService;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/template", produces = "application/json")
public class TemplateController {
    Logger logger = LoggerFactory.getLogger(TemplateController.class);
    @Autowired
    private TemplateTableService templateTableService;


    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限

    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/preview", method = {RequestMethod.GET})
    public Map preview(@RequestParam Long id, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateTemplate(@RequestBody Map<String,Object> body, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveTemplate(@RequestBody Map<String,Object> body, Principal principal) {
        return null;
    }
}
