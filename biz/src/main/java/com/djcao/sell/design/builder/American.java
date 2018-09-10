package com.djcao.sell.design.builder;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public class American extends PersonBuilder {
    @Override
    public PersonBuilder withHead() {
        System.out.println("大头");
        return this;
    }

    @Override
    public PersonBuilder withBody() {
        System.out.println("大肚子");
        return this;
    }

    @Override
    public PersonBuilder withHand() {
        System.out.println("大手");
        return this;
    }

    @Override
    public PersonBuilder withFoot() {
        System.out.println("大脚");
        return this;
    }

    @Override
    public PersonBuilder withSkin() {
        System.out.println("白皮肤");
        return this;
    }
}
