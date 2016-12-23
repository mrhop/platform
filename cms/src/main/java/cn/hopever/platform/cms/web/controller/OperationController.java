package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.service.OperationTableService;
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
//操作表只有管理员可用
@RestController
@RequestMapping(value = "/operation", produces = "application/json")
public class OperationController {
    Logger logger = LoggerFactory.getLogger(OperationController.class);
    @Autowired
    private OperationTableService operationTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限

    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateOperation(@RequestBody Map<String,Object> body, Principal principal) {
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveOperation(@RequestBody Map<String,Object> body, Principal principal) {
        return null;
    }

}
