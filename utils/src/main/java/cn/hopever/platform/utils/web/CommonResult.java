package cn.hopever.platform.utils.web;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Donghui Huo on 2016/9/2.
 */
@Data
public class CommonResult {

    public CommonResult() {
    }

    public CommonResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public CommonResult(boolean status, Serializable result) {
        this.status = status;
        this.result = result;
    }

    public CommonResult(boolean status, String message, Serializable result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }


    private boolean status;

    private String message;

    private Serializable result;


}
