package com.djcao.sell.jvm;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/3
 */
public class VolatileTest {

    private volatile int a = 1;

    private int b = 10;

    public void add(){
        b = 10 + 1;
        a = 1  + 1;
    }
}
