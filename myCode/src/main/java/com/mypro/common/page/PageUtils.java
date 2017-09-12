package com.mypro.common.page;

import java.lang.reflect.Method;

/**
 * 分页工具类:把page对象的信息，反射到mybatis generator生成的example中
 *
 * @author 玄夏
 * @date 2017/09/09
 */
public class PageUtils {
    public static <T> Page<T> setPageToExample(Page<T> page, Object example) {
        if (example == null) {
            throw new IllegalArgumentException("the 'example' argument can't be null");
        }
        if (page == null) {
            page = new Page<T>();
        }
        try {
            Method setLimitStart = example.getClass().getMethod("setLimitStart", int.class);
            setLimitStart.invoke(example, page.getPageSize() * (page.getPageNo() - 1));

            Method setLimitEnd = example.getClass().getMethod("setLimitEnd", int.class);
            setLimitEnd.invoke(example, page.getPageSize());

            if (page.getOrderBy() != null) {
                Method setOrderByClause = example.getClass().getMethod("setOrderByClause", String.class);
                setOrderByClause.invoke(example, page.getOrderBy());
            }
        } catch (Throwable e) {
            throw new IllegalStateException("Method invoke exception: " + e.getMessage());
        }
        return page;
    }
}
