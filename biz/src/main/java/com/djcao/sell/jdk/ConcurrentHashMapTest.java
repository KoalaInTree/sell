package com.djcao.sell.jdk;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/14
 */
public class ConcurrentHashMapTest<K,V> {

    @Test
    public void testTableSizeFor(){
        ConcurrentHashMap map = new ConcurrentHashMap(8);
        map.put(Integer.valueOf(-1),"-1");
        map.get(Integer.valueOf(-1));
    }

    @Test
    public void testNumberLeadZero(){
        int i = Integer.MAX_VALUE;
        int zeros = Integer.numberOfLeadingZeros(i);
        int zeros2 = Integer.numberOfTrailingZeros(i);
        System.out.println(zeros);
    }

}


