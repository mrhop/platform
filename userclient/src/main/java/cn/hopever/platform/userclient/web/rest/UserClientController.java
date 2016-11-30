package cn.hopever.platform.userclient.web.rest;

import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.userclient.config.BaseConfig;
import cn.hopever.platform.utils.json.JacksonUtil;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin
public class UserClientController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/user/personalinfo", method = {RequestMethod.GET})
    public CommonResult getPersonalInfo(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPersonalinfo());
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/user/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteUser(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getDelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    //do user get by id
    @RequestMapping(value = "/user/info", method = {RequestMethod.GET})
    public CommonResult getUser(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getInfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("userupdate");
        List<Map> list = (List<Map>) rule.get("structure");
        Long roleSelected = null;
        List clientsSelected = null;

        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if (mapData.get(map.get("name")) != null) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            // listReturn.add(map);
                        }
                        if ("id".equals(map.get("name"))) {
                            map.put("defaultValue", mapData.get("internalId"));
                        }
                        if ("authorities".equals(map.get("name"))) {
                            roleSelected = Long.valueOf(((List<Map>) mapData.get("authorities")).get(0).get("internalId").toString());
                            map.put("defaultValue", roleSelected);
                        }
//                        if ("clients".equals(map.get("name"))) {
//                            if (mapData.get("clients") != null) {
//                                List<Map> listClients = (List<Map>) mapData.get("clients");
//                                clientsSelected = new ArrayList<>();
//                                for (Map client : listClients) {
//                                    clientsSelected.add(client.get("internalId"));
//                                }
//                                map.put("defaultValue", clientsSelected);
//                            }
//
//                        }
                    }
                }
            }
        }
        for (Map map : list) {
            if ("authorities".equals(map.get("name"))) {
                request.setAttribute("resourceUrl", baseConfig.getRoleoptions());
                CommonResult c1 = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                    map.put("items", c1.getResponseData().get("data"));
                } else {
                    map.put("items", new ArrayList());
                }
            }
            if ("clients".equals(map.get("name"))) {
                ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
                request.setAttribute("resourceUrl", baseConfig.getClientoptions());
                jsonNode.put("userId", request.getParameter("key"));
                jsonNode.put("roleId", roleSelected);
                CommonResult c2 = commonMethods.postResource(jsonNode, request);
                if (CommonResultStatus.SUCCESS.toString().equals(c2.getStatus()) && c2.getResponseData().get("data") != null) {
                    Map mapItems = (Map) c2.getResponseData().get("data");
                    map.put("items", mapItems.get("clients"));
                    if(mapItems.get("clientsSelected")!=null){
                        clientsSelected = JacksonUtil.mapper.convertValue(mapItems.get("clientsSelected"),List.class);
                        map.put("defaultValue", clientsSelected);
                    }

                        map.remove("available");
                } else {
                    map.put("items", new ArrayList());
                }
            }
            if ("modulesAuthorities".equals(map.get("name")) && clientsSelected != null && clientsSelected.size() > 0) {
                ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
                request.setAttribute("resourceUrl", baseConfig.getModuleroleoptions());
                jsonNode.put("userId", request.getParameter("key"));
                jsonNode.put("roleId", roleSelected);
                jsonNode.set("clientIds", JacksonUtil.mapper.convertValue(clientsSelected, ArrayNode.class));
                CommonResult c3 = commonMethods.postResource(jsonNode, request);
                if (CommonResultStatus.SUCCESS.toString().equals(c3.getStatus()) && c3.getResponseData().get("data") != null) {
                    Map mapItems = (Map) c3.getResponseData().get("data");
                    if (mapItems.get("moduleRoles") != null) {
                        map.put("items", mapItems.get("moduleRoles"));
                        map.put("defaultValue", mapItems.get("moduleRolesSelected"));
                        map.remove("available");
                    }
                }
            }
        }

        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/user/info/rule/update", method = {RequestMethod.POST})
    public CommonResult updateUserRule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = JacksonUtil.mapper.convertValue(body.get("rule"), Map.class);
        List<Map> list = (List<Map>) rule.get("structure");
        CommonResult clientCr = null;
        CommonResult moduleRoleCr = null;
        for (Map map : list) {
            map.remove("changed");
            if ("authorities".equals(map.get("name")) && "authorities".equals(body.get("updateElement").asText())) {
                ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
                request.setAttribute("resourceUrl", baseConfig.getClientoptions());
                jsonNode.put("userId", request.getParameter("key"));
                jsonNode.put("roleId", body.get("updateData").asLong());
                clientCr = commonMethods.postResource(jsonNode, request);
                break;
            }
            //do other
        }
        if ("authorities".equals(body.get("updateElement").textValue())) {
            for (Map map : list) {
                if ("clients".equals(map.get("name"))) {
                    if (clientCr != null && CommonResultStatus.SUCCESS.toString().equals(clientCr.getStatus()) && clientCr.getResponseData().get("data") != null) {
                        Map mapItems = (Map) clientCr.getResponseData().get("data");
                        map.put("items", mapItems.get("clients"));
                        map.put("defaultValue", mapItems.get("clientsSelected"));
                        if (mapItems.get("clientsSelected") != null) {
                            ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
                            request.setAttribute("resourceUrl", baseConfig.getModuleroleoptions());
                            jsonNode.put("userId", request.getParameter("key"));
                            jsonNode.put("roleId", body.get("updateData").asLong());
                            jsonNode.set("clientIds", JacksonUtil.mapper.convertValue(mapItems.get("clientsSelected"), ArrayNode.class));
                            moduleRoleCr = commonMethods.postResource(jsonNode, request);
                        }
                        map.remove("available");

                    } else {
                        map.remove("items");
                        map.remove("defaultValue");
                        map.put("available", false);
                    }
                    map.put("changed", true);
                }
                if ("modulesAuthorities".equals(map.get("name"))) {
                    if (moduleRoleCr != null && CommonResultStatus.SUCCESS.toString().equals(moduleRoleCr.getStatus()) && moduleRoleCr.getResponseData().get("data") != null) {
                        Map mapItems = (Map) moduleRoleCr.getResponseData().get("data");
                        if (mapItems.get("moduleRoles") != null) {
                            map.put("items", mapItems.get("moduleRoles"));
                            map.put("defaultValue", mapItems.get("moduleRolesSelected"));
                            map.remove("available");
                        } else {
                            map.remove("items");
                            map.remove("defaultValue");
                            map.put("available", false);
                        }
                    } else {
                        map.remove("items");
                        map.remove("defaultValue");
                        map.put("available", false);
                    }
                    map.put("changed", true);
                    break;
                }
            }
        }
        if ("clients".equals(body.get("updateElement").textValue())) {
            ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
            for (Map map : list) {
                if ("authorities".equals(map.get("name"))) {
                    jsonNode.put("roleId", (Integer) map.get("defaultValue"));
                }
                if ("clients".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        request.setAttribute("resourceUrl", baseConfig.getModuleroleoptions());
                        jsonNode.put("userId", request.getParameter("key"));
                        jsonNode.set("clientIds", body.get("updateData"));
                        moduleRoleCr = commonMethods.postResource(jsonNode, request);
                    }
                }
                if ("modulesAuthorities".equals(map.get("name"))) {
                    if (moduleRoleCr != null && CommonResultStatus.SUCCESS.toString().equals(moduleRoleCr.getStatus()) && moduleRoleCr.getResponseData().get("data") != null) {
                        Map mapItems = (Map) moduleRoleCr.getResponseData().get("data");
                        if (mapItems.get("moduleRoles") != null) {
                            map.put("items", mapItems.get("moduleRoles"));
                            map.put("defaultValue", mapItems.get("moduleRolesSelected"));
                            map.remove("available");
                        } else {
                            map.remove("items");
                            map.remove("defaultValue");
                            map.put("available", false);
                        }
                    } else {
                        map.remove("items");
                        map.remove("defaultValue");
                        map.put("available", false);
                    }
                    map.put("changed", true);
                    break;
                }
            }
        }
        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/user/update", method = {RequestMethod.POST})
    public CommonResult updateUser(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getUpdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/user/personal/update", method = {RequestMethod.POST})
    public CommonResult updateUserPersonal(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getUpdatepersonal());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/user/add", method = {RequestMethod.GET})
    public CommonResult addUser(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("useradd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("authorities".equals(map.get("name"))) {
                request.setAttribute("resourceUrl", baseConfig.getRoleoptions());
                CommonResult c1 = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                    map.put("items", c1.getResponseData().get("data"));
                } else {
                    map.put("items", new ArrayList());
                }
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/user/save", method = {RequestMethod.POST})
    public CommonResult saveUser(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getSave());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/user/add/rule/update", method = {RequestMethod.POST})
    public CommonResult updateAddUserRule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = JacksonUtil.mapper.convertValue(body.get("rule"), Map.class);
        List<Map> list = (List<Map>) rule.get("structure");
        CommonResult clientCr = null;
        CommonResult moduleRoleCr = null;
        for (Map map : list) {
            map.remove("changed");
            if ("authorities".equals(map.get("name")) && "authorities".equals(body.get("updateElement").asText())) {
                ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
                request.setAttribute("resourceUrl", baseConfig.getClientoptions());
                jsonNode.put("roleId", body.get("updateData").asLong());
                clientCr = commonMethods.postResource(jsonNode, request);
                break;
            }
            //do other
        }
        if ("authorities".equals(body.get("updateElement").textValue())) {
            for (Map map : list) {
                if ("clients".equals(map.get("name"))) {
                    if (clientCr != null && CommonResultStatus.SUCCESS.toString().equals(clientCr.getStatus()) && clientCr.getResponseData().get("data") != null) {
                        Map mapItems = (Map) clientCr.getResponseData().get("data");
                        map.put("items", mapItems.get("clients"));
                        map.remove("defaultValue");
                        map.remove("available");
                    } else {
                        map.remove("items");
                        map.remove("defaultValue");
                        map.put("available", false);
                    }
                    map.put("changed", true);
                }

                if ("modulesAuthorities".equals(map.get("name"))) {
                    map.remove("items");
                    map.remove("defaultValue");
                    map.put("available", false);
                    map.put("changed", true);
                    break;
                }
            }
        }
        if ("clients".equals(body.get("updateElement").textValue())) {
            ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
            for (Map map : list) {
                if ("authorities".equals(map.get("name"))) {
                    jsonNode.put("roleId", (Integer) map.get("defaultValue"));
                }
                if ("clients".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        request.setAttribute("resourceUrl", baseConfig.getModuleroleoptions());
                        jsonNode.set("clientIds", body.get("updateData"));
                        moduleRoleCr = commonMethods.postResource(jsonNode, request);
                    }
                }
                if ("modulesAuthorities".equals(map.get("name"))) {
                    if (moduleRoleCr != null && CommonResultStatus.SUCCESS.toString().equals(moduleRoleCr.getStatus()) && moduleRoleCr.getResponseData().get("data") != null) {
                        Map mapItems = (Map) moduleRoleCr.getResponseData().get("data");
                        if (mapItems.get("moduleRoles") != null) {
                            map.put("items", mapItems.get("moduleRoles"));
                            map.remove("available");
                        } else {
                            map.remove("items");
                            map.remove("defaultValue");
                            map.put("available", false);
                        }
                    } else {
                        map.remove("items");
                        map.remove("defaultValue");
                        map.put("available", false);
                    }
                    map.put("changed", true);
                    break;
                }
            }
        }
        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/user/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getUserList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getUserlist());
        if (body.get("currentPage") == null || body.get("currentPage").isNull()) {
            ((ObjectNode) body).put("currentPage", 0);
        }
        if (body.get("rowSize") == null || body.get("rowSize").isNull()) {
            ((ObjectNode) body).put("rowSize", commonProperties.getPageSize());
        }

        CommonResult c = commonMethods.postResource(body, request);
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> map = (Map) c.getResponseData().get("data");
                    c.getResponseData().put("totalCount", map.get("totalCount"));
                    c.getResponseData().put("rowSize", map.get("rowSize"));
                    c.getResponseData().put("currentPage", map.get("currentPage"));
                    c.getResponseData().put("data", map.get("data"));
                } else {
                    c.getResponseData().put("totalCount", 0);
                }
                if (body.get("init") != null && !body.get("init").isNull() && body.get("init").asBoolean()) {
                    c.getResponseData().put("rules", baseConfig.getTableRule("userList"));
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("userListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/role/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getRoleList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getRolelist());
        CommonResult c = commonMethods.getResource(request);
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    c.getResponseData().put("totalCount", ((List) c.getResponseData().get("data")).size());
                } else {
                    c.getResponseData().put("totalCount", 0);
                }
                if (body.get("init") != null && body.get("init").asBoolean()) {
                    c.getResponseData().put("rules", baseConfig.getTableRule("roleList"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/user/personal/info", method = {RequestMethod.GET})
    public CommonResult getUserPersonalInfo(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPersonalinfo());
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("userpersonalinfo");
        List<Map> list = (List<Map>) rule.get("structure");

        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if (mapData.get(map.get("name")) != null) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            // listReturn.add(map);
                        }
                        if ("id".equals(map.get("name"))) {
                            map.put("defaultValue", mapData.get("internalId"));
                        }
                        if ("authorities".equals(map.get("name"))) {
                            String roleSelected = ((List<Map>) mapData.get("authorities")).get(0).get("name").toString();
                            map.put("defaultValue", roleSelected);
                        }
                        if ("clients".equals(map.get("name"))) {
                            if (mapData.get("clients") != null) {
                                List<Map> listClients = (List<Map>) mapData.get("clients");
                                StringBuilder clientsSelected = new StringBuilder("");
                                for (int i = 0; i < listClients.size(); i++) {
                                    clientsSelected.append(listClients.get(i).get("clientName"));
                                    if (i < listClients.size() - 1) {
                                        clientsSelected.append(",");
                                    }
                                }
                                map.put("defaultValue", clientsSelected);
                            }
                        }
                        if ("modulesAuthorities".equals(map.get("name"))){
                            if (mapData.get("modulesAuthorities") != null) {
                                List<Map> listModulesAuthorities = (List<Map>) mapData.get("modulesAuthorities");
                                StringBuilder modulesAuthoritiesSelected = new StringBuilder("");
                                for (int i = 0; i < listModulesAuthorities.size(); i++) {
                                    modulesAuthoritiesSelected.append(listModulesAuthorities.get(i).get("name"));
                                    if (i < listModulesAuthorities.size() - 1) {
                                        modulesAuthoritiesSelected.append(",");
                                    }
                                }
                                map.put("defaultValue", modulesAuthoritiesSelected);
                            }
                        }
                    }
                }
            }
        }
        c.setResponseData(rule);
        return c;
    }


    @RequestMapping(value = "/client/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getClientrList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getClientlist());
        if (body.get("currentPage") == null || body.get("currentPage").isNull()) {
            ((ObjectNode) body).put("currentPage", 0);
        }
        if (body.get("rowSize") == null || body.get("rowSize").isNull()) {
            ((ObjectNode) body).put("rowSize", commonProperties.getPageSize());
        }

        CommonResult c = commonMethods.postResource(body, request);
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> map = (Map) c.getResponseData().get("data");
                    c.getResponseData().put("totalCount", map.get("totalCount"));
                    c.getResponseData().put("rowSize", map.get("rowSize"));
                    c.getResponseData().put("currentPage", map.get("currentPage"));
                    c.getResponseData().put("data", map.get("data"));
                } else {
                    c.getResponseData().put("totalCount", 0);
                }
                if (body.get("init") != null && !body.get("init").isNull() && body.get("init").asBoolean()) {
                    c.getResponseData().put("rules", baseConfig.getTableRule("clientList"));
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("clientListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/client/info", method = {RequestMethod.GET})
    public CommonResult getClient(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getClientinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("clientupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if("internalClient".equals(map.get("name"))&&(boolean)mapData.get(map.get("name"))){
                            map.put("defaultValue", new Object[]{mapData.get(map.get("name"))});
                            continue;
                        }
                        if("scope".equals(map.get("name"))){
                            Object o  = mapData.get(map.get("name"));
                            String defaultValue = null;
                            if(o!=null){
                                defaultValue = "";
                                for(int i = 0;i<((List)o).size();i++){
                                    if(i<((List)o).size()-1){
                                        defaultValue = defaultValue+(((List)o).get(i)).toString()+",";
                                    }else{
                                        defaultValue = defaultValue+(((List)o).get(i)).toString();
                                    }
                                }
                            }
                            map.put("defaultValue", defaultValue);
                            continue;
                        }
                        if("authorities".equals(map.get("name"))||"moduleRoles".equals(map.get("name"))){
                           Object o  = mapData.get(map.get("name"));
                            String defaultValue = null;
                            if(o!=null){
                                defaultValue = "";
                                for(int i = 0;i<((List)o).size();i++){
                                    if(i<((List)o).size()-1){
                                        defaultValue = defaultValue+((Map)((List)o).get(i)).get("name")+",";
                                    }else{
                                        defaultValue = defaultValue+((Map)((List)o).get(i)).get("name");
                                    }
                                }
                            }
                            map.put("defaultValue", defaultValue);
                            continue;
                        }
                        if ("id".equals(map.get("name"))) {
                            map.put("defaultValue", mapData.get("internalId"));
                            continue;
                        }
                        if (mapData.get(map.get("name")) != null) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            // listReturn.add(map);
                        }
                    }
                }
            }
        }
        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/client/update", method = {RequestMethod.POST})
    public CommonResult updateClient(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getClientupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/client/add", method = {RequestMethod.GET})
    public CommonResult addClient(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("clientadd");
        List<Map> list = (List<Map>) rule.get("structure");
        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/client/save", method = {RequestMethod.POST})
    public CommonResult saveClient(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getClientsave());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/client/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteClient(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getClientdelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }
}
