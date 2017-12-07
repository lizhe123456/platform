package com.tjzy.platform.model.pay;

import java.io.Serializable;

public class PayPay implements Serializable {
    private Integer payPayId;

    private Integer payTypeId;

    private String param;

    private static final long serialVersionUID = 1L;

    public Integer getPayPayId() {
        return payPayId;
    }

    public void setPayPayId(Integer payPayId) {
        this.payPayId = payPayId;
    }

    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }
}