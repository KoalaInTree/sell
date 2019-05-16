package com.djcao.sell.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/2
 */
public class ExecutorServiceTest {

    public void newOne(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
    }
}
