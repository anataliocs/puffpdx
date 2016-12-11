package com.puffpdx.api.localserver.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WireMockServerManager implements DisposableBean {

    @Autowired
    WireMockServer wireMockServer;

    @Override
    public void destroy() throws Exception {
        if(wireMockServer.isRunning())
            wireMockServer.stop();
    }
}
