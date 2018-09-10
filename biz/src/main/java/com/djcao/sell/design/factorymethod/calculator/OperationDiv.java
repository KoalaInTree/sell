package com.djcao.sell.design.factorymethod.calculator;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/9
 */
public class OperationDiv extends Operation {
    @Override
    public Double getResult() {
        if (numberB == 0 ){
            throw new IllegalArgumentException("by zero");
        }
        return numberA / numberB;
    }
}
