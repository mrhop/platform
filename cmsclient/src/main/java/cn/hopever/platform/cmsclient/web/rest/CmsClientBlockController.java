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
public class CmsClientBlockController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/block/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getBlockList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getBlocklist());
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
                    Map<String, Object> mapBlockList = baseConfig.getTableRule("blockList");
                    List<Map> headList = (List) mapBlockList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("type")) {
                            List<String> blockTypes = baseConfig.getBlockTypes();
                            List<Map> listOptions = new ArrayList<>();
                            for (String blockType : blockTypes) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", blockType);
                                mapOption.put("value", blockType);
                                listOptions.add(mapOption);
                            }
                            map.put("editValue", listOptions);
                        } else if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapBlockList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("blockListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/block/info", method = {RequestMethod.GET})
    public CommonResult getBlock(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getBlockinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("blockupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意是否需要有相关的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    // List<Map> listReturn = new ArrayList<>();
                    String blockTypeSelected = null;
                    String websiteId = null;
                    for (Map map : list) {
                        if ("type".equals(map.get("name"))) {
                            List<String> blockTypes = baseConfig.getBlockTypes();
                            List<Map> listOptions = new ArrayList<>();
                            for (String blockType : blockTypes) {
                                Map mapOption = new HashMap<>();
                                mapOption.put("label", blockType);
                                mapOption.put("value", blockType);
                                listOptions.add(mapOption);
                            }
                            map.put("items", listOptions);
                            if (mapData.get(map.get("name")) != null) {
                                map.put("defaultValue", mapData.get(map.get("name")));
                                blockTypeSelected = mapData.get(map.get("name")).toString();
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
                        if ("content".equals(map.get("name")) && blockTypeSelected != null && "静态内容".equals(blockTypeSelected)) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
                            continue;
                        }
                        if ("dataUrl".equals(map.get("name")) && blockTypeSelected != null && "自定义内容".equals(blockTypeSelected)) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
                            continue;
                        }
                        if ("script".equals(map.get("name")) && blockTypeSelected != null && "自定义内容".equals(blockTypeSelected)) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
                            continue;
                        }
                        if ("newsType".equals(map.get("name")) && blockTypeSelected != null && ("热点新闻".equals(blockTypeSelected) || "最新新闻".equals(blockTypeSelected))) {
                            if (websiteId != null) {
                                request.setAttribute("resourceUrl", baseConfig.getNewstypeoptionsofwebsite() + "?websiteId=" + websiteId);
                                CommonResult usernamesResult = commonMethods.getResource(request);
                                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                    map.put("items", usernamesResult.getResponseData().get("data"));
                                }
                            }
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
                            continue;
                        }
                        if ("newsNumber".equals(map.get("name")) && blockTypeSelected != null && ("热点新闻".equals(blockTypeSelected) || "最新新闻".equals(blockTypeSelected))) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
                            continue;
                        }

                        if ("poll".equals(map.get("name"))) {
                            if (blockTypeSelected != null && "投票".equals(blockTypeSelected)) {
                                if (websiteId != null) {
                                    request.setAttribute("resourceUrl", baseConfig.getPolloptions() + "?websiteId=" + websiteId);
                                    CommonResult usernamesResult = commonMethods.getResource(request);
                                    if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                        map.put("items", usernamesResult.getResponseData().get("data"));
                                    }
                                }
                                map.put("defaultValue", mapData.get(map.get("name")));
                                map.remove("available");
                            }
                            continue;
                        }
                        if ("fileLibraryType".equals(map.get("name")) && blockTypeSelected != null && "文件库".equals(blockTypeSelected)) {
                            if (websiteId != null) {
                                request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeoptionsofwebsite() + "?websiteId=" + websiteId);
                                CommonResult usernamesResult = commonMethods.getResource(request);
                                if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                                    map.put("items", usernamesResult.getResponseData().get("data"));
                                }
                            }
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
                            continue;
                        }
                        if ("fileLibraryNumber".equals(map.get("name")) && blockTypeSelected != null && "文件库".equals(blockTypeSelected)) {
                            map.put("defaultValue", mapData.get(map.get("name")));
                            map.remove("available");
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

    @RequestMapping(value = "/block/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteBlock(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getBlockdelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/block/update", method = {RequestMethod.POST})
    public CommonResult updateBlock(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getBlockupdate());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/block/add", method = {RequestMethod.GET})
    public CommonResult addBlock(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("blockadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
            if ("type".equals(map.get("name"))) {
                List<String> blockTypes = baseConfig.getBlockTypes();
                List<Map> listOptions = new ArrayList<>();
                for (String blockType : blockTypes) {
                    Map mapOption = new HashMap<>();
                    mapOption.put("label", blockType);
                    mapOption.put("value", blockType);
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
        }
        c.setResponseData(rule);
        c.setStatus(CommonResultStatus.SUCCESS.toString());
        return c;
    }

    @RequestMapping(value = "/block/save", method = {RequestMethod.POST})
    public CommonResult saveBlock(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getBlocksave());
        return commonMethods.postResource(body, request);
    }

    @RequestMapping(value = "/block/rule/update", method = {RequestMethod.POST})
    public CommonResult updateRule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = JacksonUtil.mapper.convertValue(body.get("rule"), Map.class);
        List<Map> list = (List<Map>) rule.get("structure");
        String blockTypeSelected = null;
        String websiteId = null;
        for (Map map : list) {
            map.remove("changed");
            if ("website".equals(map.get("name"))) {
                if ("website".equals(body.get("updateElement").asText())) {
                    websiteId = (body.get("updateData") != null && !body.get("updateData").isNull()) ? body.get("updateData").asText() : null;
                }
                continue;
            }
            if ("type".equals(map.get("name"))) {
                if ("type".equals(body.get("updateElement").asText())) {
                    blockTypeSelected = (body.get("updateData") != null && !body.get("updateData").isNull()) ? body.get("updateData").asText() : null;
                }
                continue;
            }
            if ("content".equals(map.get("name")) && "type".equals(body.get("updateElement").asText())) {
                if (blockTypeSelected != null && "静态内容".equals(blockTypeSelected)) {
                    map.remove("available");
                } else {
                    map.put("available", false);
                }
                map.put("changed", true);
                continue;
            }
            if (("dataUrl".equals(map.get("name")) || "script".equals(map.get("name"))) && "type".equals(body.get("updateElement").asText())) {
                if (blockTypeSelected != null && "自定义内容".equals(blockTypeSelected)) {
                    map.remove("available");
                } else {
                    map.put("available", false);
                }
                map.put("changed", true);
                continue;
            }
            if ("newsType".equals(map.get("name")) || "newsNumber".equals(map.get("name"))) {
                if ("type".equals(body.get("updateElement").asText())) {
                    if (blockTypeSelected != null && ("热点新闻".equals(blockTypeSelected) || "最新新闻".equals(blockTypeSelected))) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                }
                if ("website".equals(body.get("updateElement").asText()) && "newsType".equals(map.get("name"))) {
                    if (websiteId != null) {
                        request.setAttribute("resourceUrl", baseConfig.getNewstypeoptionsofwebsite() + "?websiteId=" + websiteId);
                        CommonResult usernamesResult = commonMethods.getResource(request);
                        if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                            map.put("items", usernamesResult.getResponseData().get("data"));
                        }
                    } else {
                        map.put("items", null);
                    }
                }
                map.put("changed", true);
                continue;
            }
            if ("poll".equals(map.get("name"))) {
                if ("type".equals(body.get("updateElement").asText())) {
                    if (blockTypeSelected != null && "投票".equals(blockTypeSelected)) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                }
                if ("website".equals(body.get("updateElement").asText())) {
                    if (websiteId != null) {
                        request.setAttribute("resourceUrl", baseConfig.getPolloptions() + "?websiteId=" + websiteId);
                        CommonResult usernamesResult = commonMethods.getResource(request);
                        if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                            map.put("items", usernamesResult.getResponseData().get("data"));
                        }
                    } else {
                        map.put("items", null);
                    }
                }
                map.put("changed", true);
                continue;
            }
            if ("fileLibraryType".equals(map.get("name")) || "fileLibraryNumber".equals(map.get("name"))) {
                if ("type".equals(body.get("updateElement").asText())) {
                    if (blockTypeSelected != null && "文件库".equals(blockTypeSelected)) {
                        map.remove("available");
                    } else {
                        map.put("available", false);
                    }
                }
                if ("website".equals(body.get("updateElement").asText()) && "fileLibraryType".equals(map.get("name"))) {
                    if (websiteId != null) {
                        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeoptionsofwebsite() + "?websiteId=" + websiteId);
                        CommonResult usernamesResult = commonMethods.getResource(request);
                        if (CommonResultStatus.SUCCESS.toString().equals(usernamesResult.getStatus()) && usernamesResult.getResponseData().get("data") != null) {
                            map.put("items", usernamesResult.getResponseData().get("data"));
                        }
                    } else {
                        map.put("items", null);
                    }
                }
                map.put("changed", true);
                continue;
            }
        }
        c.setResponseData(rule);
        return c;
    }
}
