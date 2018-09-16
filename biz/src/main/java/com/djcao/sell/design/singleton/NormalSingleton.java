package com.djcao.sell.design.singleton;

/**
 * 懒汉式单例
 * 普通单例模式--线程安全
 *
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/13
 */
public class NormalSingleton {

    private static NormalSingleton instance;
    private NormalSingleton() {
    }

    public static synchronized NormalSingleton getInstance(){
        if (null == instance){
            return new NormalSingleton();
        }
        return instance;
    }
}
