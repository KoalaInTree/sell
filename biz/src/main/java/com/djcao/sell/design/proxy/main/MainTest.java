package com.djcao.sell.design.proxy.main;

import com.djcao.sell.design.proxy.Subject;
import com.djcao.sell.design.proxy.dynamic.cglib.CglibDynamicProxy;
import com.djcao.sell.design.proxy.dynamic.jdk.DynamicProxy;
import com.djcao.sell.design.proxy.staticproxy.StaticProxy;
import com.djcao.sell.design.proxy.staticproxy.SubjectImpl;
import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class MainTest {

    @Test
    public void testStaticProxy(){
        Subject subject = new StaticProxy();
        subject.sayHi();
    }

    @Test
    public void testDynamicProxy(){
        Subject subject = (Subject)new DynamicProxy().getProxyObject(new SubjectImpl());
        subject.sayHi();
    }

    @Test
    public void testCglibProxy(){
        Subject subject = (Subject)new CglibDynamicProxy().getProxyObject(new SubjectImpl());
        subject.sayHi();
    }
}
