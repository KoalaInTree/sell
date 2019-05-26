package com.djcao.sell.jvm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/3
 */
public class Volatile {

    int a=0;
    ReentrantLock lock = new ReentrantLock();
    @Test
    public void showNoVolatile() throws InterruptedException {
        int number = 300000;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(number);
        for (int i=0;i<number;i++){
            executorService.execute(()->{
                add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(a);
    }

    public void add(){
        a++;
    }
}
