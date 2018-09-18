package com.djcao.sell.design.abstractfactory;

/**
 * 抽象工厂模式与工厂方法模式的区别：
 *  工厂方法模式适用于只产生一个抽象产品且该抽象产品有多种实现方式。当商品接口有新实现方法时，只需增加一种对应的商品实现和商品工厂类采用工厂方法模式。
 *  抽象工厂模式适用于产生多个抽象产品，一个工厂产生所有的抽象产品的一种具体实现，且一家工厂对于一个抽象产品只有一个具体的实现方式。当有新的抽象产品出现时，每家工厂都需要实现之。
 *
 *  抽象唯一，而当有新的需求出现时要增加新的实现，则适用于工厂方法模式。对一种新的实现加一个新的工厂，符合开闭原则。
 *  抽象不唯一，就要考虑使用抽象工厂模式
 *  工厂方法模式一家工厂只产生一个产品，抽象工厂模式，一家工厂要实现所有的抽象产品
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
