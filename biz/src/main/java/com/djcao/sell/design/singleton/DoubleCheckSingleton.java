package com.djcao.sell.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式单例
 * 双重校验单例模式，线程安全-性能损耗低于第一种
 *
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/13
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {
    }

    private static DoubleCheckSingleton getInstance(){
        if (null == doubleCheckSingleton){
            synchronized (DoubleCheckSingleton.class){
                doubleCheckSingleton = new DoubleCheckSingleton();
                System.out.println("create a singleton");
                return doubleCheckSingleton;
            }
        }
        return doubleCheckSingleton;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
           for (;;){
               int i = 1;
               executorService.execute(() ->{
                   DoubleCheckSingleton.getInstance();
               });
               if (i++ == 10) break;
           }
    }
}
