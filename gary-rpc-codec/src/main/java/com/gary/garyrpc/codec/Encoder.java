package com.gary.garyrpc.codec;

/**
 * @Classname Encoder
 * @Description
 * @Date 2023/2/12 7:58 PM
 * @Author Gary An
 */
public interface Encoder {
    byte[] encode(Object obj);
}
