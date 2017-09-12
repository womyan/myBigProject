package com.mypro.aop;

/**
 * @author 玄夏
 * @date 2017/09/10
 */
public class NaiveWaiter implements Waiter {
    public String say(String name) {
        System.out.println("welcom : " + name);
        return "welcom : " + name;
    }
}
