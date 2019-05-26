package com.djcao.sell.spring.beanfactory;

import java.util.List;
import java.util.Map;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/30
 */
@Data
@Component
public class User implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{

    private String name = Thread.currentThread().getName();

    private int age = 11;

    private String password;

    private User other;

    private Map map;

    private List<User> list ;

    public User() {
        System.out.println("invoke User constructor>>>>>>>");
    }

    public void setAge(int age) {
        System.out.println("invoke user.setAge method>>>>>>");
        this.age = age;
    }

    public void init(){
        System.out.println("invoke user init mehthod>>>>>>>");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("invoke bean name aware>>>>>");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("invoke beanFactory aware >>>>>");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("invoke applicationContext aware >>>>>");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("invoke disposableBean.destroy method >>>>>");
    }

    public void destroy2(){
        System.out.println("invoke bean.destroy-method >>>>>");
    }
}
