package com.djcao.sell.design.chain;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class HandlerA implements Handlers {
    private Handlers handlers;

    public HandlerA(Handlers handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(Object o) {
        System.out.println("print a");
        if (null != handlers)
            handlers.process(o);
        else { System.out.println("end"); }
    }
}
