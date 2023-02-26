package com.gary.garyrpc.server;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gary.garyrpc.Request;
import com.gary.garyrpc.ServiceDescriptor;
import com.gary.garyrpc.common.util.ReflectionUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname ServiceManager
 * @Description 管理 RPC 暴露的服务
 * @Date 2023/2/26 8:20 PM
 * @Author Gary An
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtil.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            services.put(sdp, sis);
            log.info("register service: {} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
