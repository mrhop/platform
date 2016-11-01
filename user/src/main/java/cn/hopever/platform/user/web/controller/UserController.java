package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.service.UserTableService;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserTableService userTableService;


    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String,Object> map  = null;
        List<HashMap<String, Object>> listReturn;
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        Page<UserTable> list;
        PageRequest pageRequest;
        if(body.get("sort")==null||body.get("sort").isNull()){
            pageRequest = new PageRequest(body.get("currentPage").asInt(),body.get("rowSize").asInt(), Sort.Direction.ASC,"id");
        }else{
            pageRequest = new PageRequest(body.get("currentPage").asInt(),body.get("rowSize").asInt(), Sort.Direction.fromString(body.get("sort").get("sortDirection").textValue()),body.get("sort").get("sortName").textValue());
        }
        if("ROLE_super_admin".equals(authority)){
            list = userTableService.getListWithOutSelf(principal.getName(),pageRequest);
        }else{
            list = userTableService.getSubList(principal.getName(),pageRequest);
        }
        if(list!=null&&list.iterator().hasNext()){
            map  = new HashMap<>();
            listReturn = new ArrayList<>();
            for (UserTable ut : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", ut.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(ut.getUsername());
                listTmp.add(ut.getEmail());
                listTmp.add(ut.getPhone());
                listTmp.add(ut.isEnabled()?"Y":"N");
                listTmp.add(ut.isAccountNonExpired()?"Y":"N");
                listTmp.add(ut.getCreateUser()!=null?ut.getCreateUser().getCreateUser().getUsername():"");
                mapTemp.put("value", listTmp);
                listReturn.add(mapTemp);
            }
            map.put("data",listReturn);
            map.put("totalCount",list.getTotalElements());
            map.put("rowSize",list.getSize());
            map.put("currentPage",list.getNumber());
        }
        return map;
    }
}
