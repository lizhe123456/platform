package com.yun.base;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lizhe on 2017/12/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class BeanMapper {

    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 构造新的destinationClass
     *
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationClass){
        return dozer.map(source, destinationClass);
    }

    public static <T> Collection<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List destinationList = Lists.newArrayList();
        for (Iterator i$ = sourceList.iterator(); i$.hasNext(); ){
            Object sourceObject = i$.next();
            Object destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 将对象source的所有属性值拷贝到对象destinationList中.
     *
     * @param source
     * @param destinationObject
     */
    public static void copy(Object source, Object destinationObject) {
        dozer.map(source,destinationObject);
    }
}
