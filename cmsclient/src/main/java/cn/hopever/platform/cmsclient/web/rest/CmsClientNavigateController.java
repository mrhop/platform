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
public class CmsClientNavigateController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/navigate/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getNavigateList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getNavigatelist());
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
                //rule的联动
                if (body.get("filters") != null && !body.get("filters").isNull()) {
                    JsonNode website = body.get("filters").get("website");
                    if (website != null && !website.isNull()) {
                        String websiteId = website.asText();
                        request.setAttribute("resourceUrl", baseConfig.getNavigateparentoptions()+ "?websiteId=" + websiteId);
                        CommonResult navigateparentoptions = commonMethods.getResource(request);
                        List<Map> updateRules = new ArrayList<>();
                        Map map = new HashMap<>();
                        map.put("value","parent");
                        map.put("editValue",navigateparentoptions.getResponseData().get("data"));
                        updateRules.add(map);
                        c.getResponseData().put("updateRules", updateRules);
                    }
                }
                if (body.get("init") != null && !body.get("init").isNull() && body.get("init").asBoolean()) {
                    Map<String, Object> mapNavigateList = baseConfig.getTableRule("navigateList");
                    List<Map> headList = (List) mapNavigateList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("type")) {
                            List<String> navigateTypes = baseConfig.getNavigateTypes();
                            List<Map> listOptions = new ArrayList<>();
                            for (String navigateType : navigateTypes) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", navigateType);
                                mapOption.put("value", navigateType);
                                listOptions.add(mapOption);
                            }
                            map.put("editValue", listOptions);
                        } else if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapNavigateList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("navigateListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/navigate/info", method = {RequestMethod.GET})
    public CommonResult getNavigate(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("key"));
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

    @RequestMapping(value = "/navigate/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteNavigate(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/navigate/update", method = {RequestMethod.POST})
    public CommonResult updateNavigate(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/navigate/add", method = {RequestMethod.GET})
    public CommonResult addNavigate(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("websiteadd");
        List<Map> list = (List<Map>) rule.get("structure");
        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/navigate/save", method = {RequestMethod.POST})
    public CommonResult saveNavigate(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitesave());
        return commonMethods.postResource(body, request);
    }
}
