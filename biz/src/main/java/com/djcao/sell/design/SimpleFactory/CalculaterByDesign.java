package com.djcao.sell.design.SimpleFactory;

import java.util.Scanner;


/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-07
 */
public class CalculaterByDesign {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber=null
            ,secondNumber=null,operator=null;
        System.out.println("请输入第一个数:\r\n");
        if (scanner.hasNext()){
            firstNumber = scanner.next();
            System.out.println("请输入运算符:\r\n");
        }
        if (scanner.hasNext()){
            operator = scanner.next();
            System.out.println("请输入第二个数:\r\n");
        }
        if (scanner.hasNext()){
            secondNumber = scanner.next();
        }
        Operation operation = OperationFactory.createOperation(operator);
        if (null == operation){
            System.out.println("输入的运算符有误\r\n");
            return;
        }
        operation.firstNumber=new Double(firstNumber);
        operation.secondNumber=new Double(secondNumber);
        Double result = operation.process();
        if(null != result){
            System.out.printf("计算的结果是:%.2f",result);
        }else {
            System.out.println("输入有误，请检查输入的内容\r\n");
        }

    }
}
