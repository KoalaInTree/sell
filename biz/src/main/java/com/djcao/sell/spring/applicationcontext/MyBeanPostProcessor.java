package com.djcao.sell.spring.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/26
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("invoke myBeanPostProcessor constructor>>>>>>>>");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke myBeanPostProcessor postProcessBeforeInitialization>>>>>>>>");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke myBeanPostProcessor postProcessAfterInitialization>>>>>>>>");
        return bean;
    }
}
