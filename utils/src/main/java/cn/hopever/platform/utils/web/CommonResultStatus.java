package cn.hopever.platform.utils.web;

/**
 * Created by Donghui Huo on 2016/9/2.
 */
public enum CommonResultStatus {
    SUCCESS("success"), SERVERFAILURE("serverFailure");

    private String value;

    // 构造函数，枚举类型只能为私有
    private CommonResultStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}


