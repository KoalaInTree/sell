package com.djcao.sell.design.abstractfactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-13
 */
public abstract class AbstractFactory {

    public abstract ProductV1 createProductV1();

    public abstract ProductV2 createProductV2();

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactoryB();
        ProductV1 productV1 = abstractFactory.createProductV1();
        ProductV2 productV2 = abstractFactory.createProductV2();
        System.out.println(productV1.createByWho());
        System.out.println(productV2.createByWho());

    }
}
