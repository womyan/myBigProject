package com.mypro.processor;

import com.mypro.common.result.BaseResult;

/**
 * @author 玄夏
 * @date 2017/09/09
 */
public interface AbstractProcessorManager {
    <Resp, Req> BaseResult<Resp> processor(ProcessorRequest<Req> processorRequest);
}
