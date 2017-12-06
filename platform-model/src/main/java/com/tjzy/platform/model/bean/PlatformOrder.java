package com.tjzy.platform.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PlatformOrder extends PlatformOrderKey implements Serializable {
    private Integer orderNum;

    private BigDecimal salary;

    private String state;

    private Date startTime;

    private Date endTime;

    private static final long serialVersionUID = 1L;

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}