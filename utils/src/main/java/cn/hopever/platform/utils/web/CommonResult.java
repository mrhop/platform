package cn.hopever.platform.utils.web;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/2.
 */
@Data
public class CommonResult implements Serializable {

    public CommonResult() {
    }

    public CommonResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public CommonResult(String status, HashMap<String,Object> responseData) {
        this.status = status;
        this.responseData = responseData;
    }

    public CommonResult(String status, String message, HashMap<String,Object> responseData) {
        this.status = status;
        this.message = message;
        this.responseData = responseData;
    }


    private String status;

    private String message;

    private Map<String,Object> responseData;

}


