package com.djcao.sell.jdk.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/26
 */
public class BufferedInputStreamTest {

    private static void debug() throws IOException {
        byte[] bytes = "i'm buffer".getBytes();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(bytes));
        char chars = (char)bufferedInputStream.read();
        System.out.println(chars);
    }

    public static void main(String[] args) throws IOException {
        debug();
        List list = Lists.newArrayList();
        Object o = list.get(0);
        System.out.println(o);
    }
}
