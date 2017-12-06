package com.tjzy.platform.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tjzy.platform.util.StringHelper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public abstract class BaseEntity implements Serializable{
    /**
     * 实体编号
     */
    private String id;

    private boolean isNewRecord = false;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void preInsert();

    public abstract void preUpdate();

    @JsonIgnore
    public boolean getIsNewRecord() {
        return isNewRecord || StringHelper.isBlank(getId());
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @param isNewRecord 是否为新数据
     */
    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
