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
public class CmsClientNewsTypeController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/newstype/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getNewsTypeList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getNewstypelist());
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
                    Map<String, Object> mapNewsTypeList = baseConfig.getTableRule("newsTypeList");
                    List<Map> headList = (List) mapNewsTypeList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapNewsTypeList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("newsTypeListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/newstype/info", method = {RequestMethod.GET})
    public CommonResult getNewsType(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("newstypeupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if ("website".equals(map.get("name")) ) {
                            //map.put("items", mapItems.get("clients"));
                            if(mapData.get(map.get("name"))!=null){
                                map.put("defaultValue", mapData.get(map.get("name")));
                            }
                            continue;
                        }
                        if ("newsListTemplate".equals(map.get("name")) ) {
                            //map.put("items", mapItems.get("clients"));
                            if(mapData.get(map.get("name"))!=null){
                                map.put("defaultValue", mapData.get(map.get("name")));
                                //关联newsListTemplate的处理
                            }
                            continue;
                        }
                        if ("newsTemplate".equals(map.get("name")) ) {
                            //map.put("items", mapItems.get("clients"));
                            if(mapData.get(map.get("name"))!=null){
                                map.put("defaultValue", mapData.get(map.get("name")));
                                //关联newsTemplate的处理
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

    @RequestMapping(value = "/newstype/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteNewsType(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/newstype/update", method = {RequestMethod.POST})
    public CommonResult updateNewsType(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/newstype/add", method = {RequestMethod.GET})
    public CommonResult addNewsType(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("newstypeadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("website".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
            if ("newsListTemplate".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
            if ("newsTemplate".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));

                continue;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/newstype/save", method = {RequestMethod.POST})
    public CommonResult saveNewsType(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitesave());
        return commonMethods.postResource(body, request);
    }
}
