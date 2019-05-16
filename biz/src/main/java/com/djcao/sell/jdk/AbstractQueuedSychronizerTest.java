package com.djcao.sell.jdk;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/15
 */
public class AbstractQueuedSychronizerTest {

    @Test
    public void testIntegerOverflow(){
        int i = Integer.MAX_VALUE;

        System.out.println(i+1);
    }


    @Test
    public void testReentrantLock() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                reentrantLock.lock();
                countDownLatch.countDown();
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(15000);
                reentrantLock.lock();
                Thread.sleep(150000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

        countDownLatch.await();
        reentrantLock.lock();
        reentrantLock.unlock();
    }

    @Test
    public void testCountDownLantch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                        Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();

        Thread.sleep(7000);
        countDownLatch.await();
    }

    @Test
    public void test(){
        int minValue = Integer.MAX_VALUE;
        System.out.println(minValue);
    }
}
