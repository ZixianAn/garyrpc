package com.gary.garyrpc.server;

import com.gary.garyrpc.Request;
import com.gary.garyrpc.common.util.ReflectionUtil;

/**
 * @Classname ServiceInvoker
 * @Description
 * @Date 2023/2/26 8:40 PM
 * @Author Gary An
 */
public class ServiceInvoker {

    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtil.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }

}
