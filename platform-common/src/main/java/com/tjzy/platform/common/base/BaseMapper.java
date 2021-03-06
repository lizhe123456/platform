package com.tjzy.platform.common.base;

import java.util.List;
import java.util.Map;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public interface BaseMapper<T> {

    /**
     * 获取单条数据
     *
     * @param id 主键
     * @return T t
     */
    T get(String id);

    /**
     * 获取单条数据
     *
     * @param entity T
     * @return T t
     */
    T get(T entity);

    /**
     * 查询数据列表
     *
     * @param entity T
     * @return List<T> list
     */
    List<T> findList(T entity);

    /**
     * 查询数据列表
     *
     * @param queryMap 查询条件
     * @return List<T> list
     */
    List<T> queryList(Map<String, Object> queryMap);

    /**
     * 查询所有数据列表
     *
     * @return List<T> list
     */
    List<T> findAllList();

    /**
     * 插入数据
     *
     * @param entity T
     * @return int int
     */
    int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity T
     * @return int int
     */
    int update(T entity);

    /**
     * 删除数据
     *
     * @param entity T
     * @return int int
     */
    int delete(T entity);

    /**
     * 删除数据
     *
     * @param id entity id
     * @return int int
     */
    int deleteById(String id);
}
