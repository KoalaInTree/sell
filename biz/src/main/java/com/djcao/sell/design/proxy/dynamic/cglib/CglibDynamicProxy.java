package com.djcao.sell.design.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class CglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public Object getProxyObject(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("current_time"+System.currentTimeMillis());
        //使用代理类的方法调用代理类的父类方法
        //Object invoke = methodProxy.invokeSuper(o, objects);
        Object invoke = method.invoke(target);
        System.out.println("after_execute_time"+System.currentTimeMillis());
        return invoke;
    }
}
