package com.djcao.sell.spring;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/28
 */
public class ClassUtilsTest {

    private static Class getClassByName(String className,ClassLoader classLoader) throws ClassNotFoundException {
        return ClassUtils.forName(className,classLoader);
    }

    private static Class notNull(String aa,String bb){
        Assert.notNull(aa,"aa must not be null");
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
        InstantiationException {
        /*Class classUtilsTest = getClassByName("com.djcao.sell.spring.ClassUtilsTest", ClassUtilsTest.class.getClassLoader());
        Object o = classUtilsTest.newInstance();
        System.out.println(o.getClass().getName());
        notNull("a","b");*/
        char a = 'A';
        System.out.println(Character.valueOf((char)(a-1)));
    }
}
