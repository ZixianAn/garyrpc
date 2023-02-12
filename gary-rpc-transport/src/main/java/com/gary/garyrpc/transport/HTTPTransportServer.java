package com.gary.garyrpc.transport;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Classname HTTPTransportServer
 * @Description
 * @Date 2023/2/12 8:35 PM
 * @Author Gary An
 */
@Slf4j
public class HTTPTransportServer implements TransportServer {
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        log.info("init http server, port=[{}]", port);
        this.handler = handler;
        this.server = new Server(port);

        // servlet 接收请求
        ServletContextHandler ctxHandler = new ServletContextHandler();
        server.setHandler(ctxHandler);

        ServletHolder holder = new ServletHolder();
        ctxHandler.addServlet(holder, "/*");
    }

    @Override
    public void start() {
        try {
            log.info("start http server");
            server.start();
            // start 会起一个子线程监听，因此方法会立刻退出，使用join来让主线程等待子线程执行完毕
            server.join();
        } catch (Exception e) {
            log.error("start http server failed, error: {}", e.getMessage(), e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error("stop http server failed, error: {}", e.getMessage(), e);
        }
    }

    class RequestServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");
            InputStream in = req.getInputStream();
            OutputStream out = resp.getOutputStream();
            if (handler != null) {
                handler.onRequest(in, out);
            }
            out.flush();
        }
    }
}
