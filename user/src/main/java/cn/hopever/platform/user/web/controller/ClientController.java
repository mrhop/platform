package cn.hopever.platform.user.web.controller;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.service.ClientTableService;
import cn.hopever.platform.user.web.hateoas.ClientResourceAssembler;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private ClientResourceAssembler clientResourceAssembler;


    @PreAuthorize("#oauth2.hasScope('internal_client') and ( hasRole('ROLE_super_admin') or hasRole('ROLE_admin'))")
    @RequestMapping(value = "/list/options", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map mapReturn = null;
        List listOptions = null;
        List listOptionsSelected = null;
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        String roleName = body.get("roleName").asText();
        Long userId = body.get("userId").asLong();
        Iterable<ClientTable> list = null;
        Iterable<ClientTable> listSelected = null;
        //然后根据roleName
        if (roleName.equals("ROLE_admin") || roleName.equals("internal_client")) {
            //do the get
            if (authority.equals("ROLE_super_admin")) {
                //get all client
                list = clientTableService.getAll();
            } else {
                list = clientTableService.getByUserName(principal.getName());
            }
            listSelected = clientTableService.getByUserId(userId);
        }
        if (list != null && list.iterator().hasNext()) {
            listOptions = new ArrayList<>();
            for (ClientTable ct : list) {
                Map mapOption = new HashMap<>();
                mapOption.put("label", ct.getClientName());
                mapOption.put("value", ct.getId());
                listOptions.add(mapOption);
            }
        }

        if (listSelected != null && listSelected.iterator().hasNext()) {
            listOptionsSelected = new ArrayList<>();
            for (ClientTable ct : listSelected) {
                listOptionsSelected.add( ct.getId());
            }
        }
        if(listOptions!=null){
            mapReturn = new HashMap<>();
            mapReturn.put("clients",listOptions);
            mapReturn.put("clientsSelected",listOptionsSelected);
        }
        return mapReturn;
    }


}
