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
public class CmsClientFileLibraryTypeController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/filelibrarytype/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getFileLibraryTypeList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypelist());
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
                        request.setAttribute("resourceUrl", baseConfig.getTemplateoptionsofwebsite()+ "?websiteId=" + websiteId);
                        CommonResult templateoptions = commonMethods.getResource(request);
                        List<Map> updateRules = new ArrayList<>();
                        Map map = new HashMap<>();
                        map.put("value","template");
                        map.put("editValue",templateoptions.getResponseData().get("data"));
                        updateRules.add(map);
                        c.getResponseData().put("updateRules", updateRules);
                    }
                }
                if (body.get("init") != null && !body.get("init").isNull() && body.get("init").asBoolean()) {
                    Map<String, Object> mapFileLibraryTypeList = baseConfig.getTableRule("fileLibraryTypeList");
                    List<Map> headList = (List) mapFileLibraryTypeList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapFileLibraryTypeList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("fileLibraryTypeListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/filelibrarytype/info", method = {RequestMethod.GET})
    public CommonResult getFileLibraryType(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("filelibrarytypeupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    String websiteId = null;
                    for (Map map : list) {
                        if ("website".equals(map.get("name")) ) {
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
                        if ("template".equals(map.get("name"))) {
                            if (websiteId != null) {
                                request.setAttribute("resourceUrl", baseConfig.getTemplateoptionsofwebsite() + "?websiteId=" + websiteId);
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
                            // listReturn.add(map);
                        }
                    }
                }
            }
        }
        c.setResponseData(rule);
        return c;
    }

    @RequestMapping(value = "/filelibrarytype/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteFileLibraryType(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/filelibrarytype/update", method = {RequestMethod.POST})
    public CommonResult updateFileLibraryType(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/filelibrarytype/add", method = {RequestMethod.GET})
    public CommonResult addFileLibraryType(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("filelibrarytypeadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("website".equals(map.get("name")) ) {
                request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                CommonResult usernamesResult = commonMethods.getResource(request);
                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                    map.put("items", usernamesResult.getResponseData().get("data"));
                }
                continue;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/filelibrarytype/save", method = {RequestMethod.POST})
    public CommonResult saveFileLibraryType(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypesave());
        return commonMethods.postResource(body, request);
    }


    @RequestMapping(value = "/filelibrarytype/rule/update", method = {RequestMethod.POST})
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
            if ("template".equals(map.get("name"))) {
                if (websiteId != null) {
                    request.setAttribute("resourceUrl", baseConfig.getTemplateoptionsofwebsite() + "?websiteId=" + websiteId);
                    CommonResult usernamesResult = commonMethods.getResource(request);
                    if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                        map.put("items", usernamesResult.getResponseData().get("data"));
                    }
                } else {
                    map.put("items", null);
                }
                map.put("changed", true);
                continue;
            }
        }
        c.setResponseData(rule);
        return c;
    }
}
