package com.gary.garyrpc.server;

import lombok.Data;
import com.gary.garyrpc.codec.Encoder;
import com.gary.garyrpc.codec.Decoder;
import com.gary.garyrpc.codec.JSONDecoder;
import com.gary.garyrpc.codec.JSONEncoder;
import com.gary.garyrpc.transport.TransportServer;
import com.gary.garyrpc.transport.HTTPTransportServer;

/**
 * @Classname RpcServerConfig
 * @Description
 * @Date 2023/2/26 8:14 PM
 * @Author Gary An
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encodeClass = JSONEncoder.class;
    private Class<? extends Decoder> decodeClass = JSONDecoder.class;
    private int port = 3000;
}
