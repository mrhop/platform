package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.FileLibraryTable;
import cn.hopever.platform.cms.service.FileLibraryTableService;
import cn.hopever.platform.cms.service.FileLibraryTypeTableService;
import cn.hopever.platform.utils.json.JacksonUtil;
import cn.hopever.platform.utils.tools.DateFormat;
import com.fasterxml.jackson.databind.JsonNode;
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
        Map<String, Object> filterMap = null;
        if (body.get("filters") != null && !body.get("filters").isNull()) {
            filterMap = JacksonUtil.mapper.convertValue(body.get("filters"), Map.class);
        }
        filterMap.put("fileLibraryType", filterMap.get("fileLibraryType") != null ? fileLibraryTypeTableService.get(Long.valueOf(filterMap.get("fileLibraryType").toString())) : null);
        list = fileLibraryTableService.getList(pageRequest, filterMap);

        if (list != null && list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (FileLibraryTable flt : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", flt.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(flt.getFileName());
                if(flt.getFileLibraryType()!=null){
                    listTmp.add(flt.getFileLibraryType().getTitle());
                }else{
                    listTmp.add(null);
                }
                listTmp.add(flt.getUrl());
                listTmp.add(flt.isPublished()?"Y":"N");
                listTmp.add(flt.getCreateUser());
                listTmp.add(DateFormat.sdf.format(flt.getCreateDate()));
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
        if(flt.getFileLibraryType()!=null){
            HashMap<String, Object> mapFileLibraryType = new HashMap<>();
            mapFileLibraryType.put("id",flt.getFileLibraryType().getId());
            mapFileLibraryType.put("title",flt.getFileLibraryType().getTitle());
            map.put("fileLibraryType", mapFileLibraryType);
        }else{
            map.put("fileLibraryType", null);
        }
        map.put("url", flt.getUrl());
        map.put("isPublished", flt.isPublished());
        map.put("createUser",flt.getCreateUser());
        map.put("createDate",flt.getCreateDate());
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updateFileLibrary(@RequestBody Map<String, Object> body, Principal principal) {
        //fileLibraryTableService.save();
        long id = Long.valueOf(body.get("id").toString());
        FileLibraryTable fileLibraryTable = this.fileLibraryTableService.get(id);
        if (body.get("title") != null) {
            fileLibraryTable.setFileName(body.get("title").toString());
        }
        if (body.get("fileLibraryType") != null ) {
            fileLibraryTable.setFileLibraryType(fileLibraryTypeTableService.get(Long.valueOf(body.get("fileLibraryType").toString())));
        }
        if (body.get("url") != null ) {
            fileLibraryTable.setUrl(body.get("url").toString());
        }
        if (body.get("url") != null ) {
            fileLibraryTable.setUrl(body.get("url").toString());
        }
        if (body.get("isPublished") != null &&((List)body.get("isPublished")).size()>0) {
            fileLibraryTable.setPublished(true);
        }else{
            fileLibraryTable.setPublished(false);
        }
        this.fileLibraryTableService.save(fileLibraryTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map saveFileLibrary(@RequestBody Map<String, Object> body, Principal principal) {
        //fileLibraryTableService.save();
        FileLibraryTable fileLibraryTable = new FileLibraryTable();
        if (body.get("title") != null) {
            fileLibraryTable.setFileName(body.get("title").toString());
        }
        if (body.get("fileLibraryType") != null ) {
            fileLibraryTable.setFileLibraryType(fileLibraryTypeTableService.get(Long.valueOf(body.get("fileLibraryType").toString())));
        }
        if (body.get("url") != null ) {
            fileLibraryTable.setUrl(body.get("url").toString());
        }
        if (body.get("url") != null ) {
            fileLibraryTable.setUrl(body.get("url").toString());
        }
        if (body.get("isPublished") != null &&((List)body.get("isPublished")).size()>0) {
            fileLibraryTable.setPublished(true);
        }else{
            fileLibraryTable.setPublished(false);
        }
        fileLibraryTable.setCreateUser(principal.getName());
        fileLibraryTable.setCreateDate(new Date());
        this.fileLibraryTableService.save(fileLibraryTable);
        return null;
    }

}
