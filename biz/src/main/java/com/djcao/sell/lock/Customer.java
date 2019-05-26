package com.djcao.sell.lock;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/29
 */
public class Customer implements Runnable{
    private Dept dept;

    public Customer(Dept dept) {
        this.dept = dept;
    }

    public void run(){
        try {
            int consume = dept.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
