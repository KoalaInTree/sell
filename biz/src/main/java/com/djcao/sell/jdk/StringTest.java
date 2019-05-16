package com.djcao.sell.jdk;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/13
 */
public class StringTest {

    @Test
    public void testJoin(){
        String ss = new String("123");
        String join = String.join(",", "a", "b", "c");
        System.out.println(join);

    }
}
