package com.mypro.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @author 玄夏
 * @date 2017/09/12
 */
public final class BeanCopyUtil {

    public static <T, E> E copy(T source, Class<E> classType) {
        if (source == null || classType == null) {
            return null;
        }
        E targetInstance = null;
        try {
            targetInstance = classType.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(source, targetInstance);
        return targetInstance;
    }

    public static <T, E> List<E> batchClone(List<T> sourceList, Class<E> classType) {
        if (sourceList == null || classType == null) {
            return null;
        }
        List<E> result = new LinkedList<E>();
        int size = sourceList.size();
        for (int i = 0; i < size; i++) {
            result.add(copy(sourceList.get(i), classType));
        }
        return result;
    }
}
