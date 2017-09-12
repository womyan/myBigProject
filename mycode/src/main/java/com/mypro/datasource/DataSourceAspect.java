package com.mypro.datasource;

import org.aspectj.lang.JoinPoint;

/**
 * @author 玄夏
 * @date 2017/09/13
 */
public class DataSourceAspect {
    public void before(JoinPoint point) {
        Class<?>[] classz = point.getTarget().getClass().getInterfaces();
        Class<?> type = classz[0];
        if (null == type || !type.isInterface()) {
            return;
        }
        if (type.isAnnotationPresent(DataSourceType.class)) {
            DataSourceContextHolder.setDataSourceType(type.getAnnotation(DataSourceType.class).value());
        } else {
            DataSourceContextHolder.setDataSourceType("slave");
        }
        return;
    }
}
