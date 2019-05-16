package com.djcao.sell.design.chain;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class HandlerB implements Handlers {
    private Handlers handlers;

    public HandlerB(Handlers handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(Object o) {
        System.out.println("b");
        if (null != handlers)
            handlers.process(o);
    }
}
