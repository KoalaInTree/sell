package com.djcao.sell.design.abstractfactory;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-13
 */
public class ProductV1ByB implements ProductV1{
    @Override
    public String createByWho() {
        return "B";
    }
}
