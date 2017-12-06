package com.tjzy.platform.dao.mapper;

import com.tjzy.platform.model.bean.PlatformUserRoleKey;

public interface PlatformUserRoleMapper {
    int deleteByPrimaryKey(PlatformUserRoleKey key);

    int insert(PlatformUserRoleKey record);

    int insertSelective(PlatformUserRoleKey record);
}