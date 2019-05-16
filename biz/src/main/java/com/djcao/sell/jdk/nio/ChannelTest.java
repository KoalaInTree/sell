package com.djcao.sell.jdk.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/1
 */
public class ChannelTest {

    @Test
    public void testChannel() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\sell-error.2019-01-27.log","rw");
        RandomAccessFile toFile = new RandomAccessFile("D:\\sell-error.2019-01-27-copy2.log","rw");
        FileChannel fromChannel = file.getChannel();
        FileChannel toFileChannel = toFile.getChannel();
        toFileChannel.transferFrom(fromChannel,0,fromChannel.size());
    }
}
