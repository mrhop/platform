package cn.hopever.platform.cmsclient.web.rest;

import cn.hopever.platform.cmsclient.config.BaseConfig;
import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
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
public class CmsClientResourceController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/resource/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getResourceList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getResourcelist());
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
                    Map<String, Object> mapResourceList = baseConfig.getTableRule("resourceList");
                    List<Map> headList = (List) mapResourceList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("name").equals("type")) {
                            List<String> resourceTypes = baseConfig.getResourceTypes();
                            List<Map> listOptions = new ArrayList<>();
                            for (String resourceType : resourceTypes) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", resourceType);
                                mapOption.put("value", resourceType);
                                listOptions.add(mapOption);
                            }
                            map.put("items", listOptions);
                        } else if (map.get("name").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("items", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapResourceList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("resourceListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/resource/info", method = {RequestMethod.GET})
    public CommonResult getResource(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getResourceinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("resourceupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if ("type".equals(map.get("name")) ) {
                            List<String> resourceTypes = baseConfig.getResourceTypes();
                            List<Map> listOptions = new ArrayList<>();
                            for (String resourceType : resourceTypes) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", resourceType);
                                mapOption.put("value", resourceType);
                                listOptions.add(mapOption);
                            }
                            map.put("items", listOptions);
                            if(mapData.get(map.get("name"))!=null){
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
                            continue;
                        }
                        if ("website".equals(map.get("name")) ) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult usernamesResult = commonMethods.getResource(request);
                            if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                map.put("items", usernamesResult.getResponseData().get("data"));
                            }
                            if(mapData.get(map.get("name"))!=null){
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
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

    @RequestMapping(value = "/resource/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteResource(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getResourcedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/resource/update", method = {RequestMethod.POST})
    public CommonResult updateResource(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getResourceupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/resource/add", method = {RequestMethod.GET})
    public CommonResult addResource(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("resourceadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("type".equals(map.get("name")) ) {
                List<String> resourceTypes = baseConfig.getResourceTypes();
                List<Map> listOptions = new ArrayList<>();
                for (String resourceType : resourceTypes) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", resourceType);
                    mapOption.put("value", resourceType);
                    listOptions.add(mapOption);
                }
                map.put("items", listOptions);
                continue;
            }
            if ("website".equals(map.get("name")) ) {
                request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                CommonResult usernamesResult = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                    map.put("items", usernamesResult.getResponseData().get("data"));
                }
                continue;
            }
        }
        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/resource/save", method = {RequestMethod.POST})
    public CommonResult saveResource(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getResourcesave());
        return commonMethods.postResource(body, request);
    }
}
