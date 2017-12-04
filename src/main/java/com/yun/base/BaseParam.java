package com.yun.base;

import java.util.Date;

/**
 * Created by lizhe on 2017/12/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class BaseParam {

    private Long id;
    private Date createTime;
    private Date updateTime;

    public void setCreateTime(Date createTime) {
        if (this.id == null) {
            this.createTime = new Date();
        }

    }

    public void setUpdateTime(Date updateTime) {
        if (this.id != null) {
            this.updateTime = new Date();
        }
    }
}
