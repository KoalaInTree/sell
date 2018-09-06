package com.djcao.sell.design.strategy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class NormalCash extends CashSuper {
    @Override
    public Double getResult() {
        return price*number;
    }
}
