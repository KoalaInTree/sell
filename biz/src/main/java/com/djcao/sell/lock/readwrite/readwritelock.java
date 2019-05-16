package com.djcao.sell.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.*;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/30
 */
public class readwritelock {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
        ReadLock readLock = readWriteLock.readLock();
        WriteLock writeLock = readWriteLock.writeLock();
        try {
            new Thread(() -> {
                readLock.lock();
                System.out.println(Thread.currentThread().getId()+",first lock readLock");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.unlock();
            }).start();

            new Thread(() -> {
                readLock.lock();
                System.out.println(Thread.currentThread().getId()+",second lock readLock");
                for (int i=0;i<100000;i++){
                    i = i;
                }
                readLock.unlock();
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeLock.lock();
                System.out.println(Thread.currentThread().getId()+", first lock writeLock");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId()+", first lock writeLock wake up");
                for (int i=0;i<100000;i++){
                    i = i;
                }
                writeLock.unlock();
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeLock.lock();
                System.out.println(Thread.currentThread().getId()+"second lock writeLock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId()+"second lock writeLock wake up");
                for (int i=0;i<100000;i++){
                    i = i;
                }
                writeLock.unlock();
            }).start();
        }catch (Exception e){

        }finally {
        }
    }
}
