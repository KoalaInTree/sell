package com.djcao.sell.design.SimpleFactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class OperationSub extends Operation {
    @Override
    protected Double process() {
        return firstNumber-secondNumber;
    }
}
