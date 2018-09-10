package com.djcao.sell.design.factorymethod.leifen;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/9
 */
public class UndergraduateFactory implements ILeiFengFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
