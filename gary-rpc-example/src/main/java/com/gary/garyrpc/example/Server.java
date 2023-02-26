package com.gary.garyrpc.example;

import com.gary.garyrpc.server.RpcServer;

/**
 * @Classname Server
 * @Description
 * @Date 2023/2/26 9:24 PM
 * @Author Gary An
 */
public class Server {

    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}

