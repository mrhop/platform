package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.service.ClientTableService;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import cn.hopever.platform.user.service.RoleTableService;
import cn.hopever.platform.user.web.hateoas.ModuleRoleResourceAssembler;
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

    @Autowired
    private ClientTableService clientTableService;

    @Autowired
    ModuleRoleResourceAssembler moduleRoleResourceAssembler;


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
            Long userId = null;
            if (body.get("userId") != null && !body.get("userId").isNull()) {
                userId = body.get("userId").asLong();
            }
            List<ModuleRoleTable> listSelected = null;
            List<ModuleRoleTable> listSelectedUpdate = new ArrayList<>();
            if (userId != null) {
                listSelected = moduleRoleTableService.getByUserId(userId);
            }
            if (list.size() > 0) {
                listOptions = new ArrayList<>();
                for (ModuleRoleTable mrt : list) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", mrt.getName());
                    mapOption.put("value", mrt.getId());
                    listOptions.add(mapOption);
                    if (listSelected != null && listSelected.contains(mrt)) {
                        listSelectedUpdate.add(mrt);
                    }
                }
            }

            if (listSelectedUpdate.size() > 0) {
                listOptionsSelected = new ArrayList<>();
                for (ModuleRoleTable mrt : listSelectedUpdate) {
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


    @PreAuthorize("#oauth2.hasScope('internal_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<ModuleRoleTable> list;
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
        list = moduleRoleTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (ModuleRoleTable mrt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", mrt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(mrt.getAuthority());
                listTmp.add(mrt.getName());
                listTmp.add(mrt.getClient().getClientName());
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

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        //返回user是无法解析的，要使用对象解析为map 的形式
        ModuleRoleTable mrt = moduleRoleTableService.getById(id);
        return JacksonUtil.mapper.convertValue(moduleRoleResourceAssembler.toResource(mrt), Map.class);
    }


    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"), Map.class);
        ModuleRoleTable mrt = moduleRoleTableService.getById(Long.valueOf(map.get("id").toString()));

        if (body.get("data").get("client") != null && !body.get("data").get("client").isNull()) {
            mrt.setClient(clientTableService.getById(body.get("data").get("client").asLong()));
        }
        if (body.get("data").get("name") != null && !body.get("data").get("name").isNull()) {
            mrt.setName(body.get("data").get("name").asText());
        }
        moduleRoleTableService.save(mrt);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"), Map.class);
        ModuleRoleTable mrt = new ModuleRoleTable();
        if (body.get("data").get("authority") != null && !body.get("data").get("authority").isNull()) {
            if (moduleRoleTableService.getByAuthority(body.get("data").get("authority").asText()) != null) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "模块角色code已存在");
                return mapReturn;
            }
            mrt.setAuthority(body.get("data").get("authority").asText());
        }
        if (body.get("data").get("client") != null && !body.get("data").get("client").isNull()) {
            mrt.setClient(clientTableService.getById(body.get("data").get("client").asLong()));
        }
        if (body.get("data").get("name") != null && !body.get("data").get("name").isNull()) {
            mrt.setName(body.get("data").get("name").textValue());
        }
        mrt.setLevel((short) 0);
        moduleRoleTableService.save(mrt);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        this.moduleRoleTableService.deleteById(id);
    }
}
