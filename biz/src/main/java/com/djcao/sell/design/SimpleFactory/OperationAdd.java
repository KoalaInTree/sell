package com.djcao.sell.design.SimpleFactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class OperationAdd extends Operation {
    @Override
    public Double process() {
        return firstNumber + secondNumber;
    }
}
