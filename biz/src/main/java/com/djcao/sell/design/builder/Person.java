package com.djcao.sell.design.builder;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public class Person {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new Asian();
        personBuilder.build();
    }
}
