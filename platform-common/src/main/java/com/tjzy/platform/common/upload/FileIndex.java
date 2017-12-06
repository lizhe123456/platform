package com.tjzy.platform.common.upload;

import java.io.File;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class FileIndex {

    /**
     * 上传文件
     */
    private File upFile;
    /**
     * 文件ID
     */
    private String fileId;
    /**
     * 文件名称
     */
    private String trueName;
    /**
     * 模块
     */
    private String module;
    /**
     * 路径
     */
    private String path;

    public FileIndex(File upFile, String trueName, String module) {
        super();
        this.upFile = upFile;
        this.trueName = trueName;
        this.module = module;
    }

    public FileIndex() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public File getUpFile() {
        return upFile;
    }

    public void setUpFile(File upFile) {
        this.upFile = upFile;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
