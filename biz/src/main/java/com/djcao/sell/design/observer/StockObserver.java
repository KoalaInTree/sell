package com.djcao.sell.design.observer;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public class StockObserver implements Observer {
    private String name;

    public StockObserver(String name) {
        this.name = name;
    }

    public void onMessage(String status){
        System.out.println("我收到通知了，status是"+status+"溜了溜了");
    }
}
