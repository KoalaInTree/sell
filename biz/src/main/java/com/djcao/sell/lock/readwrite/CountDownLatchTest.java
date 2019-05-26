package com.djcao.sell.lock.readwrite;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/30
 */
public class CountDownLatchTest {
   /* static ExecutorService executor = Executors.newFixedThreadPool(10);
    public  static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i=0;i<10;i++){
            executor.execute(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getId()+" count down");
            });
        }
        countDownLatch.await();
        System.out.println("finished");
        executor.shutdown();
    }*/

    class Worker implements Runnable{

        public void run(){
            print();
        }
    }

    public void print(){
        System.out.println("1");
    }
}
