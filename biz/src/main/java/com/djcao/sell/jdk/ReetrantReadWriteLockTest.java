package com.djcao.sell.jdk;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/16
 */
public class ReetrantReadWriteLockTest {

    @Test
    public void testReadShare() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReadLock readLock = readWriteLock.readLock();
        new Thread(() -> {
            readLock.lock();
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        readLock.lock();
    }

    @Test
    public void testWrite() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        WriteLock writeLock = readWriteLock.writeLock();
        new Thread(() -> {
            writeLock.lock();
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        writeLock.lock();
    }
}
