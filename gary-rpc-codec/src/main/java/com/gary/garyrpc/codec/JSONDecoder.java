package com.gary.garyrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Classname JSONDecoder
 * @Description
 * @Date 2023/2/12 8:06 PM
 * @Author Gary An
 */
public class JSONDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
