package com.djcao.sell.lock.readwrite;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/31
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,() -> {
            System.out.println("it's ok");
        });

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

       /* Thread.sleep(10000);
        cyclicBarrier.await();*/
    }
}
