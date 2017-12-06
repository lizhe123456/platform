package com.tjzy.platform.dao.mapper;

import com.tjzy.platform.model.bean.PlatformOrder;
import com.tjzy.platform.model.bean.PlatformOrderKey;

public interface PlatformOrderMapper {
    int deleteByPrimaryKey(PlatformOrderKey key);

    int insert(PlatformOrder record);

    int insertSelective(PlatformOrder record);

    PlatformOrder selectByPrimaryKey(PlatformOrderKey key);

    int updateByPrimaryKeySelective(PlatformOrder record);

    int updateByPrimaryKey(PlatformOrder record);
}