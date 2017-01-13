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
                    Map<String, Object> mapOptionList = baseConfig.getTableRule("operationList");
                    List<Map> headList = (List) mapOptionList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("relatedOperation")) {
                            List<Map> listOptions = new ArrayList<>();
                            List<String> relatedOperations = baseConfig.getRelatedOperations();
                            for(String relatedOperation:relatedOperations){
                                Map mapOption = new HashMap<>();
                                mapOption.put("label",relatedOperation);
                                mapOption.put("value",relatedOperation);
                                listOptions.add(mapOption);
                            }
                            map.put("editValue", listOptions);
                        } else if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapOptionList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("operationListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/operation/info", method = {RequestMethod.GET})
    public CommonResult getOperation(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("operationupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    for (Map map : list) {
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

    //add 没有界面
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
