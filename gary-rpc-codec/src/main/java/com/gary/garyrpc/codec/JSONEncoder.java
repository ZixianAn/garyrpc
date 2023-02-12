package com.gary.garyrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Classname JSONEncoder
 * @Description
 * @Date 2023/2/12 8:00 PM
 * @Author Gary An
 */
public class JSONEncoder implements Encoder {

    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
