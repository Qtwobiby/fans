package com.cqq.aio;

/**
 * Created by chenqinqin on 17/8/30.
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8090;

        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
    }
}
