package com.djcao.sell.design.SimpleFactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class OperationDiv extends Operation {
    @Override
    protected Double process() {
        if (secondNumber.intValue() == 0){
            return null;
        }
        return firstNumber / secondNumber;
    }
}
