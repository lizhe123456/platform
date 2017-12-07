package com.tjzy.platform.model.pay;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class PayBaseServiceImpl<M extends PayBaseMapper<T>,T> implements PayBaseService<T>{

    @Autowired
    M mapper;

    @Override
    public int deleteByPrimaryKey(Integer payInOrderDetailId) {
        return mapper.deleteByPrimaryKey(payInOrderDetailId);
    }

    @Override
    public int insert(T record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(Integer payInOrderDetailId) {
        return mapper.selectByPrimaryKey(payInOrderDetailId);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }
}
