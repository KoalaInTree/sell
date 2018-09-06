package com.djcao.sell.design.strategy.designbyfactory;

import java.util.Scanner;

import com.djcao.sell.design.strategy.CashSuper;
import com.djcao.sell.design.strategy.ReceiverStrategyEnum;

import static com.djcao.sell.design.strategy.ReceiverStrategyEnum.DISCOUNT;
import static com.djcao.sell.design.strategy.ReceiverStrategyEnum.MONEYRETUREN;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class CashierDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String price=null
            ,number=null,strategy=null,firstCondition = null,secondCondition = number;
        System.out.println("请输入单价:\r\n");
        if (scanner.hasNext()){
            price = scanner.next();
            System.out.println("请输入数量:\r\n");
        }
        if (scanner.hasNext()){
            number = scanner.next();
            System.out.println("请选择何种策略");
        }
        ReceiverStrategyEnum.printStrategy();
        if (scanner.hasNext()){
            strategy = scanner.next();
        }

        CashSuper cashSuper = CashReceiverFactory.createStrategy(strategy);
        if (null == cashSuper){
            System.out.println("暂无此收银策略");
            return;
        }
        if (DISCOUNT.getCode().equals(strategy)){
            System.out.println("请输入折扣");
            if (scanner.hasNext()){
                firstCondition = scanner.next();
                cashSuper.firstCondition = new Integer(firstCondition);
            }
        }
        if (MONEYRETUREN.getCode().equals(strategy)){
            System.out.println("请输入满多少");
            if (scanner.hasNext()){
                firstCondition = scanner.next();
                cashSuper.firstCondition = new Integer(firstCondition);
            }
            System.out.println("请输入减多少");
            if (scanner.hasNext()){
                secondCondition = scanner.next();
                cashSuper.secondCondition = new Integer(secondCondition);
            }
        }
        cashSuper.number = new Double(number);
        cashSuper.price = new Double(price);
        Double result = cashSuper.getResult();
        System.out.printf("共计收款:%.2f",result);
    }
}
