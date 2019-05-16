package com.djcao.sell.spring.applicationcontext;

import com.djcao.sell.spring.beanfactory.Person;
import com.djcao.sell.spring.beanfactory.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/12/24
 */
public class ClassPathApplicationContextTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-applicationContext.xml");
        User dad = applicationContext.getBean("dad", User.class);
        dad.destroy();
        System.out.println(dad.getAge());
        Person bean = (Person)applicationContext.getBean("person");
        bean.test();
        applicationContext.registerShutdownHook();
    }
}
