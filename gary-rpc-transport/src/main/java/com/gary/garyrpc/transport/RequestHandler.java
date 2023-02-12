package com.gary.garyrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Classname RequestHandler
 * @Description
 * @Date 2023/2/12 8:18 PM
 * @Author Gary An
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResponse);
}
