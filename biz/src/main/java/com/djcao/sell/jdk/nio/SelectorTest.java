package com.djcao.sell.jdk.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/1
 */
public class SelectorTest {

    @Test
    public void testSelector() throws IOException, InterruptedException {
        Selector selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open()
            .bind(new InetSocketAddress(InetAddress.getLocalHost(),5909));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT |SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        socketChannel.connect(new InetSocketAddress("10.63.98.153",6379));
        int i = 0;
        while (true){
            if (selector.select() <= 0 ) continue;
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey register : selectionKeys){
                if (register.isConnectable()){
                    /*ByteBuffer allocate = ByteBuffer.allocate(1024);
                    allocate.put("ping".getBytes());
                    allocate.flip();
                    while (allocate.hasRemaining())
                        socketChannel.write(allocate);*/
                }
                if (register.isReadable()){
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    socketChannel.read(allocate);
                    while (allocate.hasRemaining())
                        System.out.println((char)allocate.get());
                    Thread.sleep(1000);
                    if (i++ == 3)
                        break;
                }
                if (register.isWritable()){
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    allocate.put("ping".getBytes());
                    allocate.flip();
                    while (allocate.hasRemaining())
                        socketChannel.write(allocate);
                }
            }

        }


    }
}
