package com.djcao.sell.jdk.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/1
 */
public class ScatterTest {

    @Test
    public void testScatter() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\sell-error.2019-01-27.log","rw");
        ScatteringByteChannel scatteringByteChannel = randomAccessFile.getChannel();
        ByteBuffer head = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] byteBuffers = new ByteBuffer[]{head,body};
        while (scatteringByteChannel.read(byteBuffers) != -1){
            head.flip();
            body.flip();
            while (head.hasRemaining())
                System.out.println((char)head.get());
            while (body.hasRemaining())
                System.out.println((char)body.get());
            head.clear();
            body.clear();
        }
    }

}
