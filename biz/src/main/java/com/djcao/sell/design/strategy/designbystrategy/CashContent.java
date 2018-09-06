package com.djcao.sell.design.strategy.designbystrategy;

import com.djcao.sell.design.strategy.CashSuper;
import com.djcao.sell.design.strategy.DiscountCash;
import com.djcao.sell.design.strategy.MoneyReturnCash;
import com.djcao.sell.design.strategy.NormalCash;
import org.apache.commons.lang3.StringUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class CashContent {
    CashSuper cashSuper;

    public CashContent(String type) {
        switch (type){
            case "1": cashSuper = new NormalCash();break;
            case "2": cashSuper = new DiscountCash();break;
            case "3": cashSuper = new MoneyReturnCash();break;
        }
    }

    public Double getResult(String number,String price,String first,String second){
        cashSuper.number=new Double(number);
        cashSuper.price=new Double(price);
        if (StringUtils.isNotBlank(first))
        cashSuper.firstCondition=new Integer(first);
        if (StringUtils.isNotBlank(second))
        cashSuper.secondCondition=new Integer(second);
        return cashSuper.getResult();
    }
}
