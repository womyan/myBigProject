package com.mypro.processor;

import java.io.Serializable;

/**
 * @author 玄夏
 * @date 2017/09/09
 */
public class ProcessorRequest<T> implements Serializable {

    private static final long serialVersionUID = 3492845440671857171L;
    /**
     * 业务类型
     **/
    private String bizCode;
    /**
     * 请求对象
     **/
    private T request;

    public ProcessorRequest() {
    }

    public ProcessorRequest(String bizCode, T request) {
        this.bizCode = bizCode;
        this.request = request;
    }

    public static <T> ProcessorRequest<T> instance(String bizCode, T request){
        return new ProcessorRequest<T>(bizCode,request);
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }
}
