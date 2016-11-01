package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.service.RoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/role", produces = "application/json")
public class RoleController {
    Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleTableService roleTableService;


    @PreAuthorize("#oauth2.hasScope('user_admin_client') and hasRole('ROLE_super_admin')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List getList() {
        List<HashMap<String, Object>> listReturn = null;
        Iterable<RoleTable> list = roleTableService.getList();
        if (list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (RoleTable rt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", rt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(rt.getAuthority());
                listTmp.add(rt.getLevel());
                mapTemp.put("value", listTmp);
                listReturn.add(mapTemp);
            }
        }
        return listReturn;
    }
}
