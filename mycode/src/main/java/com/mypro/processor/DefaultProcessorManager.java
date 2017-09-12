package com.mypro.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mypro.common.result.BaseResult;

/**
 * @author 玄夏
 * @date 2017/09/09
 */
public class DefaultProcessorManager implements AbstractProcessorManager {

    private Map<String, List<Processor>> processors = new TreeMap<String, List<Processor>>();

    @Override
    public <Resp, Req> BaseResult<Resp> processor(ProcessorRequest<Req> processorRequest) {
        // 检查请求参数
        checkParamters(processorRequest);

        // 返回对象
        BaseResult<Resp> processorResponse = new BaseResult<Resp>();

        // 加工服务集合
        List<Processor> processors = this.processors.get(processorRequest.getBizCode());

        // 上下文
        Map<String, Object> context = new HashMap<String, Object>();

        context.put(BaseResult.class.getName(), processorResponse);

        for (Processor processor : processors) {
            processor.invoke(processorRequest, context);
        }

        return processorResponse;
    }

    public void setProcessors(Map<String, List<Processor>> processors) {
        this.processors = processors;
    }

    public void addProcessors(String name, List<Processor> processorList) {
        if (name == null || processorList == null || processorList.isEmpty()) {
            return;
        }
        processors.put(name, processorList);
    }

    private <Req> void checkParamters(ProcessorRequest<Req> processorRequest) {
        if (processors == null || processors.isEmpty()) {
            throw new ProcessorException("processor配置错误");
        }
        if (processorRequest == null || processorRequest.getBizCode() == null
            || processorRequest.getRequest() == null) {
            throw new ProcessorException("业务逻辑配置错误");
        }
    }
}
