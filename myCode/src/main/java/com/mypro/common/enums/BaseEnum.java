package com.mypro.common.enums;

import java.io.Serializable;

/**
 * @author 玄夏
 * @date 2017/09/09
 */
public interface BaseEnum extends Serializable {

    /**
     * 获取枚举中定义的值
     * @return 枚举代码
     */
    String getCode();

    /**
     * 获取枚举中定义的备注信息
     * @return 枚举代码描述
     */
    String getValue();

}
