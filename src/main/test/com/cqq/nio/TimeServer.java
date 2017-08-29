package com.cqq.nio;

import java.io.IOException;

/**
 * Created by chenqinqin on 17/8/29.
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8090;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
