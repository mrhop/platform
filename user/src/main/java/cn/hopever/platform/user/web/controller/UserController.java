package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.UserTable;
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
                listTmp.add(ut.isEnabled() ? "Y" : "N");
                listTmp.add(ut.isAccountNonExpired() ? "Y" : "N");
                listTmp.add(ut.getCreateUser() != null ? ut.getCreateUser().getUsername() : "");
                listTmp.add(ut.getCreatedDate() != null ? DateFormat.sdf.format(ut.getCreatedDate()) : "");
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
    public void delete(@RequestParam Long id) {
        this.userTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id) {
        //返回user是无法解析的，要使用对象解析为map 的形式
        UserTable ut = this.userTableService.get(id);
        return JacksonUtil.mapper.convertValue(userTableAssembler.toResource(ut), Map.class);
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"),Map.class);
        UserTable user=this.userTableService.get( Long.valueOf(map.get("id").toString()));
        if(body.get("data").get("email")!=null&&!body.get("data").get("email").isNull()){
            UserTable ut = this.userTableService.getUserByEmail(body.get("data").get("email").asText());
            if(ut!=null&&!Long.valueOf(map.get("id").toString()).equals(ut.getId())){
                Map mapReturn = new HashMap<>();
                mapReturn.put("message","用户Email已存在");
                return mapReturn;
            }
            user.setEmail(body.get("data").get("email").asText());
        }else{
            user.setEmail(null);
        }

        if(body.get("data").get("phone")!=null&&!body.get("data").get("phone").isNull()){
            UserTable ut = this.userTableService.getUserByPhone(body.get("data").get("phone").asText());
            if(ut!=null&&!Long.valueOf(map.get("id").toString()).equals(ut.getId())){
                Map mapReturn = new HashMap<>();
                mapReturn.put("message","用户电话号码已存在");
                return mapReturn;
            }
            user.setPhone(body.get("data").get("phone").asText());
        }else{
            user.setPhone(null);
        }
        if(body.get("data").get("authorities")!=null&&!body.get("data").get("authorities").isNull()){
            List list = new ArrayList<>();
            list.add(roleTableService.get(body.get("data").get("authorities").asLong()));
            user.setAuthorities(list);
        }else {
            user.setAuthorities(null);
        }
        if(body.get("data").get("clients")!=null&&!body.get("data").get("clients").isNull()){
            user.setClients(clientTableService.getByIds(JacksonUtil.mapper.convertValue(body.get("data").get("clients"),List.class)));
        }else {
            user.setClients(null);
        }
        if(body.get("data").get("modulesAuthorities")!=null&&!body.get("data").get("modulesAuthorities").isNull()){
            user.setModulesAuthorities(moduleRoleTableService.getByIds(JacksonUtil.mapper.convertValue(body.get("data").get("modulesAuthorities"),List.class)));
        }else {
            user.setModulesAuthorities(null);
        }
        if(body.get("data").get("limitedDate")!=null&&!body.get("data").get("limitedDate").isNull()){
            user.setLimitedDate(new Date(body.get("data").get("limitedDate").asLong()));
        }else{
            user.setLimitedDate(null);
        }
        if(body.get("data").get("name")!=null&&!body.get("data").get("name").isNull()){
            user.setName(body.get("data").get("name").asText());
        }else{
            user.setName(null);
        }
        userTableService.save(user);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('user_admin_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"),Map.class);
        UserTable user=new UserTable();
        if(this.userTableService.getUserByUsername(body.get("data").get("username").asText())!=null){
            Map mapReturn = new HashMap<>();
            mapReturn.put("message","用户账号已存在");
            return mapReturn;
        }
        if(body.get("data").get("email")!=null&&!body.get("data").get("email").isNull()){
            if(this.userTableService.getUserByEmail(body.get("data").get("email").asText())!=null){
                Map mapReturn = new HashMap<>();
                mapReturn.put("message","用户Email已存在");
                return mapReturn;
            }
            user.setEmail(body.get("data").get("email").asText());
        }else{
            user.setEmail(null);
        }

        if(body.get("data").get("phone")!=null&&!body.get("data").get("phone").isNull()){
            if(this.userTableService.getUserByPhone(body.get("data").get("phone").asText())!=null){
                Map mapReturn = new HashMap<>();
                mapReturn.put("message","用户电话号码已存在");
                return mapReturn;
            }
            user.setPhone(body.get("data").get("phone").asText());
        }else{
            user.setPhone(null);
        }

        user.setUsername(body.get("data").get("username").asText());
        user.setPassword(passwordEncoder.encode(body.get("data").get("password").asText()));
        if(body.get("data").get("authorities")!=null&&!body.get("data").get("authorities").isNull()){
            List list = new ArrayList<>();
            list.add(roleTableService.get(body.get("data").get("authorities").asLong()));
            user.setAuthorities(list);
        }else {
            user.setAuthorities(null);
        }
        if(body.get("data").get("clients")!=null&&!body.get("data").get("clients").isNull()){
            user.setClients(clientTableService.getByIds(JacksonUtil.mapper.convertValue(body.get("data").get("clients"),List.class)));
        }else {
            user.setClients(null);
        }
        if(body.get("data").get("modulesAuthorities")!=null&&!body.get("data").get("modulesAuthorities").isNull()){
            user.setModulesAuthorities(moduleRoleTableService.getByIds(JacksonUtil.mapper.convertValue(body.get("data").get("modulesAuthorities"),List.class)));
        }else {
            user.setModulesAuthorities(null);
        }
        if(body.get("data").get("limitedDate")!=null&&!body.get("data").get("limitedDate").isNull()){
            user.setLimitedDate(new Date(body.get("data").get("limitedDate").asLong()));
        }else{
            user.setLimitedDate(null);
        }
        if(body.get("data").get("name")!=null&&!body.get("data").get("name").isNull()){
            user.setName(body.get("data").get("name").asText());
        }else{
            user.setName(null);
        }
        userTableService.save(user);
        return null;
    }
}
