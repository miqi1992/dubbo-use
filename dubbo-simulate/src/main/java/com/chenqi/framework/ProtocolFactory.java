package com.chenqi.framework;

import com.chenqi.framework.protocol.http.HttpProtocol;

public class ProtocolFactory {
    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) name = "http";
        switch (name) {
            case "http":
                return new HttpProtocol();
//            case "dubbo":
//                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
