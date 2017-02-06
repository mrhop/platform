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
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin
public class CmsClientFileLibraryController {
    @Autowired
    private BaseConfig baseConfig;
    @Autowired
    private CommonProperties commonProperties;
    @Autowired
    private CommonMethods commonMethods;

    @RequestMapping(value = "/filelibrary/list", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult getFileLibraryList(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarylist());
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
                        request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeoptionsofwebsite() + "?websiteId=" + websiteId);
                        CommonResult filelibrarytypeoptions = commonMethods.getResource(request);
                        List<Map> updateRules = new ArrayList<>();
                        Map map = new HashMap<>();
                        map.put("value", "fileLibraryType");
                        map.put("editValue", filelibrarytypeoptions.getResponseData().get("data"));
                        updateRules.add(map);
                        c.getResponseData().put("updateRules", updateRules);
                    }
                }
                if (body.get("init") != null && !body.get("init").isNull() && body.get("init").asBoolean()) {
                    Map<String, Object> mapFileLibraryList = baseConfig.getTableRule("fileLibraryList");
                    List<Map> headList = (List) mapFileLibraryList.get("thead");
                    for (Map<String, Object> map : headList) {
                        if (map.get("value").equals("isPublished")) {
                            List<Map> listOptions = new ArrayList<>();
                            Map mapOptionY = new HashMap<>();
                            mapOptionY.put("label", "Y");
                            mapOptionY.put("value", "true");
                            listOptions.add(mapOptionY);
                            Map mapOptionN = new HashMap<>();
                            mapOptionN.put("label", "N");
                            mapOptionN.put("value", "false");
                            listOptions.add(mapOptionN);
                            map.put("editValue", listOptions);
                        } else if (map.get("value").equals("website")) {
                            request.setAttribute("resourceUrl", baseConfig.getWebsiteoptions());
                            CommonResult c1 = commonMethods.getResource(request);
                            map.put("editValue", c1.getResponseData().get("data"));
                        }
                    }
                    c.getResponseData().put("rules", mapFileLibraryList);
                    c.getResponseData().put("additionalFeature", ((Map) baseConfig.getMapRules().get("tableRules")).get("fileLibraryListAdditionalFeature"));
                }
            }
        }
        return c;
    }

    @RequestMapping(value = "/filelibrary/info", method = {RequestMethod.GET})
    public CommonResult getFileLibrary(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibraryinfo() + "?id=" + request.getParameter("key"));
        CommonResult c = commonMethods.getResource(request);
        Map<String, Object> rule = baseConfig.getFormRule("filelibraryupdate");
        List<Map> list = (List<Map>) rule.get("structure");

        //注意后台的处理需要进行modulerole和是否内部角色以及授权类型的处理
        if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
            if (c.getResponseData() != null) {
                if (c.getResponseData().get("data") != null) {
                    Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                    String websiteId = null;
                    boolean isPublished = false;
                    for (Map map : list) {
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
                        if ("fileLibraryType".equals(map.get("name"))) {
                            if (websiteId != null) {
                                request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeoptionsofwebsite() + "?websiteId=" + websiteId);
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
                        if ("isPublished".equals(map.get("name"))) {
                            if ((boolean) mapData.get(map.get("name"))) {
                                map.put("defaultValue", new Object[]{mapData.get(map.get("name"))});
                                isPublished = true;
                            }
                            continue;
                        }
                        if ("publishDate".equals(map.get("name")) && isPublished) {
                            map.remove("available");
                            map.put("defaultValue", mapData.get(map.get("name")));
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

    @RequestMapping(value = "/filelibrary/delete", method = {RequestMethod.DELETE})
    public CommonResult deleteFileLibrary(HttpServletRequest request) throws Exception {
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarydelete() + "?id=" + request.getParameter("key"));
        return commonMethods.getResource(request);
    }

    @RequestMapping(value = "/filelibrary/update", method = {RequestMethod.POST})
    public CommonResult updateFileLibrary(HttpServletRequest request, @RequestPart("file") MultipartFile[] files) throws Exception {
        String file = null;
        if (files != null && files.length > 0) {
            String resourceAddress = "";
            request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("website"));
            CommonResult c = commonMethods.getResource(request);
            if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
                if (c.getResponseData() != null) {
                    if (c.getResponseData().get("data") != null) {
                        Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                        resourceAddress = mapData.get("resourceAddress").toString();
                    }
                }
            }
            request.setAttribute("resourceUrl", commonProperties.getImageUpload());
            request.setAttribute("filePath", resourceAddress);
            CommonResult cr = this.commonMethods.postFile(request, files);
            if (CommonResultStatus.SUCCESS.toString().equals(cr.getStatus()) && cr.getResponseData().get("data") != null) {
                List<String> list = ((Map<String, List>) cr.getResponseData().get("data")).get("fileKeys");
                if (list != null && list.size() > 0) {
                    file = commonProperties.getImagePathPrev() + list.get(0);
                }
            }
        }
        HashMap map = new HashMap<>();
        Set<String> set = request.getParameterMap().keySet();
        for (String key : set) {
            if (key.equals("isPublished")) {
                map.put(key, request.getParameterValues(key));
            } else {
                String value = request.getParameter(key);
                if (value != null && value.length() > 0) {
                    map.put(key, value);
                }
            }
        }
        map.put("url", file);
        request.setAttribute("resourceUrl", baseConfig.getFilelibraryupdate());
        return commonMethods.postResource(map, request);
    }

    @RequestMapping(value = "/filelibrary/add", method = {RequestMethod.GET})
    public CommonResult addFileLibrary(HttpServletRequest request) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = baseConfig.getFormRule("filelibraryadd");
        List<Map> list = (List<Map>) rule.get("structure");
        for (Map map : list) {
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

    @RequestMapping(value = "/filelibrary/save", method = {RequestMethod.POST})
    public CommonResult saveFileLibrary(HttpServletRequest request, @RequestPart("file") MultipartFile[] files) throws Exception {
        String file = null;
        if (files != null && files.length > 0) {
            String resourceAddress = "";
            request.setAttribute("resourceUrl", baseConfig.getWebsiteinfo() + "?id=" + request.getParameter("website"));
            CommonResult c = commonMethods.getResource(request);
            if (CommonResultStatus.SUCCESS.toString().equals(c.getStatus())) {
                if (c.getResponseData() != null) {
                    if (c.getResponseData().get("data") != null) {
                        Map<String, Object> mapData = (Map) c.getResponseData().get("data");
                        resourceAddress = mapData.get("resourceAddress").toString();
                    }
                }
            }
            request.setAttribute("resourceUrl", commonProperties.getImageUpload());
            request.setAttribute("filePath", resourceAddress);
            CommonResult cr = this.commonMethods.postFile(request, files);
            if (CommonResultStatus.SUCCESS.toString().equals(cr.getStatus()) && cr.getResponseData().get("data") != null) {
                List<String> list = ((Map<String, List>) cr.getResponseData().get("data")).get("fileKeys");
                if (list != null && list.size() > 0) {
                    file = commonProperties.getImagePathPrev() + list.get(0);
                }
            }
        }
        HashMap map = new HashMap<>();
        Set<String> set = request.getParameterMap().keySet();
        for (String key : set) {
            if (key.equals("isPublished")) {
                map.put(key, request.getParameterValues(key));
            } else {
                String value = request.getParameter(key);
                if (value != null && value.length() > 0) {
                    map.put(key, value);
                }
            }
        }
        map.put("url", file);
        request.setAttribute("resourceUrl", baseConfig.getFilelibrarysave());
        return commonMethods.postResource(map, request);
    }

    @RequestMapping(value = "/filelibrary/rule/update", method = {RequestMethod.POST})
    public CommonResult updateRule(HttpServletRequest request, @RequestBody JsonNode body) throws Exception {
        CommonResult c = new CommonResult();
        Map<String, Object> rule = JacksonUtil.mapper.convertValue(body.get("rule"), Map.class);
        List<Map> list = (List<Map>) rule.get("structure");
        Long websiteId = null;
        Boolean isPublished = null;
        for (Map map : list) {
            map.remove("changed");
            if ("website".equals(map.get("name")) && "website".equals(body.get("updateElement").asText())) {
                websiteId = body.get("updateData") != null && !body.get("updateData").isNull() ? body.get("updateData").asLong() : null;
                continue;
            }
            if ("fileLibraryType".equals(map.get("name")) && "website".equals(body.get("updateElement").asText())) {
                if (websiteId != null) {
                    request.setAttribute("resourceUrl", baseConfig.getFilelibrarytypeoptionsofwebsite() + "?websiteId=" + websiteId);
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
            if ("isPublished".equals(map.get("name")) && "isPublished".equals(body.get("updateElement").asText())) {
                isPublished = (body.get("updateData") != null && !body.get("updateData").isNull()) ? true : false;
                continue;
            }
            if ("publishDate".equals(map.get("name")) && "isPublished".equals(body.get("updateElement").asText())) {
                if (isPublished) {
                    map.remove("available");
                } else {
                    map.put("available", false);
                }
                map.put("changed", true);
                continue;
            }
        }
        c.setResponseData(rule);
        return c;
    }

}
