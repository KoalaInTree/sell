package com.djcao.sell.design.factorymethod.calculator;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/9
 */
public class OperationSubFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
