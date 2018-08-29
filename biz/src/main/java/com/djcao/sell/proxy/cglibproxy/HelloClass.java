package com.djcao.sell.proxy.cglibproxy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/8/29
 */
public class HelloClass {
    public void sayHi(){
        System.out.println("hello world");
    }

    public void hhh(){

    }

    public static void main(String[] args) {
        HelloClass helloClass = new HelloClass();
        helloClass.sayHi();
        helloClass.hhh();
    }
}
