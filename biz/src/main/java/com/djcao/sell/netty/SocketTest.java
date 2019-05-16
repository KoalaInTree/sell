package com.djcao.sell.netty;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/5
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        OutputStream outputStream = socket.getOutputStream();
        //PrintWriter printWriter = new PrintWriter(outputStream);
        //printWriter.println("hi,server");
        //printWriter.flush();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hi,server");
        bufferedWriter.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] data = new char[1024];
        int i = -1;
        if ((i = bufferedReader.read(data,0,1024)) != 0){
            System.out.println(new String(data));
        }
    }
}
