package com.gary.garyrpc.example;

import com.gary.garyrpc.client.RpcClient;

/**
 * @Classname Client
 * @Description
 * @Date 2023/2/26 9:24 PM
 * @Author Gary An
 */
public class Client {

    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1, 2);
        int r2 = service.minus(10, 8);
        System.out.println(r1);
        System.out.println(r2);
    }
}
