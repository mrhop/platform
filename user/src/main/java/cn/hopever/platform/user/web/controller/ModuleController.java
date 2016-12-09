package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.service.ClientTableService;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import cn.hopever.platform.user.service.ModuleTableService;
import cn.hopever.platform.user.service.RoleTableService;
import cn.hopever.platform.user.web.hateoas.ModuleResourceAssembler;
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
@RequestMapping(value = "/module", produces = "application/json")
public class ModuleController {

    Logger logger = LoggerFactory.getLogger(ModuleController.class);
//    @Autowired
//    private ModuleRoleTableService moduleRoleTableService;

    @Autowired
    private RoleTableService roleTableService;

    @Autowired
    private ClientTableService clientTableService;

    @Autowired
    private ModuleRoleTableService moduleRoleTableService;

    @Autowired
    private ModuleTableService moduleTableService;


    @Autowired
    ModuleResourceAssembler moduleResourceAssembler;


    @PreAuthorize("#oauth2.hasScope('internal_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<ModuleTable> list;
        PageRequest pageRequest;
        //sort部分有一个order的sort，然后有一个name filter parent filter client filter
        //我们新增时，考虑将order的基数*10+自身的order设值，所以order的必然是正确的排序方式
        if (body.get("sort") == null || body.get("sort").isNull()) {
            pageRequest = new PageRequest(body.get("currentPage").asInt(), body.get("rowSize").asInt(), Sort.Direction.ASC, "moduleOrder");
        } else {
            pageRequest = new PageRequest(body.get("currentPage").asInt(), body.get("rowSize").asInt(), Sort.Direction.fromString(body.get("sort").get("sortDirection").textValue()), body.get("sort").get("sortName").textValue());
        }
        Map<String, Object> filterMap = null;
        if (body.get("filters") != null && !body.get("filters").isNull()) {
            filterMap = JacksonUtil.mapper.convertValue(body.get("filters"), Map.class);
        }
        list = moduleTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (ModuleTable mt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", mt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(mt.getModuleName());
                if (mt.getParent() != null) {
                    listTmp.add(mt.getModuleUrl());
                    listTmp.add(mt.getParent().getModuleName());
                } else {
                    listTmp.add("");
                    listTmp.add("");
                }
                if (mt.getClient() != null) {
                    listTmp.add(mt.getClient().getClientName());
                } else {
                    listTmp.add("");
                }
                listTmp.add(mt.isActivated() ? "T" : "F");
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
        //do info update
        ModuleTable mt = moduleTableService.getById(id);
        Map map = JacksonUtil.mapper.convertValue(moduleResourceAssembler.toResource(mt), Map.class);
        boolean isTop = (mt.getParent() == null && mt.getModuleUrl() == null && mt.getIconClass() != null) ? true : false;
        map.put("isTop", isTop);
        if (isTop) {
            map.put("moduleOrder", ((Integer) map.get("moduleOrder")) / 100);
        } else {
            map.put("moduleOrder", ((Integer) map.get("moduleOrder")) % 100);
        }
        return map;
    }


    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"), Map.class);
        ModuleTable mt = moduleTableService.getById(Long.valueOf(map.get("id").toString()));
        ModuleTable mtParent = null;
        mt.setModuleName(map.get("moduleName").toString());
        ClientTable ct = this.clientTableService.getById(Long.valueOf(map.get("client").toString()));
        mt.setClient(this.clientTableService.getById(Long.valueOf(map.get("client").toString())));
        if (map.get("authorities") != null) {
            List list = (List) map.get("authorities");
            List<ModuleRoleTable> listMr = new ArrayList<>();
            for (Object id : list) {
                listMr.add(moduleRoleTableService.getById(Long.valueOf(id.toString())));
            }
            mt.setAuthorities(listMr);
        }
        if (map.get("isTop") != null && map.get("isTop").equals("Y")) {
            mt.setParent(null);
            mt.setModuleUrl(null);
            mt.setIconClass(map.get("iconClass").toString());
            if (mt.getChildren() != null) {
                for (ModuleTable mtChild : mt.getChildren()) {
                    mtChild.setClient(ct);
                }
            }
        } else {
            if (map.get("parent") != null) {
                mtParent = moduleTableService.getById(Long.valueOf(map.get("parent").toString()));
                mt.setParent(mtParent);
            }
            if (map.get("moduleUrl") != null) {
                mt.setModuleUrl(map.get("moduleUrl").toString());
            }
            mt.setIconClass(null);
        }
        if (map.get("moduleOrder") != null) {
            if (map.get("isTop") != null) {
                mt.setModuleOrder(Integer.valueOf(map.get("moduleOrder").toString()) * 100);
            } else {
                if (map.get("parent") != null) {
                    mt.setModuleOrder(mtParent.getModuleOrder() + Integer.valueOf(map.get("moduleOrder").toString()));
                } else {
                    mt.setModuleOrder(null);
                }
            }
        }
        if (map.get("available") != null) {
            mt.setAvailable(true);
        } else {
            mt.setAvailable(false);
        }
        if (map.get("activated") != null) {
            mt.setActivated(true);
        } else {
            mt.setActivated(false);
        }
        //针对module设置对应的值
        moduleTableService.save(mt);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"), Map.class);
        ModuleTable mt = new ModuleTable();
        //对module的值进行设置，module name可以重复
        mt.setModuleName(map.get("moduleName").toString());
        mt.setClient(this.clientTableService.getById(Long.valueOf(map.get("client").toString())));
        if (map.get("authorities") != null) {
            List list = (List) map.get("authorities");
            List<ModuleRoleTable> listMr = new ArrayList<>();
            for (Object id : list) {
                listMr.add(moduleRoleTableService.getById(Long.valueOf(id.toString())));
            }
            mt.setAuthorities(listMr);
        }
        if (map.get("isTop") != null) {
            mt.setParent(null);
            mt.setModuleUrl(null);
            mt.setIconClass(map.get("iconClass").toString());
        } else {
            if (map.get("parent") != null) {
                mt.setParent(moduleTableService.getById(Long.valueOf(map.get("parent").toString())));
            }
            if (map.get("moduleUrl") != null) {
                mt.setModuleUrl(map.get("moduleUrl").toString());
            }
            mt.setIconClass(null);
        }
        if (map.get("moduleOrder") != null) {
            if (map.get("isTop") != null) {
                mt.setModuleOrder(Integer.valueOf(map.get("moduleOrder").toString()) * 100);
            } else {
                if (map.get("parent") != null) {
                    ModuleTable mtParent = moduleTableService.getById(Long.valueOf(map.get("parent").toString()));
                    mt.setModuleOrder(mtParent.getModuleOrder() + Integer.valueOf(map.get("moduleOrder").toString()));
                } else {
                    mt.setModuleOrder(null);
                }
            }
        }
        if (map.get("available") != null) {
            mt.setAvailable(true);
        } else {
            mt.setAvailable(false);
        }
        if (map.get("activated") != null) {
            mt.setActivated(true);
        } else {
            mt.setActivated(false);
        }
        moduleTableService.save(mt);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        this.moduleTableService.deleteById(id);
    }


