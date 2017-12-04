package com.yun.base;

import java.util.List;

/**
 * Created by lizhe on 2017/12/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public interface IBaseService<T, P, V> {

    /**
     * 添加
     */
    void deleteById(Long id);

    /**
     * 保存
     */
    void save(P param);

    /**
     * 更新
     */
    void update(Long id);

    /**
     * 通过主键
     */
    T findOne(Long id);

    /**
     * 查询全部
     */
    List<T> findAll();

    /**
     * 总数
     */
    Long getCount();

}
