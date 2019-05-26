package com.djcao.sell.reflect;

import java.lang.reflect.Field;

import com.djcao.sell.algorithm.datastructor.DequeueTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/29
 */
@AllArgsConstructor
@Data
public class FieldTest {

    private int age;

    private static void testTest() throws NoSuchFieldException, IllegalAccessException {
        DequeueTest test = new DequeueTest();
        test.setHead(12);
        Field age = getFiled(DequeueTest.class,"head");
        age.setAccessible(true);
        Object o = age.get(test);
        System.out.println(age.isAccessible());
        System.out.println(o);
    }

    private static Field getFiled(Class<?> clazz,String fieldName) throws NoSuchFieldException {
        return clazz.getDeclaredField(fieldName);
    }

    @SneakyThrows
    public static void main(String[] args) {
        testTest();
    }
}
