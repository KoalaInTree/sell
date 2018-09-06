package com.djcao.sell.design.SimpleFactory;

import lombok.Data;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
@Data
public abstract class Operation {
    protected Double firstNumber;
    protected Double secondNumber;
    protected abstract Double process();
}
