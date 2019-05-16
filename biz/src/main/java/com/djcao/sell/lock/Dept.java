package com.djcao.sell.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/29
 */
public class Dept {
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();
    private int count = 0;
    private int MAX = 100;
    public int produce() throws InterruptedException {
        lock.lock();
        int result;
        try {
            if (count == MAX){
                fullCondition.await();
            }
            result = ++count;
            System.out.println("生产了第"+result+"件商品");
            emptyCondition.signal();
        }finally {
            lock.unlock();
        }
        return result;
    }

    public int consume() throws InterruptedException {
        lock.lock();
        int result;
        try {
            if (0 == count){
                emptyCondition.await();
            }
            result = count--;
            System.out.println("消费了第"+result+"件商品");
            fullCondition.signal();
        }finally {
            lock.unlock();
        }
        return result;
    }
}
