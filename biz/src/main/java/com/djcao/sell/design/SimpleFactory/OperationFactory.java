package com.djcao.sell.design.SimpleFactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class OperationFactory {

    public static Operation createOperation(String operator){
        switch (operator){
            case "+": return new OperationAdd();
            case "-": return new OperationSub();
            case "*": return new OperationMul();
            case "/": return new OperationDiv();
        }
        return null;
    }
}
