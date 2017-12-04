package com.yun.base;

import com.yun.util.GenericsUtils;
import com.yun.util.Reflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lizhe on 2017/12/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class BaseServiceImpl<T, P, V> implements IBaseService<T, P, V>{
    private transient Class<T> DTOClass = GenericsUtils.getSuperClassGenricType(this.getClass(),0);
    private transient Class<V> VOClass = GenericsUtils.getSuperClassGenricType(this.getClass(),2);

    @Autowired
    JpaRepository<T, Long> jpaRepository;

    @Override
    public void deleteById(Long id) {
        jpaRepository.delete(id);
    }

    @Override
    public void save(P param) {
        if (param == null){
            throw new IllegalArgumentException("参数为空");
        }
        T t = BeanMapper.map(param,DTOClass);
        jpaRepository.save(t);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public T findOne(Long id) {
        return jpaRepository.getOne(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Long getCount() {
        return jpaRepository.count();
    }


    public Page<V> pageDtoToPageVo(Page<T> tPage){
        if (tPage == null){
            return null;
        }
        return tPage.map(new Converter<T, V>() {
            @Override
            public V convert(T t) {
                return BeanMapper.map(t,VOClass);
            }
        });
    }


}
