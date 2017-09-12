package com.mypro.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author 玄夏
 * @date 2017/09/10
 */
public class GreetingBefore implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("i am a waiter:" + args[0]);
    }

}
