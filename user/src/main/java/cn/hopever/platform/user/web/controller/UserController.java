package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.resources.UserResource;
import cn.hopever.platform.user.service.ClientTableService;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import cn.hopever.platform.user.service.RoleTableService;
import cn.hopever.platform.user.service.UserTableService;
import cn.hopever.platform.user.web.hateoas.UserResourceAssembler;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserTableService userTableService;
    @Autowired
    private RoleTableService roleTableService;
    @Autowired
    private ClientTableService clientTableService;
    @Autowired
    private ModuleRoleTableService moduleRoleTableService;
    @Autowired
    private UserResourceAssembler userTableAssembler;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        Page<UserTable> list;
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
        if ("ROLE_super_admin".equals(authority)) {
            list = userTableService.getListWithOutSelf(principal.getName(), pageRequest, filterMap);
        } else {
            list = userTableService.getSubList(principal.getName(), pageRequest, filterMap);
        }
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (UserTable ut : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", ut.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(ut.getUsername());
                listTmp.add(ut.getName());
                listTmp.add(ut.getEmail());
                listTmp.add(ut.getPhone());
                listTmp.add(ut.getCreateUser() != null ? ut.getCreateUser().getUsername() : "");
                listTmp.add(ut.getCreatedDate() != null ? DateFormat.sdfDate.format(ut.getCreatedDate()) : "");
                listTmp.add(ut.isEnabled() ? "Y" : "N");
                listTmp.add(ut.isAccountNonExpired() ? "Y" : "N");
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

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        if (validateUserOperation(userTableService.getUserByUsername(principal.getName()), this.userTableService.get(id))) {
            this.userTableService.delete(id);
        }
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        //返回user是无法解析的，要使用对象解析为map 的形式
        UserTable ut = userTableService.get(id);
        UserResource ur = userTableAssembler.toResource(ut);
        ur.setPhoto(null);
        if (validateUserOperation(userTableService.getUserByUsername(principal.getName()), ut)) {
            return JacksonUtil.mapper.convertValue(ur, Map.class);
        } else {
            return null;
        }
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client')")
    @RequestMapping(value = {"/", ""}, method = {RequestMethod.GET})
    public Map info(Principal principal) {
        //返回user是无法解析的，要使用对象解析为map 的形式
        UserTable ut = this.userTableService.getUserByUsername(principal.getName());
        UserResource ur = userTableAssembler.toResource(ut);
        ur.setPhoto(null);
        return JacksonUtil.mapper.convertValue(ur, Map.class);
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client')")
    @RequestMapping(value = "/personal/update", method = {RequestMethod.POST})
    public Map updatePersonalUser(@RequestBody Map<String,Object> body, Principal principal) {
        long id = Long.valueOf(body.get("id").toString());
        UserTable user = this.userTableService.get(id);
        if (body.get("email") != null) {
            UserTable ut = this.userTableService.getUserByEmail(body.get("email").toString());
            if (ut != null && id !=ut.getId()) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "用户Email已存在");
                return mapReturn;
            }
            user.setEmail(body.get("email").toString());
        }

        if (body.get("phone") != null) {
            UserTable ut = this.userTableService.getUserByPhone(body.get("phone").toString());
            if (ut != null && id !=ut.getId()) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "用户电话号码已存在");
                return mapReturn;
            }
            user.setPhone(body.get("phone").toString());
        }
        if (body.get("name") != null) {
            user.setName(body.get("name").toString());
        }
        if (body.get("password") != null) {
            user.setPassword(passwordEncoder.encode(body.get("password").toString()));
        }
        if (body.get("photo") != null) {
            user.setPhoto(body.get("photo").toString());
        }
        userTableService.save(user);
        return null;
    }


    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateUser(@RequestBody Map<String,Object> body, Principal principal) {
        UserTable userController = userTableService.getUserByUsername(principal.getName());
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        long id = Long.valueOf(body.get("id").toString());
        UserTable user = userTableService.get(id);
        if (!validateUserOperation(userController, user)) {
            Map mapReturn = new HashMap<>();
            mapReturn.put("message", "无权限修改该用户");
            return mapReturn;
        }
        if (body.get("email") != null) {
            UserTable ut = this.userTableService.getUserByEmail(body.get("email").toString());
            if (ut != null && ut.getId() != id) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "用户Email已存在");
                return mapReturn;
            }
            user.setEmail(body.get("email").toString());
        }
        if (body.get("phone") != null) {
            UserTable ut = this.userTableService.getUserByPhone(body.get("phone").toString());
            if (ut != null && ut.getId() != id) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "用户电话号码已存在");
                return mapReturn;
            }
            user.setPhone(body.get("phone").toString());
        }
        if (body.get("authorities") != null) {
            List list = new ArrayList<>();
            list.add(roleTableService.get(Long.valueOf(body.get("authorities").toString())));
            user.setAuthorities(list);
        } else {
            user.setAuthorities(null);
        }
        List listPartClients = new ArrayList<>();
        listPartClients.add(clientTableService.loadClientByClientId("user_admin_client"));
        if (user.getClients() != null) {
            for (ClientTable ct : user.getClients()) {
                if (userController.getClients() != null && !authority.equals("ROLE_super_admin") && !userController.getClients().contains(ct)) {
                    listPartClients.add(ct);
                }
            }
        }
        if (body.get("clients") != null) {
            listPartClients.addAll(clientTableService.getByIds((List<Object>) body.get("clients")));
        }
        user.setClients(listPartClients);

        List<ModuleRoleTable> listPartModileRoles = user.getModulesAuthorities();
        if (userController.getClients() != null && listPartModileRoles != null && listPartModileRoles.size() > 0) {
            for (ClientTable ct : userController.getClients()) {
                List<ModuleRoleTable> moduleRoles = ct.getModuleRoles();
                if (moduleRoles != null) {
                    for (ModuleRoleTable mr : moduleRoles) {
                        listPartModileRoles.remove(mr);
                    }
                }
            }
        }
        if (body.get("modulesAuthorities") != null) {
            listPartModileRoles.addAll(moduleRoleTableService.getByIds((List<Object>) body.get("modulesAuthorities")));
        }
        user.setModulesAuthorities(listPartModileRoles);
        if (body.get("limitedDate") != null) {
            user.setLimitedDate(new Date(Long.valueOf(body.get("limitedDate").toString())));
        } else {
            user.setLimitedDate(null);
        }
        if (body.get("name") != null) {
            user.setName(body.get("name").toString());
        }
        if (body.get("password") != null) {
            user.setPassword(passwordEncoder.encode(body.get("password").toString()));
        }
        if (body.get("photo") != null) {
            user.setPhoto(body.get("photo").toString());
        }
        userTableService.save(user);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveUser(@RequestBody Map<String,Object> body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"), Map.class);
        UserTable user = new UserTable();
        if (this.userTableService.getUserByUsername(body.get("username").toString()) != null) {
            Map mapReturn = new HashMap<>();
            mapReturn.put("message", "用户账号已存在");
            return mapReturn;
        }
        if (body.get("email") != null) {
            if (this.userTableService.getUserByEmail(body.get("email").toString()) != null) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "用户Email已存在");
                return mapReturn;
            }
            user.setEmail(body.get("email").toString());
        } else {
            user.setEmail(null);
        }

        if (body.get("phone") != null) {
            if (this.userTableService.getUserByPhone(body.get("phone").toString()) != null) {
                Map mapReturn = new HashMap<>();
                mapReturn.put("message", "用户电话号码已存在");
                return mapReturn;
            }
            user.setPhone(body.get("phone").toString());
        } else {
            user.setPhone(null);
        }

        user.setUsername(body.get("username").toString());
        user.setPassword(passwordEncoder.encode(body.get("password").toString()));
        if (body.get("authorities") != null) {
            List list = new ArrayList<>();
            list.add(roleTableService.get(Long.valueOf(body.get("authorities").toString())));
            user.setAuthorities(list);
        } else {
            user.setAuthorities(null);
        }
        List clientsUpdate = new ArrayList<>();
        clientsUpdate.add(clientTableService.loadClientByClientId("user_admin_client"));
        if (body.get("clients") != null) {
            clientTableService.getByIds((List<Object>)body.get("clients"));
            clientsUpdate.addAll(clientTableService.getByIds((List<Object>)body.get("clients")));
        }
        user.setClients(clientsUpdate);
        if (body.get("modulesAuthorities") != null) {
            user.setModulesAuthorities(moduleRoleTableService.getByIds((List<Object>)body.get("modulesAuthorities")));
        } else {
            user.setModulesAuthorities(null);
        }
        if (body.get("limitedDate") != null ) {
            user.setLimitedDate(new Date(Long.valueOf(body.get("limitedDate").toString())));
        } else {
            user.setLimitedDate(null);
        }
        if (body.get("name") != null) {
            user.setName(body.get("name").toString());
        } else {
            user.setName(null);
        }
        if (body.get("photo") != null) {
            user.setPhoto(body.get("photo").toString());
        }
        user.setCreatedDate(new Date());
        user.setCreateUser(this.userTableService.getUserByUsername(principal.getName()));
        userTableService.save(user);
        return null;
    }

    private static boolean validateUserOperation(UserTable ut1, UserTable ut2) {
        if (ut1.getAuthorities().get(0).getAuthority().equals("ROLE_super_admin")) {
            return true;
        } else {
            if (ut1.getAuthorities().get(0).getAuthority().equals("ROLE_admin") && ut2.getAuthorities().get(0).getAuthority().equals("ROLE_admin")) {
                if (ut2.getCreateUser() != null && ut2.getCreateUser().getId() == ut1.getId()) {
                    return true;
                }
            } else if (ut1.getAuthorities().get(0).getAuthority().equals("ROLE_admin") && ut2.getAuthorities().get(0).getAuthority().equals("ROLE_common_user")) {
                if (ut1.getClients() != null) {
                    for (ClientTable ct : ut1.getClients()) {
                        if (ct.getClientId().equals("user_admin_client")) {
                            continue;
                        }
                        if (ut2.getClients() != null && ut2.getClients().contains(ct)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
