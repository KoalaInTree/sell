package com.djcao.sell.design.builder;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/10
 */
public abstract class PersonBuilder {
    protected Person person;
    public Person build(){
        person = new Person();
        withHand();
        withBody();
        withHead();
        withSkin();
        withFoot();
        return person;
    }
    protected abstract PersonBuilder withHead();
    protected abstract PersonBuilder withBody();
    protected abstract PersonBuilder withHand();
    protected abstract PersonBuilder withFoot();
    protected abstract PersonBuilder withSkin();
}
