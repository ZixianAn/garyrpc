package com.gary.garyrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname Peer
 * @Description 表示网络传输的一个端点
 * @Date 2023/2/12 3:31 PM
 * @Author Gary An
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
