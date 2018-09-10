package com.djcao.sell.design.strategy;

import com.djcao.sell.design.strategy.CashSuper;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class MoneyReturnCash extends CashSuper {
    @Override
    public Double getResult() {
        return price*number-price*number/firstCondition*secondCondition;
    }
}
