package com.djcao.sell.design.proxy.staticproxy;

import com.djcao.sell.design.proxy.Subject;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class SubjectImpl implements Subject {

    @Override
    public void sayHi() {
        System.out.println("hi");
    }
}
