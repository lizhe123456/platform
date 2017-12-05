package cloud.platform.base;

import java.util.List;

/**
 * Created by lizhe on 2017/12/5 0005.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public interface BaseService<T> {

    T findOne(int key);
    T save(T entity);
    void delete(Object key);
    List<T> findAll();

    /**
     * 批量删除
     */
    void deleteInBatch(Iterable<T> iterable);

    /**
     * 批量查找
     */
    List<T> findAll(Iterable<Integer> integers);

    /**
     * 批量保存
     */
    List<T> save(Iterable<T> iterable);
}
