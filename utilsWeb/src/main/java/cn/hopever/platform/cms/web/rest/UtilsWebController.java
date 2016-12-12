package cn.hopever.platform.cms.web.rest;

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

    @RequestMapping(value = "/utilsclient/upload/image", method = {RequestMethod.POST})
    public CommonResult uploadImg(HttpServletRequest request, @RequestPart("file") MultipartFile file) throws Exception {
        String filePrefix = request.getParameter("filePrefix");
        String fileSuffix = request.getParameter("fileSuffix");
        MojiFile mojiFile = mojiImages.getFile(filePrefix + "." + fileSuffix);
        File fileTemp = File.createTempFile(filePrefix, fileSuffix);
        file.transferTo(fileTemp);
        mojiImages.copyToMogile(fileTemp, mojiFile);
        return new CommonResult(CommonResultStatus.SUCCESS.toString(), "上传成功");
    }

    @RequestMapping(value = "/utilsclient/upload/doc", method = {RequestMethod.POST})
    public CommonResult uploadDoc(HttpServletRequest request, @RequestPart("file") MultipartFile file) throws Exception {
        String fileName = request.getParameter("fileName");
        String filePath = request.getParameter("filePath");
        MojiFile mojiFile = mojiDocs.getFile(filePath + fileName);


        File fileTemp = File.createTempFile(fileName.substring(0, fileName.lastIndexOf(".")),
                fileName.substring(fileName.lastIndexOf("."), fileName.length() - 1));
        file.transferTo(fileTemp);
        mojiDocs.copyToMogile(fileTemp, mojiFile);
        return new CommonResult(CommonResultStatus.SUCCESS.toString(), "上传成功");

    }

    @RequestMapping(value = "/utilsclient/upload/file", method = {RequestMethod.POST})
    public CommonResult uploadFile(HttpServletRequest request, @RequestPart("file") MultipartFile file) throws Exception {
        String filePrefix = request.getParameter("filePrefix");
        String fileSuffix = request.getParameter("fileSuffix");
        MojiFile mojiFile = mojiFiles.getFile(filePrefix + "." + fileSuffix);
        File fileTemp = File.createTempFile(filePrefix, fileSuffix);
        file.transferTo(fileTemp);
        mojiFiles.copyToMogile(fileTemp, mojiFile);
        return new CommonResult(CommonResultStatus.SUCCESS.toString(), "上传成功");
    }
    public static void main(String[] agrs){
        String filename  = "aaaa.vvvv.jpg";
        System.out.println(filename.substring(0, filename.lastIndexOf(".")));
        System.out.println(filename.substring(filename.lastIndexOf(".")+1, filename.length() ));
    }
}
