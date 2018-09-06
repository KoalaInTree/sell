package com.djcao.sell.design.strategy.designbyfactory;

import com.djcao.sell.design.strategy.CashSuper;
import com.djcao.sell.design.strategy.DiscountCash;
import com.djcao.sell.design.strategy.MoneyReturnCash;
import com.djcao.sell.design.strategy.NormalCash;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class CashReceiverFactory {

    public static CashSuper createStrategy(String type){
        switch (type){
            case "1": return new NormalCash();
            case "2": return new DiscountCash();
            case "3": return new MoneyReturnCash();
        }
        return null;
    }
}
