package cn.hopever.platform.utilsweb.web.rest;

import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import fm.last.moji.MojiFile;
import fm.last.moji.spring.SpringMojiBean;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/12/12.
 */
@RestController
@RequestMapping(produces = "application/json")
public class UtilsWebController {


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
    @RequestMapping(value = "/upload/image", method = {RequestMethod.POST, RequestMethod.GET})
    public CommonResult uploadImg(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) throws Exception {
        return upload(request,files,mojiImages);
    }

    //@PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/upload/doc", method = {RequestMethod.POST})
    public CommonResult uploadDoc(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) throws Exception {
        return upload(request,files,mojiDocs);
    }

    //@PreAuthorize("#oauth2.hasScope('internal_client') and isAuthenticated()")
    @RequestMapping(value = "/upload/file", method = {RequestMethod.POST})
    public CommonResult uploadFile(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) throws Exception {
        return upload(request,files,mojiFiles);
    }
    private CommonResult upload(HttpServletRequest request, @RequestPart("files") MultipartFile[] files,SpringMojiBean mojiBean) throws IOException {
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
        return new CommonResult(CommonResultStatus.SUCCESS.toString(), "上传成功", responseData);
    }
}
