package com.djcao.sell.jdk;

import java.util.LinkedHashMap;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/2
 */
public class LinkedHashMapTest {

    public void test1(){
        LinkedHashMap linkedHashMap = new LinkedHashMap(5,0.75f,true);
        linkedHashMap.entrySet().parallelStream().findFirst();
    }
}
