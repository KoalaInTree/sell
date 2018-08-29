package com.djcao.sell.proxy.cglibproxy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/8/29
 */
public class Plus {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Lpl lpl = new Lpl();
        Lpl bind = (Lpl)cglibProxy.bind(lpl);
        bind.sayHi();
    }
    static class Lpl{
        public void sayHi(){
            System.out.println("hello world");
        }
    }

}
