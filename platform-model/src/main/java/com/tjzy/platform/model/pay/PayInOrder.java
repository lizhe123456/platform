package com.tjzy.platform.model.pay;

import com.tjzy.platform.model.base.DataEntity;

import java.io.Serializable;

public class PayInOrder extends DataEntity implements Serializable {
    private Integer payInOrderId;

    private Integer uid;

    private String oid;

    private Integer payPayId;

    private Long amount;

    private Byte status;

    private Long ctime;

    private static final long serialVersionUID = 1L;

    public Integer getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Integer payInOrderId) {
        this.payInOrderId = payInOrderId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
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