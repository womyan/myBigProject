package com.mypro.processor;

import java.util.Map;

/**
 * description:流程抽象接口
 * date:2017/3/7 15:37
 */
public interface Processor<T> {
    void invoke(ProcessorRequest<T> request, Map<String, Object> context);
}
