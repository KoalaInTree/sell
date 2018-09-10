package com.djcao.sell.design.builder;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public class Asian extends PersonBuilder {
    @Override
    public PersonBuilder withHead() {
        System.out.println("圆头");
        return this;
    }

    @Override
    public PersonBuilder withBody() {
        System.out.println("中等身材");
        return this;
    }

    @Override
    public PersonBuilder withHand() {
        System.out.println("长手");
        return this;
    }

    @Override
    public PersonBuilder withFoot() {
        System.out.println("长脚");
        return this;
    }

    @Override
    public PersonBuilder withSkin() {
        System.out.println("黄皮肤");
        return this;
    }
}
