package com.djcao.sell.jdk.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/28
 */
public class ByteBufferTest {

    @Test
    public void firstTest() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\sell-error.2019-01-27.log","rw");
        ByteBuffer buffer = ByteBuffer.allocate(64);
        FileChannel channel = randomAccessFile.getChannel();
        while (channel.read(buffer) != -1){
            buffer.flip();
            while (buffer.hasRemaining())
                System.out.println((char)buffer.get());
            buffer.clear();
        }
        randomAccessFile.close();
    }

    @Test
    public void copyFile() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\sell-error.2019-01-27.log","rw");
        RandomAccessFile file = new RandomAccessFile("D:\\sell-error.2019-01-27-copy.log","rw");
        FileChannel channel1 = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(64);
        FileChannel channel = randomAccessFile.getChannel();
        while (channel.read(buffer) != -1){
            buffer.flip();
            channel1.write(buffer);
            buffer.clear();
        }
        randomAccessFile.close();
        file.close();
    }
}
