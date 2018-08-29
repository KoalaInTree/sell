package com.djcao.sell.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/8/29
 */
public class CglibProxy implements MethodInterceptor{
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("i am hack");
        Object invoke = method.invoke(target, objects);
        return invoke;
    }

}
