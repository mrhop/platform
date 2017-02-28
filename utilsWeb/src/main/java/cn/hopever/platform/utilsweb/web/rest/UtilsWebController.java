package cn.hopever.platform.utilsweb.web.rest;

import fm.last.moji.MojiFile;
import fm.last.moji.spring.SpringMojiBean;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/12/12.
 */
@RestController
@RequestMapping(produces = "application/json")
public class UtilsWebController {

    Logger logger = LoggerFactory.getLogger(UtilsWebController.class);

    @Autowired
    @Qualifier("mojiImages")
    private SpringMojiBean mojiImages;
    @Autowired
    @Qualifier("mojiFiles")
    private SpringMojiBean mojiFiles;
    @Autowired
    @Qualifier("mojiDocs")
    private SpringMojiBean mojiDocs;

    //@PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/upload/image", method = {RequestMethod.POST})
    public Map uploadImg(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) throws Exception {
        return upload(request,files,mojiImages);
    }

    //@PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/upload/doc", method = {RequestMethod.POST})
    public Map uploadDoc(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) throws Exception {
        return upload(request,files,mojiDocs);
    }

    //@PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/upload/file", method = {RequestMethod.POST})
    public Map uploadFile(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) throws Exception {
        return upload(request,files,mojiFiles);
    }

    @RequestMapping(value = "/delete/image", method = { RequestMethod.POST})
    public void deleteImg(@RequestBody Map<String, Object> body) throws Exception {
        String fileUrl = body.get("fileUrl").toString();
        logger.info("we check:"+fileUrl);
        mojiImages.getFile(fileUrl).delete();
    }

    @RequestMapping(value = "/delete/doc", method = {RequestMethod.POST})
    public void deleteDoc(@RequestBody Map<String, Object> body) throws Exception {
        String fileUrl = body.get("fileUrl").toString();
        logger.info("we check:"+fileUrl);
        mojiDocs.getFile(fileUrl).delete();
    }

    @RequestMapping(value = "/delete/file", method = {RequestMethod.POST})
    public void deleteFile(@RequestBody Map<String, Object> body) throws Exception {
        String fileUrl = body.get("fileUrl").toString();
        logger.info("we check:"+fileUrl);
        mojiFiles.getFile(fileUrl).delete();
    }
    private Map upload(HttpServletRequest request, @RequestPart("files") MultipartFile[] files, SpringMojiBean mojiBean) throws IOException {
        String filePath = request.getParameter("filePath");
        HashMap<String, Object> responseData = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String[] fileName = file.getOriginalFilename().split("\\.");
            String filePrefix = fileName[0];
            String fileSuffix = fileName[fileName.length - 1];
            File fileTmp = File.createTempFile(filePrefix, "." + fileSuffix);
            MojiFile mojiFile = mojiBean.getFile(filePath + file.getOriginalFilename());
            file.transferTo(fileTmp);
            mojiBean.copyToMogile(fileTmp, mojiFile);
            list.add(filePath + file.getOriginalFilename());
        }
        responseData.put("fileKeys", list);
        return responseData;
    }
}
