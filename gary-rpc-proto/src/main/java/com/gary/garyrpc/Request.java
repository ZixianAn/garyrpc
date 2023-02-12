package com.gary.garyrpc;

import lombok.Data;

/**
 * @Classname Request
 * @Description 表示RPC的一个请求
 * @Date 2023/2/12 3:36 PM
 * @Author Gary An
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
