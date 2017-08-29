package com.cqq.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by chenqinqin on 17/8/29.
 */
public class AcceptCompletionHandler implements java.nio.channels.CompletionHandler<java.nio.channels.AsynchronousSocketChannel, AsyncTimeServerHandle> {

    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandle attachment) {
        attachment.asyncronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    public void failed(Throwable exc, AsyncTimeServerHandle attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
