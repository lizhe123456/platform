package com.tjzy.platform.dao.mapper;

import com.tjzy.platform.model.bean.PlatformUser;

public interface PlatformUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    PlatformUser selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);
}