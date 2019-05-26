package com.djcao.sell.lock.currentcollection;

import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/4
 */
public class MapTest {

    static int hashBit = 0x7fffffff;

    private static void testArrayLength(){
        Object[] objects = new Object[10];
        System.out.println(objects.length);
    }

    private static void testHashSpread(){
        int spread = spread(new Object().hashCode());
        System.out.println(spread);
    }

    private static void testThreadPoolExecutor(){
        int i = -1 << 29;
        i = i - 1;
        int j = i | 0;
        System.out.println(j);
    }

    private static void testNewThreadPoolExecutor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
            (r, executor1) -> {
                try {
                    executor1.getQueue().put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        executor.execute(() -> {
            System.out.println("aaa");
        });

    }

    private static void testLeftMove(){
        int i = -1;
        i = i << 29;
        System.out.println(Integer.toBinaryString(i));
    }

    private static void testDecimalFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        CountDownLatch countDownLatch = new CountDownLatch(10000000);
        for (int i = 0; i < 10000000 ; i++){
            final int fi = i;
            executorService.execute(() -> {
                try {
                    countDownLatch.countDown();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("shut down");
        executorService.shutdown();

    }
    private static int spread(int hash){
        return (hash ^ (hash >>> 16)) & hashBit;
    }

    public static void main(String[] args) {
        testDecimalFormat();
    }
}
