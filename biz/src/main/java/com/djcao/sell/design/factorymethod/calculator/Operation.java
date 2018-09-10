package com.djcao.sell.design.factorymethod.calculator;

import lombok.Data;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/9
 */
@Data
public abstract class Operation {
    protected Double numberA;
    protected Double numberB;
    public abstract Double getResult();
}
