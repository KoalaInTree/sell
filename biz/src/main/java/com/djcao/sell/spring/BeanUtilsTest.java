package com.djcao.sell.spring;

import java.util.HashMap;

import org.springframework.beans.BeanUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/27
 */
public class BeanUtilsTest {
    private static <T> T testInitClass(Class<T> clazz){
        return BeanUtils.instantiate(clazz);
    }

    public static void main(String[] args) {
        HashMap<String,String> s = testInitClass(HashMap.class);
        s.put("a","b");
        System.out.println(s.get("a"));
    }
}
