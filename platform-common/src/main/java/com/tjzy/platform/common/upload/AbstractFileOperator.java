package com.tjzy.platform.common.upload;

import com.tjzy.platform.util.FileHelper;
import com.tjzy.platform.util.StringHelper;


/**
 * 文件处理器.
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public abstract class AbstractFileOperator implements FileOperator {

    /**
     * 文件服务器地址
     */
    private String accessUrl;

    public AbstractFileOperator() {
    }

    public AbstractFileOperator(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    @Override
    public String getFileUrl(String realPath) {
        if (StringHelper.isEmpty(accessUrl)) {
            throw new NullPointerException("文件服务器访问地址为空.");
        }
        return StringHelper.isEmpty(realPath) ? "" : FileHelper.addEndSlash(accessUrl) + realPath;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }
}
