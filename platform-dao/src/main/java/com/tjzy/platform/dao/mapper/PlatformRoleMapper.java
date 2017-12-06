package com.tjzy.platform.dao.mapper;

import com.tjzy.platform.model.bean.PlatformRole;

public interface PlatformRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(PlatformRole record);

    int insertSelective(PlatformRole record);

    PlatformRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(PlatformRole record);

    int updateByPrimaryKey(PlatformRole record);
}