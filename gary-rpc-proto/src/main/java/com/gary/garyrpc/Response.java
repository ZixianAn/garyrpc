package com.gary.garyrpc;

import lombok.Data;

/**
 * @Classname Response
 * @Description 表示RPC的返回
 * @Date 2023/2/12 3:37 PM
 * @Author Gary An
 */
@Data
public class Response {
    /**
     * 服务返回编码, 0-成功, 非0-失败
     */
    private int code = 0;
    /**
     * 错误信息
     */
    private String message = "OK";
    /**
     * 返回的数据
     */
    private Object data;
}
