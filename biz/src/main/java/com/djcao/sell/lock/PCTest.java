package com.djcao.sell.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/29
 */
public class PCTest {


    public static void main(String[] args) {
        ExecutorService producerES = Executors.newFixedThreadPool(100);
        ExecutorService customerES = Executors.newFixedThreadPool(100);
        Dept dept = new Dept();
        Customer customer = new Customer(dept);
        Producer producer = new Producer(dept);
        for (int i=0;i<200;i++){
            producerES.execute(producer);
        }
        for (int i=0;i<200;i++){
            customerES.execute(customer);
        }


    }
}
