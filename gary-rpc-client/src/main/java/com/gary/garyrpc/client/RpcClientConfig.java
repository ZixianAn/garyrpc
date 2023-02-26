package com.gary.garyrpc.client;

import com.gary.garyrpc.Peer;
import com.gary.garyrpc.codec.Decoder;
import com.gary.garyrpc.codec.Encoder;
import com.gary.garyrpc.codec.JSONDecoder;
import com.gary.garyrpc.codec.JSONEncoder;
import com.gary.garyrpc.transport.HTTPTransportClient;
import com.gary.garyrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname RpcClientConfig
 * @Description
 * @Date 2023/2/26 9:07 PM
 * @Author Gary An
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}