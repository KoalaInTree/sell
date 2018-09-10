package com.djcao.sell.design.factorymethod.calculator;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/9
 */
public class OperationMul extends Operation {
    @Override
    public Double getResult() {
        return numberA * numberB;
    }
}
