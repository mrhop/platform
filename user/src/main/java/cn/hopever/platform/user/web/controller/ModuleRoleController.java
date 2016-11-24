package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import cn.hopever.platform.user.service.RoleTableService;
import cn.hopever.platform.utils.json.JacksonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/11/14.
 */
@RestController
@RequestMapping(value = "/modulerole", produces = "application/json")
public class ModuleRoleController {

    Logger logger = LoggerFactory.getLogger(ModuleRoleController.class);
    @Autowired
    private ModuleRoleTableService moduleRoleTableService;

    @Autowired
    private RoleTableService roleTableService;


    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list/options", method = {RequestMethod.POST})
    public Map getListOptions(@RequestBody JsonNode body, Principal principal) {
        Map mapReturn = null;
        List listOptions = null;
        List listOptionsSelected = null;
        RoleTable roleTable = roleTableService.get(body.get("roleId").asLong());
        String authority = roleTable.getAuthority();
        if ("ROLE_common_user".equals(authority)) {
            List<ModuleRoleTable> list = moduleRoleTableService.getByClients(JacksonUtil.mapper.convertValue(body.get("clientIds"), List.class));
            if (list.size() > 0) {
                listOptions = new ArrayList<>();
                for (ModuleRoleTable mrt : list) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", mrt.getName());
                    mapOption.put("value", mrt.getId());
                    listOptions.add(mapOption);
                }
            }
            Long userId = null;
            if (body.get("userId") != null && !body.get("userId").isNull()) {
                userId = body.get("userId").asLong();
            }
            List<ModuleRoleTable> listSelected = null;
            if (userId != null) {
                listSelected = moduleRoleTableService.getByUserId(userId);
            }
            if (listSelected != null && listSelected.size() > 0) {
                listOptionsSelected = new ArrayList<>();
                for (ModuleRoleTable mrt : listSelected) {
                    listOptionsSelected.add(mrt.getId());
                }
            }
            if (listOptions != null) {
                mapReturn = new HashMap<>();
                mapReturn.put("moduleRoles", listOptions);
                mapReturn.put("moduleRolesSelected", listOptionsSelected);
            }
        }
        return mapReturn;
    }
}
