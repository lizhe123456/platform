package com.tjzy.platform.model.pay;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public interface PayBaseService<T> {

    int deleteByPrimaryKey(Integer payInOrderDetailId);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer payInOrderDetailId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
