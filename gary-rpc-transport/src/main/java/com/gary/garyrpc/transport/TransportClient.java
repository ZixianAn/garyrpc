package com.gary.garyrpc.transport;

import com.gary.garyrpc.Peer;

import java.io.InputStream;

/**
 * @Classname TransportClient
 * @Description 1. 创建连接; 2. 发送数据; 3. 关闭连接
 * @Date 2023/2/12 8:13 PM
 * @Author Gary An
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
