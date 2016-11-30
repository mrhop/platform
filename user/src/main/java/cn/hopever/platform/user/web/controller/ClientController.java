package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.ClientRoleTable;
import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.service.ClientRoleTableService;
import cn.hopever.platform.user.service.ClientTableService;
import cn.hopever.platform.user.service.RoleTableService;
import cn.hopever.platform.user.web.hateoas.ClientResourceAssembler;
import cn.hopever.platform.utils.json.JacksonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/client", produces = "application/json")
public class ClientController {
    Logger logger = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientTableService clientTableService;

    @Autowired
    private ClientRoleTableService clientRoleTableService;

    @Autowired
    private RoleTableService roleTableService;

    @Autowired
    private ClientResourceAssembler clientResourceAssembler;


    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list/options", method = {RequestMethod.POST})
    public Map getListOptions(@RequestBody JsonNode body, Principal principal) {
        Map mapReturn = null;
        List listOptions = null;
        List listOptionsSelected = null;
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        Long roleId = body.get("roleId").asLong();
        RoleTable rt = roleTableService.get(roleId);
        String roleName = rt != null ? rt.getAuthority() : null;
        Long userId = null;
        if (body.get("userId") != null && !body.get("userId").isNull()) {
            userId = body.get("userId").asLong();
        }
        Iterable<ClientTable> list = null;
        List<ClientTable> listSelected = null;
        List<ClientTable> listSelectedUpdated = new ArrayList<>();
        //然后根据roleName
        if ("ROLE_admin".equals(roleName) || "ROLE_common_user".equals(roleName)) {
            //do the get
            if (authority.equals("ROLE_super_admin")) {
                //get all client
                list = clientTableService.getAll();
            } else {
                list = clientTableService.getByUserName(principal.getName());
            }
            if (userId != null) {
                listSelected = clientTableService.getByUserId(userId);
            }
        }
        if (list != null && list.iterator().hasNext()) {
            listOptions = new ArrayList<>();
            for (ClientTable ct : list) {
                if (!"user_admin_client".equals(ct.getClientId())) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", ct.getClientName());
                    mapOption.put("value", ct.getId());
                    listOptions.add(mapOption);
                    if (listSelected != null && listSelected.contains(ct)) {
                        listSelectedUpdated.add(ct);
                    }
                }
            }
        }

        if (listSelectedUpdated.size() > 0) {
            listOptionsSelected = new ArrayList<>();
            for (ClientTable ct : listSelectedUpdated) {
                for (ClientTable ctOption : list) {
                }
                listOptionsSelected.add(ct.getId());
            }
        }
        if (listOptions != null) {
            mapReturn = new HashMap<>();
            mapReturn.put("clients", listOptions);
            mapReturn.put("clientsSelected", listOptionsSelected);
        }
        return mapReturn;
    }


    @PreAuthorize("#oauth2.hasScope('internal_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<ClientTable> list;
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
        list = clientTableService.getList(pageRequest, filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (ClientTable ct : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", ct.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(ct.getClientId());
                listTmp.add(ct.getClientName());
                listTmp.add(ct.isInternalClient() ? "Y" : "N");
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
        ClientTable ct = clientTableService.getById(id);
        return JacksonUtil.mapper.convertValue(clientResourceAssembler.toResource(ct), Map.class);
    }


    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateUser(@RequestBody JsonNode body, Principal principal) {
        Map map = JacksonUtil.mapper.convertValue(body.get("data"), Map.class);
        ClientTable ct = clientTableService.getById(Long.valueOf(map.get("id").toString()));
        if (body.get("data").get("clientName") != null && !body.get("data").get("clientName").isNull()) {
            ct.setClientName(body.get("data").get("clientName").textValue());
        }
        if (body.get("data").get("clientSecret") != null && !body.get("data").get("clientSecret").isNull()) {
            ct.setClientSecret(body.get("data").get("clientSecret").textValue());
        }
        if (body.get("data").get("authorizedGrantTypes") != null && !body.get("data").get("authorizedGrantTypes").isNull()) {
            Set set = JacksonUtil.mapper.convertValue(body.get("data").get("authorizedGrantTypes"), Set.class);
            if (set.contains("authorization_code")) {
                set.add("refresh_token");
            }else{
                set.remove("refresh_token");
            }
            ct.setAuthorizedGrantTypes(set);
        } else {
            ct.setAuthorizedGrantTypes("");
        }
        boolean isInternalClient = false;
        if (body.get("data").get("internalClient") != null && !body.get("data").get("internalClient").isNull()) {
            List<Boolean> b = JacksonUtil.mapper.convertValue(body.get("data").get("internalClient"), List.class);
            if (b.size() > 0) {
                isInternalClient = b.get(0);
            }
        }
        if (isInternalClient && !ct.isInternalClient()) {
            ct.setInternalClient(true);
            ct.getAuthoritiesBasic().add(clientRoleTableService.getByAuthority("internal_client"));
            Map<String,Boolean> scopes = ct.getScopeAndApprove();
            scopes.put("internal_client",true);
            try {
                ct.setScope( JacksonUtil.mapper.writeValueAsString(scopes));
            } catch (JsonProcessingException e) {
                ct.setScope("");
            }
        }
        else if (!isInternalClient && ct.isInternalClient()) {
            ct.setInternalClient(false);
            List<ClientRoleTable> listAuth = ct.getAuthoritiesBasic();
            for (GrantedAuthority ga : listAuth) {
                if (ga.getAuthority().equals("internal_client")) {
                    listAuth.remove(ga);
                }
            }
            Map<String,Boolean> scopes = ct.getScopeAndApprove();
            for (String scope : scopes.keySet()) {
                if (scope.equals("internal_client")) {
                    scopes.remove(scope);
                }
            }
            if (scopes.size() > 0) {
                try {
                    ct.setScope( JacksonUtil.mapper.writeValueAsString(scopes));
                } catch (JsonProcessingException e) {
                    ct.setScope("");
                }
            } else {
                ct.setScope("");
            }
        }
        clientTableService.save(ct);
        return null;
    }
}
