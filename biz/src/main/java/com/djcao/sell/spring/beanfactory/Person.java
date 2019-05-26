package com.djcao.sell.spring.beanfactory;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/30
 */
@Service("person")
public class Person implements Man{

    public void test() {
        System.out.println("person.test()");
        ((Man)(AopContext.currentProxy())).printTime();
    }

    public void printTime(){
        System.out.println(System.currentTimeMillis());
    }
}
