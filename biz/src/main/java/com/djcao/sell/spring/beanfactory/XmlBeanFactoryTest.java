package com.djcao.sell.spring.beanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/28
 */
public class XmlBeanFactoryTest {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-applicationContext.xml"));
        User user = xmlBeanFactory.getBean("dad", User.class);
        System.out.println(user);

    }
}
