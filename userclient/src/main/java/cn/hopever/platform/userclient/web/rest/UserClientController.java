package cn.hopever.platform.userclient.web.rest;

import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.userclient.config.BaseConfig;
import cn.hopever.platform.utils.json.JacksonUtil;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

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
                        if ("id".equals(map.get("name"))) {
                            map.put("defaultValue", mapData.get("internalId"));
                            continue;
                        }
                        if ("authorities".equals(map.get("name"))) {
                            roleSelected = Long.valueOf(((List<Map>) mapData.get("authorities")).get(0).get("internalId").toString());
                            map.put("defaultValue", roleSelected);
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
        for (Map map : list) {
            if ("authorities".equals(map.get("name"))) {
                request.setAttribute("resourceUrl", baseConfig.getRoleoptions());
                CommonResult c1 = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                    map.put("items", c1.getResponseData().get("data"));
                } else {
                    map.put("items", new ArrayList());
                }
                continue;
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
                    if (mapItems.get("clientsSelected") != null) {
                        clientsSelected = JacksonUtil.mapper.convertValue(mapItems.get("clientsSelected"), List.class);
                        map.put("defaultValue", clientsSelected);
                    } else {
                        map.put("defaultValue", null);
                    }

                    map.remove("available");
                } else {
                    map.put("items", new ArrayList());
                }
                continue;
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
                continue;
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
    public CommonResult updateUser(HttpServletRequest request, @RequestPart("photo") MultipartFile[] files) throws Exception {
        String userPhoto = null;
        if (files != null && files.length > 0) {
            request.setAttribute("resourceUrl", commonProperties.getImageUpload());
            request.setAttribute("filePath", "user/photo/");
            CommonResult cr = this.commonMethods.postFile(request, files);
            if (CommonResultStatus.SUCCESS.toString().equals(cr.getStatus()) && cr.getResponseData().get("data") != null) {
                List<String> list = ((Map<String, List>) cr.getResponseData().get("data")).get("fileKeys");
                if (list != null && list.size() > 0) {
                    userPhoto = commonProperties.getImagePathPrev() + list.get(0);
                }
            }
        }
        HashMap map = new HashMap<>();
        Set<String> set = request.getParameterMap().keySet();
        for (String key : set) {
            if (key.equals("clients") || key.equals("modulesAuthorities")) {
                map.put(key, request.getParameterValues(key));
            } else {
                String value = request.getParameter(key);
                if (value != null && value.length() > 0) {
                    map.put(key, value);
                }
            }
        }
        map.put("photo", userPhoto);
        request.setAttribute("resourceUrl", baseConfig.getUpdate());
        return commonMethods.postResource(map, request);
    }

    @RequestMapping(value = "/user/personal/update", method = {RequestMethod.POST})
    public CommonResult updateUserPersonal(HttpServletRequest request, @RequestPart("photo") MultipartFile[] files) throws Exception {
        String userPhoto = null;
        if (files != null && files.length > 0) {
            request.setAttribute("resourceUrl", commonProperties.getImageUpload());
            request.setAttribute("filePath", "user/photo/");
            CommonResult cr = this.commonMethods.postFile(request, files);
            if (CommonResultStatus.SUCCESS.toString().equals(cr.getStatus()) && cr.getResponseData().get("data") != null) {
                List<String> list = ((Map<String, List>) cr.getResponseData().get("data")).get("fileKeys");
                if (list != null && list.size() > 0) {
                    userPhoto = commonProperties.getImagePathPrev() + list.get(0);
                }
            }
        }
        HashMap map = new HashMap<>();
        Set<String> set = request.getParameterMap().keySet();
        for (String key : set) {
            if (key.equals("clients") || key.equals("modulesAuthorities")) {
                map.put(key, request.getParameterValues(key));
            } else {
                String value = request.getParameter(key);
                if (value != null && value.length() > 0) {
                    map.put(key, value);
                }
            }
        }
        map.put("photo", userPhoto);
        request.setAttribute("resourceUrl", baseConfig.getUpdatepersonal());
        CommonResult cr = commonMethods.postResource(map, request);
        if (userPhoto != null && CommonResultStatus.SUCCESS.toString().equals(cr.getStatus())) {
            ((Map) request.getSession().getAttribute("accesstoken")).put("userphoto", userPhoto);
        }
        return cr;
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
                break;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/user/save", method = {RequestMethod.POST})
    public CommonResult saveUser(HttpServletRequest request, @RequestPart("photo") MultipartFile[] files) throws Exception {
        String userPhoto = commonProperties.getDefaultUserPhoto();
        if (files != null && files.length > 0) {
            request.setAttribute("resourceUrl", commonProperties.getImageUpload());
            request.setAttribute("filePath", "user/photo/");
            CommonResult cr = this.commonMethods.postFile(request, files);
            if (CommonResultStatus.SUCCESS.toString().equals(cr.getStatus()) && cr.getResponseData().get("data") != null) {
                List<String> list = ((Map<String, List>) cr.getResponseData().get("data")).get("fileKeys");
                if (list != null && list.size() > 0) {
                    userPhoto = commonProperties.getImagePathPrev() + list.get(0);
                }
            }
        }
        HashMap map = new HashMap<>();
        Set<String> set = request.getParameterMap().keySet();
        for (String key : set) {
            if (key.equals("clients") || key.equals("modulesAuthorities")) {
                map.put(key, request.getParameterValues(key));
            } else {
                String value = request.getParameter(key);
                if (value != null && value.length() > 0) {
                    map.put(key, value);
                }
            }
        }
        map.put("photo", userPhoto);
        request.setAttribute("resourceUrl", baseConfig.getSave());
        return commonMethods.postResource(map, request);
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
                        if ("modulesAuthorities".equals(map.get("name"))) {
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
    public CommonResult getClientList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
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
                        if ("internalClient".equals(map.get("name")) && (boolean) mapData.get(map.get("name"))) {
                            map.put("defaultValue", new Object[]{mapData.get(map.get("name"))});
                            continue;
                        }
                        if ("scope".equals(map.get("name"))) {
                            Object o = mapData.get(map.get("name"));
                            String defaultValue = null;
                            if (o != null) {
                                defaultValue = "";
                                for (int i = 0; i < ((List) o).size(); i++) {
                                    if (i < ((List) o).size() - 1) {
                                        defaultValue = defaultValue + (((List) o).get(i)).toString() + ",";
                                    } else {
                                        defaultValue = defaultValue + (((List) o).get(i)).toString();
                                    }
                                }
                            }
                            map.put("defaultValue", defaultValue);
                            continue;
                        }
                        if ("authorities".equals(map.get("name")) || "moduleRoles".equals(map.get("name"))) {
                            Object o = mapData.get(map.get("name"));
                            String defaultValue = null;
                            if (o != null) {
                                defaultValue = "";
                                for (int i = 0; i < ((List) o).size(); i++) {
                                    if (i < ((List) o).size() - 1) {
                                        defaultValue = defaultValue + ((Map) ((List) o).get(i)).get("name") + ",";
                                    } else {
                                        defaultValue = defaultValue + ((Map) ((List) o).get(i)).get("name");
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

    @RequestMapping(value = "/modulerole/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getModuleRoleList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModulerolelist());
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
                    c.getResponseData().put("rules", baseConfig.getTableRule("moduleroleList"));
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("moduleroleListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/modulerole/info", method = {RequestMethod.GET})
    public CommonResult getModuleRole(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModuleroleinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("moduleroleupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if ("client".equals(map.get("name"))) {
                            //首先是options，然后是defaultvalue
                            request.setAttribute("resourceUrl", baseConfig.getClientoptionsofmodulerole());
                            CommonResult c1 = commonMethods.getResource(request);
                            if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                                map.put("items", c1.getResponseData().get("data"));
                            } else {
                                map.put("items", new ArrayList());
                            }
                            if (mapData.get("client") != null) {
                                map.put("defaultValue", Long.valueOf(((Map) mapData.get("client")).get("internalId").toString()));
                            }
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

    @RequestMapping(value = "/modulerole/update", method = {RequestMethod.POST})
    public CommonResult updateModuleRole(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModuleroleupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/modulerole/add", method = {RequestMethod.GET})
    public CommonResult addModuleRole(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("moduleroleadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("client".equals(map.get("name"))) {
                //首先是options，然后是defaultvalue
                request.setAttribute("resourceUrl", baseConfig.getClientoptionsofmodulerole());
                CommonResult c1 = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                    map.put("items", c1.getResponseData().get("data"));
                } else {
                    map.put("items", new ArrayList());
                }
                break;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/modulerole/save", method = {RequestMethod.POST})
    public CommonResult saveModuleRole(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModulerolesave());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/modulerole/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteModuleRole(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModuleroledelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }


    //MODULE
    @RequestMapping(value = "/module/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getModuleList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModulelist());
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
                    Map<String, Object> mapModuleList = baseConfig.getTableRule("moduleList");
                    List<Map> headList = (List) mapModuleList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("client")) {
                            request.setAttribute("resourceUrl", baseConfig.getClientoptionsofmodulerole());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        } else if (map.get("value").equals("parent")) {
                            request.setAttribute("resourceUrl", baseConfig.getModuleparentoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        } else if (map.get("value").equals("activated")) {
                            List<Map> list = new ArrayList<>();
                            Map<String, Object> mapAvailable1 = new HashMap<>();
                            mapAvailable1.put("label", "已激活");
                            mapAvailable1.put("value", "true");
                            Map<String, Object> mapAvailable2 = new HashMap<>();
                            mapAvailable2.put("label", "未激活");
                            mapAvailable2.put("value", "false");
                            list.add(mapAvailable1);
                            list.add(mapAvailable2);
                            map.put("editValue", list);
                        }


                    }
                    c.getResponseData().put("rules", mapModuleList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("moduleListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/module/info", method = {RequestMethod.GET})
    public CommonResult getModule(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModuleinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("moduleupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    Long clientId = null;
                    boolean isTop = false;
                    ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
                    for (Map map : list) {
                        if ("client".equals(map.get("name"))) {
                            request.setAttribute("resourceUrl", baseConfig.getClientoptionsofmodulerole());
                            CommonResult c1 = commonMethods.getResource(request);
                            if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                                map.put("items", c1.getResponseData().get("data"));
                            } else {
                                map.put("items", new ArrayList());
                            }
                            if (mapData.get("client") != null) {
                                clientId = Long.valueOf(((Map) mapData.get("client")).get("internalId").toString());
                                map.put("defaultValue", clientId);
                            }
                            continue;
                        }
                        if ("authorities".equals(map.get("name")) && clientId != null) {
                            request.setAttribute("resourceUrl", baseConfig.getModuleroleoptionsofmodule());
                            jsonNode.set("clientId", JacksonUtil.mapper.convertValue(clientId, LongNode.class));
                            CommonResult moduleRoleCr = commonMethods.postResource(jsonNode, request);
                            if (CommonResultStatus.SUCCESS.toString().equals(moduleRoleCr.getStatus()) && moduleRoleCr.getResponseData().get("data") != null) {
                                map.put("items", ((Map) moduleRoleCr.getResponseData().get("data")).get("items"));
                                //DO UPDATE
                                Object listRole = mapData.get(map.get("name"));
                                List<Object> listOption = null;
                                if (listRole != null) {
                                    listOption = new ArrayList<>();
                                    for (Map mapRole : (List<Map>) listRole) {
                                        listOption.add(mapRole.get("internalId"));
                                    }
                                }
                                map.put("defaultValue", listOption);
                                map.remove("available");
                            } else {
                                map.remove("items");
                                map.remove("defaultValue");
                                map.put("available", false);
                            }
                            continue;
                        }
                        if ("isTop".equals(map.get("name")) && clientId != null) {
                            map.remove("available");
                            isTop = (mapData.get(map.get("name")) != null && (Boolean) mapData.get(map.get("name"))) ? true : false;
                            if (isTop) {
                                map.put("defaultValue", "Y");
                            } else {
                                map.put("defaultValue", "N");
                            }
                            continue;
                        }

                        if ("parent".equals(map.get("name")) && clientId != null && !isTop) {
                            request.setAttribute("resourceUrl", baseConfig.getModuleparentoptionsofclient());
                            jsonNode.set("clientId", JacksonUtil.mapper.convertValue(clientId, LongNode.class));
                            CommonResult moduleCr = commonMethods.postResource(jsonNode, request);
                            if (CommonResultStatus.SUCCESS.toString().equals(moduleCr.getStatus())) {
                                map.put("items", ((Map) moduleCr.getResponseData().get("data")).get("items"));
                                //DO UPDATE
                                map.put("defaultValue", ((Map) mapData.get(map.get("name"))).get("internalId"));
                                map.remove("available");
                            } else {
                                map.put("available", false);
                                map.remove("defaultValue");
                                map.remove("items");
                            }
                            continue;
                        }
                        if ("iconClass".equals(map.get("name")) && clientId != null && isTop) {
                            map.remove("available");
                            map.put("defaultValue", mapData.get(map.get("name")));
                            continue;
                        }
                        if ("moduleUrl".equals(map.get("name")) && clientId != null && !isTop) {
                            map.remove("available");
                            map.put("defaultValue", mapData.get(map.get("name")));
                            continue;
                        }
                        if ("moduleOrder".equals(map.get("name")) && clientId != null) {
                            map.remove("available");
                            map.put("defaultValue", mapData.get(map.get("name")));
                            continue;
                        }
                        if ("available".equals(map.get("name")) && clientId != null) {
                            map.remove("available");
                            if ((boolean) mapData.get(map.get("name"))) {
                                List<Boolean> listTmp = new ArrayList<>();
                                listTmp.add((boolean) mapData.get(map.get("name")));
                                map.put("defaultValue", listTmp);
                            }
                            continue;
                        }
                        if ("activated".equals(map.get("name")) && clientId != null) {
                            if ((boolean) mapData.get(map.get("name"))) {
                                List<Boolean> listTmp = new ArrayList<>();
                                listTmp.add((boolean) mapData.get(map.get("name")));
                                map.put("defaultValue", listTmp);
                            }
                            map.remove("available");
                            continue;
                        }
                        if ("id".equals(map.get("name"))) {
                            map.put("defaultValue", mapData.get("internalId"));
                            continue;
                        }
                        if (mapData.get(map.get("name")) != null) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                        }
                    }
                }
            }
        }

        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/module/update", method = {RequestMethod.POST})
    public CommonResult updateModule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModuleupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/module/add", method = {RequestMethod.GET})
    public CommonResult addModule(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("moduleadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("client".equals(map.get("name"))) {
                //首先是options，然后是defaultvalue
                request.setAttribute("resourceUrl", baseConfig.getClientoptionsofmodulerole());
                CommonResult c1 = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(c1.getStatus())) {
                    map.put("items", c1.getResponseData().get("data"));
                } else {
                    map.put("items", new ArrayList());
                }
                break;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/module/add/rule/update", method = {RequestMethod.POST})
    public CommonResult updateModuleRule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = JacksonUtil.mapper.convertValue(body.get("rule"), Map.class);
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            map.remove("changed");
        }
        if ("client".equals(body.get("updateElement").textValue())) {
            //当client变化之后
            ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
            boolean isTop = false;
            for (Map map : list) {
                if ("authorities".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        request.setAttribute("resourceUrl", baseConfig.getModuleroleoptionsofmodule());
                        jsonNode.set("clientId", body.get("updateData"));
                        jsonNode.put("moduleId", request.getParameter("key"));
                        CommonResult moduleRoleCr = commonMethods.postResource(jsonNode, request);
                        if (CommonResultStatus.SUCCESS.toString().equals(moduleRoleCr.getStatus()) && moduleRoleCr.getResponseData().get("data") != null) {
                            map.put("items", ((Map) moduleRoleCr.getResponseData().get("data")).get("items"));
                            map.put("defaultValue", ((Map) moduleRoleCr.getResponseData().get("data")).get("defaultValue"));
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
                    continue;
                }
                if ("isTop".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                    if (map.get("defaultValue") != null) {
                        isTop = true;
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("parent".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        if (isTop) {
                            map.put("available", false);
                            map.remove("defaultValue");
                            map.remove("items");
                        } else {
                            //根据client获取父module,然后是后续的显示，注意其他的update
                            request.setAttribute("resourceUrl", baseConfig.getModuleparentoptionsofclient());
                            jsonNode.set("clientId", body.get("updateData"));
                            jsonNode.put("moduleId", request.getParameter("key"));
                            CommonResult moduleCr = commonMethods.postResource(jsonNode, request);
                            if (CommonResultStatus.SUCCESS.toString().equals(moduleCr.getStatus())) {
                                if (moduleCr.getResponseData().get("data") != null) {
                                    map.put("items", ((Map) moduleCr.getResponseData().get("data")).get("items"));
                                    map.put("defaultValue", ((Map) moduleCr.getResponseData().get("data")).get("defaultValue"));
                                }
                                map.remove("available");
                            } else {
                                map.put("available", false);
                                map.remove("defaultValue");
                                map.remove("items");
                            }
                        }
                    } else {
                        map.put("available", false);
                        map.remove("defaultValue");
                        map.remove("items");
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("iconClass".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        if (isTop) {
                            map.remove("available");
                        } else {
                            map.put("available", false);
                            map.remove("defaultValue");
                        }
                    } else {
                        map.put("available", false);
                        map.remove("defaultValue");
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("moduleUrl".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        if (isTop) {
                            map.put("available", false);
                            map.remove("defaultValue");
                        } else {
                            map.remove("available");
                        }
                    } else {
                        map.put("available", false);
                        map.remove("defaultValue");
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("moduleOrder".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("available".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("activated".equals(map.get("name"))) {
                    if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                    map.put("changed", true);
                    continue;
                }
            }

        }
        if ("isTop".equals(body.get("updateElement").textValue())) {
            //当client变化之后
            ObjectNode jsonNode = JacksonUtil.mapper.createObjectNode();
            jsonNode.put("moduleId", request.getParameter("key"));
            boolean isTop = false;
            if (body.get("updateData") != null && !body.get("updateData").isNull()) {
                isTop = true;
            }
            for (Map map : list) {
                if ("client".equals(map.get("name"))) {
                    jsonNode.put("clientId", (Integer) map.get("defaultValue"));
                }
                if ("parent".equals(map.get("name"))) {
                    if (isTop) {
                        map.put("available", false);
                        map.remove("defaultValue");
                        map.remove("items");
                    } else {
                        //根据client获取父module,然后是后续的显示，注意其他的update
                        request.setAttribute("resourceUrl", baseConfig.getModuleparentoptionsofclient());
                        CommonResult moduleCr = commonMethods.postResource(jsonNode, request);
                        if (CommonResultStatus.SUCCESS.toString().equals(moduleCr.getStatus())) {
                            if (moduleCr.getResponseData().get("data") != null) {
                                map.put("items", ((Map) moduleCr.getResponseData().get("data")).get("items"));
                                map.put("defaultValue", ((Map) moduleCr.getResponseData().get("data")).get("defaultValue"));
                            }
                            map.remove("available");
                        } else {
                            map.put("available", false);
                            map.remove("defaultValue");
                            map.remove("items");
                        }
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("iconClass".equals(map.get("name"))) {
                    if (isTop) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                        map.remove("defaultValue");
                    }
                    map.put("changed", true);
                    continue;
                }
                if ("moduleUrl".equals(map.get("name"))) {
                    if (isTop) {
                        map.put("available", false);
                        map.remove("defaultValue");
                    } else {
                        map.remove("available");
                    }
                    map.put("changed", true);
                    continue;
                }
            }
        }
        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/module/save", method = {RequestMethod.POST})
    public CommonResult saveModule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModulesave());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/module/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteModule(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getModuledelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }
}
