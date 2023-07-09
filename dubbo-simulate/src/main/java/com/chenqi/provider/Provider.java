package com.chenqi.provider;


import com.chenqi.framework.Protocol;
import com.chenqi.framework.ProtocolFactory;
import com.chenqi.framework.URL;
import com.chenqi.framework.register.LocalRegister;
import com.chenqi.provider.api.HelloService;
import com.chenqi.provider.impl.HelloServiceImpl;

public class Provider {

    public static void main(String[] args) {
        // 1. 注册服务
        // 2. 本地注册
        // 3. 启动tomcat

        URL url = new URL("localhost", 8080); //NetUtil
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);


    }
}
