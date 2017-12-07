package com.tjzy.platform.model.base;

import java.io.Serializable;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class Paging implements Serializable {

    /**
     * 页码
     */
    private int pageNum;
    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 排序字段
     */
    private String orderBy;

    public Paging() {
        this.pageNum = 1;
        this.pageSize = 20;
    }

    public Paging(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Paging(int pageNum, int pageSize, String orderBy) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
