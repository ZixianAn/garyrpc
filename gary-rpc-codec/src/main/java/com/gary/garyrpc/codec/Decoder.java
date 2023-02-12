package com.gary.garyrpc.codec;

/**
 * @Classname Decoder
 * @Description
 * @Date 2023/2/12 7:58 PM
 * @Author Gary An
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
