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

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
