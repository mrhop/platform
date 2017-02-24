package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.FileLibraryTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.service.FileLibraryTableService;
import cn.hopever.platform.cms.service.FileLibraryTypeTableService;
import cn.hopever.platform.cms.service.WebsiteTableService;
import cn.hopever.platform.utils.json.JacksonUtil;
import cn.hopever.platform.utils.tools.DateFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/filelibrary", produces = "application/json")
public class FileLibraryController {
    Logger logger = LoggerFactory.getLogger(FileLibraryController.class);

    @Autowired
    private WebsiteTableService websiteTableService;

    @Autowired
    private FileLibraryTypeTableService fileLibraryTypeTableService;
    @Autowired
    private FileLibraryTableService fileLibraryTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public Map getList(@RequestBody JsonNode body, Principal principal) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Page<FileLibraryTable> list;
        PageRequest pageRequest;
        if (body.get("sort") == null || body.get("sort").isNull()) {
            pageRequest = new PageRequest(body.get("currentPage").asInt(), body.get("rowSize").asInt(), Sort.Direction.ASC, "id");
        } else {
            pageRequest = new PageRequest(body.get("currentPage").asInt(), body.get("rowSize").asInt(), Sort.Direction.fromString(body.get("sort").get("sortDirection").textValue()), body.get("sort").get("sortName").textValue());
        }
        Map<String, Object> filterMap = new HashMap<>();
        if (body.get("filters") != null && !body.get("filters").isNull()) {
            filterMap = JacksonUtil.mapper.convertValue(body.get("filters"), Map.class);
        }
        if (filterMap.get("fileLibraryType") != null) {
            filterMap.put("fileLibraryType", fileLibraryTypeTableService.get(Long.valueOf(filterMap.get("fileLibraryType").toString())));
        }
        if (filterMap.get("isPublished") != null) {
            filterMap.put("isPublished", Boolean.valueOf(filterMap.get("isPublished").toString()));
        }
        List listWebsite = websiteTableService.getWebsiteAsFilter(principal, filterMap.get("website") != null ? filterMap.get("website").toString() : null);
        if (listWebsite != null) {
            filterMap.put("website", listWebsite);
        }
        list = fileLibraryTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (FileLibraryTable flt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", flt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(flt.getFileName());
                listTmp.add(flt.getWebsite() != null ? flt.getWebsite().getTitle() : null);
                listTmp.add(flt.getFileLibraryType() != null ? flt.getFileLibraryType().getTitle() : null);
                listTmp.add(flt.getUrl());
                listTmp.add(flt.isPublished() ? "Y" : "N");
                listTmp.add(flt.isPublished() ? DateFormat.sdf.format(flt.getPublishDate()) : DateFormat.sdf.format(flt.getPublishDate()));
//                listTmp.add(flt.getCreateUser());
//                listTmp.add(DateFormat.sdf.format(flt.getCreateDate()));
                mapTemp.put("value", listTmp);
                listReturn.add(mapTemp);
            }
            map.put("data", listReturn);
            map.put("totalCount", list.getTotalElements());
            map.put("rowSize", body.get("rowSize").asInt());
            map.put("currentPage", list.getNumber());
        } else {
            map.put("data", null);
            map.put("totalCount", 0);
            map.put("rowSize", body.get("rowSize").asInt());
            map.put("currentPage", 0);
        }
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限
        fileLibraryTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        //fileLibraryTableService.get(id);
        FileLibraryTable flt = this.fileLibraryTableService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", flt.getId());
        map.put("title", flt.getFileName());
        if (flt.getWebsite() != null) {
            map.put("website", flt.getWebsite().getId());
        } else {
            map.put("website", null);
        }
        if (flt.getFileLibraryType() != null) {
            map.put("fileLibraryType", flt.getFileLibraryType().getId());
        } else {
            map.put("fileLibraryType", null);
        }
        map.put("url", flt.getUrl());
        map.put("isPublished", flt.isPublished());
        map.put("publishDate", flt.getPublishDate());
        map.put("createUser", flt.getCreateUser());
        map.put("createDate", DateFormat.sdf.format(flt.getCreateDate()));
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateFileLibrary(@RequestBody Map<String, Object> body, Principal principal) {
        long id = Long.valueOf(body.get("id").toString());
        FileLibraryTable fileLibraryTable = this.fileLibraryTableService.get(id);
        if (body.get("title") != null) {
            fileLibraryTable.setFileName(body.get("title").toString());
        }
        if (body.get("website") != null) {
            WebsiteTable websiteTable = websiteTableService.get(Long.valueOf(body.get("website").toString()));
            fileLibraryTable.setWebsite(websiteTable);
        }
        if (body.get("fileLibraryType") != null) {
            fileLibraryTable.setFileLibraryType(fileLibraryTypeTableService.get(Long.valueOf(body.get("fileLibraryType").toString())));
        }
        if (body.get("url") != null) {
            fileLibraryTable.setUrl(body.get("url").toString());
            String[] urlArr = body.get("url").toString().split("\\.");
            if (urlArr != null && urlArr.length > 1) {
                String type = urlArr[urlArr.length - 1];
                if (type.indexOf("/") < 0) {
                    type = type.toLowerCase();
                    fileLibraryTable.setType(type);
                    if (type.equals("png") || type.equals("gif") || type.equals("jpg") || type.equals("jpeg")) {
                        fileLibraryTable.setSuperType("image");
                    } else if (type.equals("dat") || type.equals("mpg") || type.equals("mpeg") || type.equals("mp4") || type.equals("wmv") || type.equals("asf") || type.equals("rm") || type.equals("rmvb") || type.equals("mov") || type.equals("avi")) {
                        fileLibraryTable.setSuperType("video");
                    } else if (type.equals("mp3") || type.equals("wma") || type.equals("wav") || type.equals("ape") || type.equals("flac") || type.equals("ogg") || type.equals("aac")) {
                        fileLibraryTable.setSuperType("audio");
                    } else if (type.equals("flv")) {
                        fileLibraryTable.setSuperType("flash");
                    } else {
                        fileLibraryTable.setSuperType("document");
                    }
                }
            }
        }
        if (body.get("isPublished") != null && ((List) body.get("isPublished")).size() > 0) {
            fileLibraryTable.setPublished(true);
        } else {
            fileLibraryTable.setPublished(false);
        }
        if (body.get("publishDate") != null) {
            fileLibraryTable.setPublishDate(new Date(Long.valueOf(body.get("publishDate").toString())));
        }
        this.fileLibraryTableService.save(fileLibraryTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveFileLibrary(@RequestBody Map<String, Object> body, Principal principal) {
        FileLibraryTable fileLibraryTable = new FileLibraryTable();
        if (body.get("title") != null) {
            fileLibraryTable.setFileName(body.get("title").toString());
        }
        if (body.get("website") != null) {
            WebsiteTable websiteTable = websiteTableService.get(Long.valueOf(body.get("website").toString()));
            fileLibraryTable.setWebsite(websiteTable);
        }
        if (body.get("fileLibraryType") != null) {
            fileLibraryTable.setFileLibraryType(fileLibraryTypeTableService.get(Long.valueOf(body.get("fileLibraryType").toString())));
        }
        if (body.get("url") != null) {
            fileLibraryTable.setUrl(body.get("url").toString());
            String[] urlArr = body.get("url").toString().split("\\.");
            if (urlArr != null && urlArr.length > 1) {
                String type = urlArr[urlArr.length - 1];
                if (type.indexOf("/") < 0) {
                    type = type.toLowerCase();
                    fileLibraryTable.setType(type);
                    if (type.equals("png") || type.equals("gif") || type.equals("jpg") || type.equals("jpeg")) {
                        fileLibraryTable.setSuperType("image");
                    } else if (type.equals("dat") || type.equals("mpg") || type.equals("mpeg") || type.equals("mp4") || type.equals("wmv") || type.equals("asf") || type.equals("rm") || type.equals("rmvb") || type.equals("mov") || type.equals("avi")) {
                        fileLibraryTable.setSuperType("video");
                    } else if (type.equals("mp3") || type.equals("wma") || type.equals("wav") || type.equals("ape") || type.equals("flac") || type.equals("ogg") || type.equals("aac")) {
                        fileLibraryTable.setSuperType("audio");
                    } else if (type.equals("flv")) {
                        fileLibraryTable.setSuperType("flash");
                    } else {
                        fileLibraryTable.setSuperType("document");
                    }
                }
            }
        }
        if (body.get("url") != null) {
            fileLibraryTable.setUrl(body.get("url").toString());
        }
        if (body.get("isPublished") != null && ((List) body.get("isPublished")).size() > 0) {
            fileLibraryTable.setPublished(true);
        } else {
            fileLibraryTable.setPublished(false);
        }
        if (body.get("publishDate") != null) {
            fileLibraryTable.setPublishDate(new Date(Long.valueOf(body.get("publishDate").toString())));
        }
        fileLibraryTable.setCreateUser(principal.getName());
        fileLibraryTable.setCreateDate(new Date());
        this.fileLibraryTableService.save(fileLibraryTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list/bytype", method = {RequestMethod.POST})
    public Map getListByType(@RequestBody(required = false) JsonNode body, Principal principal, @RequestParam(required = false) String type) {
        //暂时不考虑分页
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> listReturn;
        Map<String, Object> filterMap = new HashMap<>();
        ObjectNode mapBody = null;
        if (body != null) {
            mapBody = (ObjectNode) body.get("data");
        }
        if (type != null) {
            filterMap.put("superType", type);
        } else {
            if (mapBody != null && mapBody.get("type") != null && !mapBody.get("type").isNull()) {
                filterMap.put("superType", mapBody.get("type").asText());
            }
        }
        Iterable<WebsiteTable> listWebsite = null;
        if (mapBody != null && mapBody.get("website") != null && !mapBody.get("website").isNull()) {
            filterMap.put("website", this.websiteTableService.get(mapBody.get("website").asLong()));
        } else {
            listWebsite = this.websiteTableService.getWebsiteAsFilter(principal);
        }
        if (mapBody != null && mapBody.get("filter") != null && !mapBody.get("filter").isNull()) {
            filterMap.put("fileName", mapBody.get("filter").asText());
        }
        List<FileLibraryTable> list = fileLibraryTableService.getListByType(filterMap);
        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (FileLibraryTable flt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("id", flt.getId());
                mapTemp.put("url", flt.getUrl());
                mapTemp.put("fileName", flt.getFileName());
                listReturn.add(mapTemp);
            }
            map.put("files", listReturn);
        } else {
            map.put("files", null);
        }
        if (listWebsite != null) {
            List<HashMap> listOptions = new ArrayList<>();
            for (WebsiteTable websiteTable : listWebsite) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("label", websiteTable.getTitle());
                mapTemp.put("value", websiteTable.getId());
                listOptions.add(mapTemp);
            }
            map.put("websites", listOptions);
        } else {
            map.put("websites", null);
        }
        return map;
    }

}
