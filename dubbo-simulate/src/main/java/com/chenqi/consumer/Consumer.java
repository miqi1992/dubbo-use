package com.chenqi.consumer;

import com.chenqi.framework.ProxyFactory;
import com.chenqi.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String xxx = helloService.sayHello("陈奇");
        System.out.println(xxx);
    }
}
