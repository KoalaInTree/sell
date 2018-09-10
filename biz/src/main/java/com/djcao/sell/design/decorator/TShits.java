package com.djcao.sell.designpattern.decorator;

/**
 * concreteDecorator
 */
public class TShits implements Cloth{

    private Content content;

    public TShits(Content content){
        this.content = content;
    }
    @Override
    public void dress() {
        content.dress();
        System.out.println("Tshits ");
    }
}
