package com.tjzy.platform.common.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjzy.platform.model.base.Paging;
import com.tjzy.platform.model.base.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by lizhe on 2017/12/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Transactional(readOnly = true)
public abstract class BaseService<M extends BaseMapper<T>, T extends DataEntity> {

    /**
     * 持久层
     */
    @Autowired
    private M dao;

    /**
     * 获取单条数据
     *
     * @param id 主键
     * @return 数据实体
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity 实体对象
     * @return 实体对象
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     *
     * @param entity 实体对象
     * @return 实体对象列表
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

    /**
     * 查询列表数据
     *
     * @param queryMap 查询条件
     * @return 实体对象列表
     */
    public List<T> queryList(Map<String, Object> queryMap) {
        return dao.queryList(queryMap);
    }

    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity 实体对象
     * @return 分页数据
     */
    public PageInfo<T> findPage(Paging page, T entity) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<T> list = dao.findList(entity);
        return new PageInfo<>(list);
    }

    /**
     * 查询分页数据
     *
     * @param page     分页对象
     * @param queryMap 查询条件
     * @return 分页数据
     */
    public PageInfo<T> queryPage(Paging page, Map<String, Object> queryMap) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<T> list = dao.queryList(queryMap);
        return new PageInfo<>(list);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param entity 实体对象
     * @return 实体对象
     */
    @Transactional(readOnly = false)
    public T save(T entity) {
        if (entity.getIsNewRecord()) {
            entity.preInsert();
            dao.insert(entity);
        } else {
            entity.preUpdate();
            dao.update(entity);
        }
        return entity;
    }

    /**
     * 删除数据
     *
     * @param entity 实体对象
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        dao.delete(entity);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     */
    @Transactional(readOnly = false)
    public void deleteById(String id) {
        dao.deleteById(id);
    }

}
