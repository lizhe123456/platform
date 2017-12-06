package com.tjzy.platform.dao.mapper;

import com.tjzy.platform.model.bean.PlatformDevice;
import com.tjzy.platform.model.bean.PlatformDeviceKey;

public interface PlatformDeviceMapper {
    int deleteByPrimaryKey(PlatformDeviceKey key);

    int insert(PlatformDevice record);

    int insertSelective(PlatformDevice record);

    PlatformDevice selectByPrimaryKey(PlatformDeviceKey key);

    int updateByPrimaryKeySelective(PlatformDevice record);

    int updateByPrimaryKey(PlatformDevice record);
}