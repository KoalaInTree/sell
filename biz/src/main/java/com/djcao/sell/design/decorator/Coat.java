package com.djcao.sell.designpattern.decorator;

/**
 * concreteDecorator
 */
public class Coat implements Cloth {

    private Content content;

    public Coat(Content content) {
        this.content = content;
    }

    @Override
    public void dress() {
        content.dress();
        System.out.println("coat ");
    }
}
