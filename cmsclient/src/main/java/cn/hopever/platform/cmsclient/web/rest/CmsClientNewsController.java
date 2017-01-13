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
public class CmsClientNewsController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/news/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getNewsList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getNewslist());
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
                        request.setAttribute("resourceUrl", baseConfig.getNewstypeoptionsofwebsite()+ "?websiteId=" + websiteId);
                        CommonResult newstypeoptions = commonMethods.getResource(request);
                        List<Map> updateRules = new ArrayList<>();
                        Map map = new HashMap<>();
                        map.put("value","newsType");
                        map.put("editValue",newstypeoptions.getResponseData().get("data"));
                        updateRules.add(map);
                        c.getResponseData().put("updateRules", updateRules);
                    }
                }
                if (body.get("init") != null && !body.get("init").isNull() && body.get("init").asBoolean()) {
                    Map<String, Object> mapNewsList = baseConfig.getTableRule("newsList");
                    List<Map> headList = (List) mapNewsList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("isPublished")) {
                            List<Map> listOptions = new ArrayList<>();
                            Map mapOptionY = new HashMap<>();
                            mapOptionY.put("label", "Y");
                            mapOptionY.put("value", true);
                            listOptions.add(mapOptionY);
                            Map mapOptionN = new HashMap<>();
                            mapOptionN.put("label", "N");
                            mapOptionN.put("value", false);
                            listOptions.add(mapOptionN);
                            map.put("editValue", listOptions);
                        } else if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapNewsList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("clientListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/news/info", method = {RequestMethod.GET})
    public CommonResult getNews(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("clientupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    for (Map map : list) {
                        if ("newsType".equals(map.get("name")) ) {
                            //map.put("items", mapItems.get("clients"));
                            if(mapData.get(map.get("name"))!=null){
                                map.put("defaultValue", mapData.get(map.get("name")));
                                //关联type的处理
                            }
                            continue;
                        }
                        if ("isPublished".equals(map.get("name")) ) {
                            //map.put("items", mapItems.get("clients"));
                            if((boolean) mapData.get(map.get("name"))){
                                map.put("defaultValue", new Object[]{mapData.get(map.get("name"))});
                            }
                            //将publishdate显示处理
                            continue;
                        }
                        if ("website".equals(map.get("name")) ) {
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

    @RequestMapping(value = "/news/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteNews(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitedelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/news/update", method = {RequestMethod.POST})
    public CommonResult updateNews(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsiteupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/news/add", method = {RequestMethod.GET})
    public CommonResult addNews(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("websiteadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("newsType".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
            if ("isPublished".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
            if ("website".equals(map.get("name")) ) {
                //map.put("items", mapItems.get("clients"));
                continue;
            }
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/news/save", method = {RequestMethod.POST})
    public CommonResult saveNews(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getWebsitesave());
        return commonMethods.postResource(body, request);
    }
}
