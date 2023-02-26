package com.gary.garyrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Classname ServiceInstance
 * @Description
 * @Date 2023/2/26 8:19 PM
 * @Author Gary An
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
