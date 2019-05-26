package com.djcao.sell.jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/1
 */
public class HashMapTest {
    public static class MyLinkedHashMap extends HashMap{}
    private void testHashCollision(){
        float loadFactor = 10.75f;
        HashMap hashMap = new HashMap(1,loadFactor);
        hashMap.put("1","2");
        hashMap.put("2","2");
        hashMap.put("3","2");
        hashMap.put("4","2");
        hashMap.put("5","2");
        hashMap.put("6","2");
        hashMap.put("7","2");
        hashMap.put("8","2");
        hashMap.put("9","2");
        hashMap.put("10","2");
        hashMap.put("11","2");
        hashMap.put("12","2");
        hashMap.put("13","2");
        hashMap.put("14","2");
        hashMap.put("22","2");
        hashMap.put("23","2");
        hashMap.put("24","2");
        hashMap.put("25","2");
        hashMap.put("26","2");
        hashMap.put("27","2");
        hashMap.put("28","2");
        hashMap.put("29","2");
        hashMap.put("310","2");
        hashMap.put("311","2");
        hashMap.put("312","2");
        hashMap.put("313","2");
        hashMap.put("31","2");
        hashMap.put("32","2");
        hashMap.put("33","2");
        hashMap.put("34","2");
        hashMap.put("35","2");
        hashMap.put("36","2");
        hashMap.put("37","2");
        hashMap.put("38","2");
        hashMap.put("49","2");
        hashMap.put("410","2");
        hashMap.put("411","2");
        hashMap.put("412","2");
        hashMap.put("413","2");
        hashMap.remove("413");
        Map map = new MyLinkedHashMap();
    }

    public static void main(String[] args) {

    }
}
