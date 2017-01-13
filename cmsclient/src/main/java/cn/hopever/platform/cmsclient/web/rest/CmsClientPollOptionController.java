package cn.hopever.platform.cmsclient.web.rest;

import cn.hopever.platform.cmsclient.config.BaseConfig;
import cn.hopever.platform.oauth2client.config.CommonProperties;
import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import com.fasterxml.jackson.databind.JsonNode;
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
public class CmsClientPollOptionController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/polloption/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getPollOptionList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getPolloptionlist() + "?pollId=" + request.getParameter("pollId"));
        CommonResult c = commonMethods.getResource(request);
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    c.getResponseData().put("totalCount", ((List) c.getResponseData().get("data")).size());
                } else {
                    c.getResponseData().put("totalCount", 0);
                }
                if (body.get("init") != null && body.get("init").asBoolean()) {
                    c.getResponseData().put("rules", baseConfig.getTableRule("pollOptionList"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/polloption/info", method = {RequestMethod.GET})
    public CommonResult getPollOption(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("polloptionupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    for (Map map : list) {
                        if ("poll".equals(map.get("name")) ) {
                            //map.put("items", mapItems.get("clients"));
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

    @RequestMapping(value = "/polloption/delete", method = {RequestMethod.DELETE})
    public CommonResult deletePollOption(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/polloption/update", method = {RequestMethod.POST})
    public CommonResult updatePollOption(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/polloption/add", method = {RequestMethod.GET})
    public CommonResult addPollOption(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("polloptionadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("poll".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));

                continue;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/polloption/save", method = {RequestMethod.POST})
    public CommonResult savePollOption(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitesave());
        return commonMethods.postResource(body, request);
    }

}
