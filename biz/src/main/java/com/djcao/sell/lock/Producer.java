package com.djcao.sell.lock;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/29
 */
public class Producer implements Runnable{
    private Dept dept;

    public Producer(Dept dept) {
        this.dept = dept;
    }

    public void run(){
        try {
            dept.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        double v = Double.valueOf("0");
        v= v /100;
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(v);
        System.out.println(format);

    }
}
