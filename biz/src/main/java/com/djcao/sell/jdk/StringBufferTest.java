package com.djcao.sell.jdk;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/21
 */
public class StringBufferTest {

    @Test
    public void testToString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        System.out.println("first call toString>> " + stringBuffer.toString());
        stringBuffer.append("b");
        System.out.println("second call toString>> " + stringBuffer.toString());
    }

    /**
     * stringbuffer的toString方法有缓存char[]数组的值，多次调用创建的字符串内部都是
     * 使用的同一个char[]数组,但是当调用stringBuffer的append等方法时，stringBuffer会使缓存失效
     */
    @Test
    public void testStringBufferCache(){
        StringBuffer sb = new StringBuffer();
        sb.append("a").append(".").append("b");
        String string = sb.toString();
        System.out.println(string);
        sb.append("c");
        System.out.println(string);
        System.out.println(sb.toString());
    }

}
