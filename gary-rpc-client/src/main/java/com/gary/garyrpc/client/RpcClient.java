package com.gary.garyrpc.client;

import com.gary.garyrpc.codec.Decoder;
import com.gary.garyrpc.codec.Encoder;
import com.gary.garyrpc.common.util.ReflectionUtil;

import java.lang.reflect.Proxy;

/**
 * @Classname RpcClient
 * @Description
 * @Date 2023/2/26 9:08 PM
 * @Author Gary An
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient(){
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config){
        this.config = config;
        this.encoder = ReflectionUtil.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtil.newInstance(config.getDecoderClass());
        this.selector = ReflectionUtil.newInstance(config.getSelectorClass());
        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );
    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }

}
