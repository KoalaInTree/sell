package com.djcao.sell.jvm;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-08-19
 */
public class VMtest {
    private static final int _1mb = 1024 * 1024;
    public static void main(String[] args) {

        byte[] a1,a2,a3,a4;
        a1 = new byte[_1mb/4];

        a2 = new byte[_1mb/4];
        a3 = new byte[_1mb*4];
        a4 = new byte[_1mb*4];
        a4 = null;
        a4 = new byte[_1mb*4];
    }
}