    @PreAuthorize("#oauth2.hasScope('internal_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/list/parent/options", method = {RequestMethod.GET})
    public List getListOptions() {
        //应该根据client获取对应的options，如果没有client，则不进行返回！！！
        List<Map> listOptions = null;
        List<ModuleTable> list = moduleTableService.getParentList();
        if (list != null && list.size() > 0) {
            listOptions = new ArrayList<>();
            for (ModuleTable mt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", mt.getModuleName());
                mapOption.put("value", mt.getId());
                listOptions.add(mapOption);
            }
        }
        return listOptions;
    }


    @PreAuthorize("#oauth2.hasScope('internal_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/list/parent/client/options", method = {RequestMethod.POST})
    public Map getListOptionsOfclient(@RequestBody JsonNode body, Principal principal) {
        Map mapReturn = null;
        List listOptions = null;
        Long selected = null;
        ClientTable ct = clientTableService.getById(body.get("clientId").asLong());
        List<ModuleTable> list = moduleTableService.getParentListByClient(ct);
        if (list != null && list.size() > 0) {
            listOptions = new ArrayList<>();
            for (ModuleTable mt : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", mt.getModuleName());
                mapOption.put("value", mt.getId());
                listOptions.add(mapOption);
            }
        }
        if (body.get("moduleId") != null && !body.get("moduleId").isNull()) {
            Long moduleId = body.get("moduleId").asLong();
            ModuleTable mt = this.moduleTableService.getById(moduleId);
            if (mt.getParent() != null && list.contains(mt.getParent())) {
                selected = mt.getParent().getId();
            }
        }
        if (listOptions != null) {
            mapReturn = new HashMap<>();
            mapReturn.put("items", listOptions);
            mapReturn.put("defaultValue", selected);
        }
        return mapReturn;
    }

}
