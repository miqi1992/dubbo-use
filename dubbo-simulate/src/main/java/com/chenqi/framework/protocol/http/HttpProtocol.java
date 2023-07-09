package com.chenqi.framework.protocol.http;

import com.chenqi.framework.Protocol;
import com.chenqi.framework.URL;

public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }
}
