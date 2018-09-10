package com.djcao.sell.design.observer;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public class Foreground {
    List<Observer> observerList = Lists.newArrayList();

    public void add(Observer observer){
        observerList.add(observer);
    }

    public void delete(Observer observer){
        observerList.remove(observer);
    }

    public void notifyAllOb(){
        observerList.forEach(Observer::onMessage);
    }

    public static void main(String[] args) {
        Foreground foreground = new Foreground();
        Observer observer = new StockObserver("小张");
        foreground.add(observer);
        foreground.notifyAllOb();
    }
}
