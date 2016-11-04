package cn.hopever.platform.userclient.web.rest;

import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.userclient.config.BaseConfig;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<String, Object> rule = (HashMap) ((Map) baseConfig.getMapRules().get("formRules")).get("user");
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
                        if("id".equals(map.get("name"))){
                            map.put("defaultValue", mapData.get("internalId"));
                        }
                        if("authorities".equals(map.get("name"))){
                            map.put("defaultValue", (((List<Map>)mapData.get("authorities")).get(0).get("internalId")));
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
                }else{
                    map.put("items", new ArrayList());
                }
                // listReturn.add(map);
                break;
            }
        }

        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/user/update", method = {RequestMethod.POST})
    public CommonResult updateUser(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPersonalinfo());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/user/add", method = {RequestMethod.POST})
    public CommonResult addUser(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPersonalinfo());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/user/save", method = {RequestMethod.POST})
    public CommonResult saveUser(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPersonalinfo());
        return commonMethods.postResource(body, request);
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
                    c.getResponseData().put("rules", ((Map) baseConfig.getMapRules().get("tableRules")).get("userList"));
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
                    c.getResponseData().put("rules", ((Map) baseConfig.getMapRules().get("tableRules")).get("roleList"));
                }
            }
        }
        return c;
    }
}
