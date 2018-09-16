package com.djcao.sell.design.observer;

import java.util.List;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public class Foreground {

    @Getter
    @Setter
    private String status;

    List<Observer> observerList = Lists.newArrayList();

    public void add(Observer observer){
        observerList.add(observer);
    }

    public void delete(Observer observer){
        observerList.remove(observer);
    }

    public void notifyAllOb(){
        observerList.forEach(observer -> observer.onMessage(status));
    }

    public static void main(String[] args) {
        Foreground foreground = new Foreground();
        Observer observer = new StockObserver("小张");
        foreground.add(observer);
        foreground.status = "老板来了";
        foreground.notifyAllOb();
    }
}
