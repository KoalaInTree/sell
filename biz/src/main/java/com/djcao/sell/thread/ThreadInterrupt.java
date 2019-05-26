package com.djcao.sell.thread;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/24
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("first is interrupt -->"+Thread.currentThread().isInterrupted());
        System.out.println("first is interrupt -->"+Thread.currentThread().isInterrupted());
    }
}
