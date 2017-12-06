package com.tjzy.platform.common.upload;

import com.tjzy.platform.util.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class DiskFileOperator extends AbstractFileOperator implements FileOperator{

    private static final Logger _log = LoggerFactory.getLogger(DiskFileOperator.class);

    /**
     * 文件目录
     */
    private String workFolderName;

    @Override
    public void deleteFile(String realName) {
        FileHelper.delFile(FileHelper.addEndSlash(workFolderName) + realName);
    }

    @Override
    public void saveFile(File file, String realName) {
        try {
            FileHelper.copy(file.getAbsolutePath(),FileHelper.addEndSlash(workFolderName) + realName);
        } catch (IOException e) {
            _log.error(String.format("文件 %s 复制失败", realName), e);
        }
    }

    public String getWorkFolderName(){
        return workFolderName;
    }

    public void setWorkFolderName(String workFolderName) {
        this.workFolderName = workFolderName;
    }
}
