package com.cqq.aio;

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

        AsyncTimeServerHandle timeServerHandle = new AsyncTimeServerHandle(port);
        new Thread(timeServerHandle, "AIO-AsyncTimeServerHandle-001").start();
    }

}
