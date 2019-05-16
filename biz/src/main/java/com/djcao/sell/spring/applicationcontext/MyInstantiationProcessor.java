package com.djcao.sell.spring.applicationcontext;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/26
 */
public class MyInstantiationProcessor implements InstantiationAwareBeanPostProcessor {
    public MyInstantiationProcessor() {
        System.out.println("invoke InstantiationProcessor mehtod >>>>>>>>");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("invoke beforeInstantiation method >>>>>");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("invoke afterInstantiation method >>>>>");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName) throws BeansException {
        System.out.println("invoke postProcessPropertyValue method >>>>>>");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke beforeInit>>>>");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke AfterInit>>>>");
        return bean;
    }
}
