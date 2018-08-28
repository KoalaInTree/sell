package com.djcao.sell.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/8/28
 */
public class ProxyTest implements InvocationHandler {

    private Object source;
    public Object bind(Object source){
        this.source = source;
        return Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),source.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("i'm hack");
        return method.invoke(source,args);
    }
    static class Hello implements IHello{
        @Override
        public void sayHi() {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();

        IHello hello = (IHello)proxyTest.bind(new Hello());
        hello.sayHi();
    }
}
