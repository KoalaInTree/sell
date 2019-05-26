package com.djcao.sell.design.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object getProxyObject(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("current_time"+System.currentTimeMillis());
        Object invoke = method.invoke(target, args);
        System.out.println("after_execute_time"+System.currentTimeMillis());
        return invoke;
    }
}
