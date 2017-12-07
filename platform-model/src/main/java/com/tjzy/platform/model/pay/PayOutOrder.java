package com.tjzy.platform.model.pay;

import java.io.Serializable;

public class PayOutOrder implements Serializable {
    private Integer payOutOrderId;

    private Integer uid;

    private Integer payPayId;

    private Long amount;

    private Byte status;

    private Long ctime;

    private static final long serialVersionUID = 1L;

    public Integer getPayOutOrderId() {
        return payOutOrderId;
    }

    public void setPayOutOrderId(Integer payOutOrderId) {
        this.payOutOrderId = payOutOrderId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPayPayId() {
        return payPayId;
    }

    public void setPayPayId(Integer payPayId) {
        this.payPayId = payPayId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }
}