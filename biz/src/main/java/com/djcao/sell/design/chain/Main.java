package com.djcao.sell.design.chain;

import org.junit.Test;
import sun.plugin.net.protocol.jar.Handler;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/11
 */
public class Main {
    @Test
    public void testHandler(){
        Handlers handler = new HandlerA(new HandlerB(null));
        handler.process(new Object());
    }
}
