package cn.hopever.platform.utils.web.error;

import cn.hopever.platform.utils.web.CommonResult;
import cn.hopever.platform.utils.web.CommonResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
@ControllerAdvice(basePackages = {"cn.hopever.platform"})
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ErrorControllerAdvice.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<CommonResult> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        //此处应该进行日志的记录，而没有必要返回
        logger.error("mvc error code:"+status,ex);
        CommonResult c = new CommonResult();
        c.setStatus(CommonResultStatus.SERVERFAILURE.toString());
        c.setMessage(ex.getMessage());
        return new ResponseEntity<CommonResult>(c, status);
    }
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
