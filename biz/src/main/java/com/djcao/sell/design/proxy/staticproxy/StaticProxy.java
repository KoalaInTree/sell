package com.djcao.sell.design.proxy.staticproxy;

import com.djcao.sell.design.proxy.Subject;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class StaticProxy implements Subject {

    private SubjectImpl target;

    public StaticProxy() {
        this.target = new SubjectImpl();
    }

    @Override
    public void sayHi() {
        System.out.println("current_time:" + System.currentTimeMillis());
        target.sayHi();
        System.out.println("after_execute_time:" + System.currentTimeMillis());
    }
}
