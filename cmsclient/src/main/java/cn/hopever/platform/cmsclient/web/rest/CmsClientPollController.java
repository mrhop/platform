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
public class CmsClientPollController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/poll/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getPollList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPolllist());
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
                    Map<String, Object> mapPollList = baseConfig.getTableRule("pollList");
                    List<Map> headList = (List) mapPollList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapPollList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("pollListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/poll/info", method = {RequestMethod.GET})
    public CommonResult getPoll(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPollinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("pollupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
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

    @RequestMapping(value = "/poll/delete", method = {RequestMethod.DELETE})
    public CommonResult deletePoll(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPolldelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/poll/update", method = {RequestMethod.POST})
    public CommonResult updatePoll(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPollupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/poll/add", method = {RequestMethod.GET})
    public CommonResult addPoll(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("polladd");
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
        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/poll/save", method = {RequestMethod.POST})
    public CommonResult savePoll(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPollsave());
        return commonMethods.postResource(body, request);
    }
}
