package com.tjzy.platform.model.result;

import com.alibaba.fastjson.JSON;

/**
 * author:lizhe
 * date: 2017-12-05
 * for tomorrow
 * 类介绍: 统一 API 响应结果
 */
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
