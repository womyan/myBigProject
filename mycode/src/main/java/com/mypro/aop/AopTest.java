package com.mypro.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author 玄夏
 * @date 2017/09/10
 */
public class AopTest {

    public static void main(String[] args){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new NaiveWaiter());
        proxyFactory.addAdvice(new GreetingBefore());
        proxyFactory.setOptimize(true);

        Waiter waiter = (Waiter)proxyFactory.getProxy();
        waiter.say("zhangsan");
    }

}
