package com.djcao.sell.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/24
 */
public class LockDebug {
    final static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(false);
        /*
        Thread thread = new Thread(() -> {
           lock.lock();
           while (true){}
        });
        thread.start();
        Thread.sleep(2000);
        lock.tryLock(20, TimeUnit.SECONDS);
        lock.unlock();*/

        /*Thread thread = new Thread(() -> {
            try {
                LockSupport.park(lock);
                System.out.println("1");
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.println("2");
        });
        thread.start();

        new Thread(() -> {
            LockSupport.unpark(thread);
        }).start();*/

        /*Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000000);
                System.out.println("wake up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do something");
        });
        thread1.start();
        Thread.sleep(3000);
        thread1.interrupt();*/

        /*new Thread(() -> {
            synchronized (object){
                System.out.println("id#"+Thread.currentThread().getId()+"#name#"+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        synchronized (object){
            Thread.sleep(3000);
            object.wait(1000);
            System.out.println("id#"+Thread.currentThread().getId()+"#name#"+Thread.currentThread().getName());
            System.out.println("wake up");
        }*/

        LockDebug lockDebug = new LockDebug();
        lockDebug.print("hello,wait(0)");
        System.out.println("--- print end ----");
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
        System.out.println("thread join out");
    }
    private synchronized void print(String msg) throws InterruptedException {
        System.out.println(msg);
        wait(1);
        System.out.println("i'm under of wait(0)");

    }
}
