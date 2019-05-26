package com.djcao.sell.lock;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.Lists;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/22
 */
public class LockTest {
    private ReentrantLock lock = new ReentrantLock(false);
    private List<String> list = Lists.newArrayList();
    private Condition addCondition = lock.newCondition();
    private Condition subCondition = lock.newCondition();
    private static int num = 0;
    public void add(){
        try {
            lock.lock();
            if (list.size() == 10){
                addCondition.await();
            }
            list.add("add+"+num);
            num++;
            System.out.println(list.get(list.size()-1));
            subCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sub(){
        try {
            lock.lock();
            if (list.size() == 0){
                subCondition.await();
            }
            String remove = list.remove(list.size() - 1);
            num--;
            System.out.println("remove -->"+remove);
            if (list.size() > 0 ){
                System.out.println("current -->"+list.get(list.size()-1));
            }
            addCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor addExecutor = new ThreadPoolExecutor(10,20,1*1000*10,MILLISECONDS,new LinkedBlockingQueue<Runnable>(50),new RejectedExecutionHandler(){
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        ThreadPoolExecutor subExecutor = new ThreadPoolExecutor(10,20,1*1000*10,MILLISECONDS,new LinkedBlockingQueue<Runnable>(50),new RejectedExecutionHandler(){
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        LockTest lockTest = new LockTest();
        for (int i=0;i<20;i++){
            addExecutor.execute(lockTest::add);
        }
        for (int i=0;i<20;i++){
            subExecutor.execute(lockTest::sub);
        }
    }
}
