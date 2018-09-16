package com.djcao.sell.design.abstractfactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-13
 */
public class ConcreteFactoryA extends AbstractFactory {
    @Override
    public ProductV1 createProductV1() {
        return new ProductV1ByA();
    }

    @Override
    public ProductV2 createProductV2() {
        return new ProductV2ByA();
    }
}
