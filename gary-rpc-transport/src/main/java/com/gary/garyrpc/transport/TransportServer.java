package com.gary.garyrpc.transport;

/**
 * @Classname TransportServer
 * @Description 1. 启动, 监听; 2. 接受请求; 3. 关闭监听
 * @Date 2023/2/12 8:17 PM
 * @Author Gary An
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}