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

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin
public class CmsClientOperationController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/operation/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getOperationList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getOptionlist());
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
                    c.getResponseData().put("rules", baseConfig.getTableRule("optionList"));
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("optionListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/operation/info", method = {RequestMethod.GET})
    public CommonResult getOperation(HttpServletRequest request) throws Exception {
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

    @RequestMapping(value = "/operation/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteOperation(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/operation/update", method = {RequestMethod.POST})
    public CommonResult updateOperation(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/operation/add", method = {RequestMethod.GET})
    public CommonResult addOperation(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("websiteadd");
        List<Map> list = (List<Map>) rule.get("structure");
        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/operation/save", method = {RequestMethod.POST})
    public CommonResult saveOperation(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitesave());
        return commonMethods.postResource(body, request);
    }
}
