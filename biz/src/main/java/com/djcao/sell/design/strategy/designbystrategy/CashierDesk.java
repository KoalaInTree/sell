package com.djcao.sell.design.strategy.designbystrategy;

import java.util.Scanner;

import com.djcao.sell.design.strategy.CashSuper;
import com.djcao.sell.design.strategy.ReceiverStrategyEnum;
import com.djcao.sell.design.strategy.designbyfactory.CashReceiverFactory;

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
        Double result = null;
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

        CashContent cashSuper = new CashContent(strategy);
        if (DISCOUNT.getCode().equals(strategy)){
            System.out.println("请输入折扣");
            if (scanner.hasNext()){
                firstCondition = scanner.next();
            }
        }
        if (MONEYRETUREN.getCode().equals(strategy)){
            System.out.println("请输入满多少");
            if (scanner.hasNext()){
                firstCondition = scanner.next();
            }
            System.out.println("请输入减多少");
            if (scanner.hasNext()){
                secondCondition = scanner.next();
            }
        }
        result = cashSuper.getResult(number,price,firstCondition,secondCondition);
        System.out.printf("共计收款:%.2f",result);
    }
}
