package com.djcao.sell.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/5
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999,10, InetAddress.getByName("127.0.0.1"));
        Socket socket;
        while (null != (socket = serverSocket.accept())){
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] data = new char[128];
            int i = -1;
            if ((i = bufferedReader.read(data,0,128)) != -1){
                System.out.println(new String(data));
            }
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("gun ba");
            printWriter.flush();
            socket.close();
            socket = null;
        }
    }
}
