package com.animal.adoption.utils;

import lombok.Data;

@Data
public class RestResult {
    private int code;
    private String msg;
    private Object data;

    public RestResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RestResult success(Object data) {
        return new RestResult(0, "success", data);
    }

    public static RestResult error(String msg) {
        return new RestResult(-1, msg, "");
    }
}
