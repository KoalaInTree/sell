package com.djcao.sell.designpattern.decorator;

/**
 * concreteComponent
 */
public class Person implements Content{

    public void dress(){
        System.out.println("我穿了 ");
    }

    public static void main(String[] args) {
        Person person = new Person();
        TShits tShits = new TShits(person);
        Coat coat = new Coat(tShits);
        coat.dress();
    }

}
