package com.djcao.sell.design.strategy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public abstract class CashSuper {
    public int firstCondition;
    public int secondCondition;
    public Double price;
    public Double number;
    public abstract Double getResult();
}
