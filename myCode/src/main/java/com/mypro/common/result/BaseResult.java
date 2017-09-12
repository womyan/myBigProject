package com.mypro.common.result;

import java.io.Serializable;

import com.mypro.common.enums.BaseEnum;

/**
 * @author 玄夏
 * @date 2017/09/09
 */
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 2399163047606712918L;

    private boolean success = true;

    private T data;

    private String errCode;

    private String errMessage;

    public BaseResult() {}

    public BaseResult(T data) {
        this.data = data;
    }

    public BaseResult(boolean success, String errCode, String errMessage) {
        this.success = success;
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public static <T> BaseResult<T> successResult(T t) {
        return new BaseResult<T>(t);
    }

    public static <T> BaseResult<T> failedResult(String errCode, String errMessage) {
        return new BaseResult<T>(false, errCode, errMessage);
    }

    public static <T> BaseResult<T> failedResult(BaseEnum errorEnum) {
        return new BaseResult<T>(false, errorEnum.getCode(), errorEnum.getValue());
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
