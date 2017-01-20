package cn.hopever.platform.cmsclient.web.rest;

import cn.hopever.platform.cmsclient.config.BaseConfig;
import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.utils.json.JacksonUtil;
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
public class CmsClientTemplateController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/template/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getTemplateList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getTemplatelist());
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
                    Map<String, Object> mapTemplateList = baseConfig.getTableRule("templateList");
                    List<Map> headList = (List) mapTemplateList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapTemplateList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("templateListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/template/info", method = {RequestMethod.GET})
    public CommonResult getTemplate(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getTemplateinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("templateupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    String websiteId = null;
                    for (Map map : list) {
                        if ("layoutType".equals(map.get("name"))) {
                            List<String> layoutTypes = baseConfig.getTemplateLayoutTypes();
                            List<Map> listOptions = new ArrayList<>();
                            for (String layoutType : layoutTypes) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", layoutType);
                                mapOption.put("value", layoutType);
                                listOptions.add(mapOption);
                            }
                            map.put("items", listOptions);
                            if (mapData.get(map.get("name")) != null) {
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
                            continue;
                        }
                        if ("layoutScale".equals(map.get("name"))) {
                            List<String> layoutScales = baseConfig.getTemplateLayoutScales();
                            List<Map> listOptions = new ArrayList<>();
                            for (String layoutScale : layoutScales) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", layoutScale);
                                mapOption.put("value", layoutScale);
                                listOptions.add(mapOption);
                            }
                            map.put("items", listOptions);
                            if (mapData.get(map.get("name")) != null) {
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
                            continue;
                        }
                        if ("website".equals(map.get("name"))) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult usernamesResult = commonMethods.getResource(request);
                            if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                map.put("items", usernamesResult.getResponseData().get("data"));
                            }
                            if (mapData.get(map.get("name")) != null) {
                                map.put("defaultValue", mapData.get(map.get("name")));
                                websiteId = mapData.get(map.get("name")).toString();
                            }
                            continue;
                        }
                        if ("templateBlocks".equals(map.get("name"))) {
                            if (websiteId != null) {
                                request.setAttribute("resourceUrl", baseConfig.getBlockoptions() + "?websiteId=" + websiteId);
                                CommonResult usernamesResult = commonMethods.getResource(request);
                                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                    map.put("items", usernamesResult.getResponseData().get("data"));
                                }
                            }
                            if (mapData.get(map.get("name")) != null) {
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
                            continue;
                        }
                        if ("templateResources".equals(map.get("name"))) {
                            if (websiteId != null) {
                                request.setAttribute("resourceUrl", baseConfig.getResourceoptions() + "?websiteId=" + websiteId);
                                CommonResult usernamesResult = commonMethods.getResource(request);
                                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                    map.put("items", usernamesResult.getResponseData().get("data"));
                                }
                            }
                            if (mapData.get(map.get("name")) != null) {
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
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

    @RequestMapping(value = "/template/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteTemplate(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getTemplatedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/template/update", method = {RequestMethod.POST})
    public CommonResult updateTemplate(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getTemplateupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/template/add", method = {RequestMethod.GET})
    public CommonResult addTemplate(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("templateadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("layoutType".equals(map.get("name"))) {
                List<String> layoutTypes = baseConfig.getTemplateLayoutTypes();
                List<Map> listOptions = new ArrayList<>();
                for (String layoutType : layoutTypes) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", layoutType);
                    mapOption.put("value", layoutType);
                    listOptions.add(mapOption);
                }
                map.put("items", listOptions);
                continue;
            }
            if ("layoutScale".equals(map.get("name"))) {
                List<String> layoutScales = baseConfig.getTemplateLayoutScales();
                List<Map> listOptions = new ArrayList<>();
                for (String layoutScale : layoutScales) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", layoutScale);
                    mapOption.put("value", layoutScale);
                    listOptions.add(mapOption);
                }
                map.put("items", listOptions);
                continue;
            }
            if ("website".equals(map.get("name"))) {
                request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                CommonResult usernamesResult = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                    map.put("items", usernamesResult.getResponseData().get("data"));
                }
                continue;
            }
            if ("templateBlocks".equals(map.get("name"))) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
            if ("templateResources".equals(map.get("name"))) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
        }
        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/template/save", method = {RequestMethod.POST})
    public CommonResult saveTemplate(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getTemplatesave());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/template/rule/update", method = {RequestMethod.POST})
    public CommonResult updateRule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = JacksonUtil.mapper.convertValue(body.get("rule"), Map.class);
        List<Map> list = (List<Map>) rule.get("structure");
        Long websiteId = null;
        for (Map map : list) {
            map.remove("changed");
            if ("website".equals(map.get("name")) && "website".equals(body.get("updateElement").asText())) {
                websiteId = body.get("updateData") != null && !body.get("updateData").isNull() ? body.get("updateData").asLong() : null;
                continue;
            }
            if ( "templateBlocks".equals(map.get("name"))) {
                if(websiteId != null){
                    request.setAttribute("resourceUrl", baseConfig.getBlockoptions() + "?websiteId=" + websiteId);
                    CommonResult usernamesResult = commonMethods.getResource(request);
                    if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                        map.put("items", usernamesResult.getResponseData().get("data"));
                    }
                }else{
                    map.put("items",null);
                }
                map.put("changed", true);
                continue;
            }
            if ( "templateResources".equals(map.get("name"))) {
                if(websiteId != null){
                    request.setAttribute("resourceUrl", baseConfig.getResourceoptions() + "?websiteId=" + websiteId);
                    CommonResult usernamesResult = commonMethods.getResource(request);
                    if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                        map.put("items", usernamesResult.getResponseData().get("data"));
                    }
                }else{
                    map.put("items",null);
                }
                map.put("changed", true);
                continue;
            }
        }
        c.setResponseData(rule);
        return c;
    }
}
