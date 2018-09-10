package com.djcao.sell.designpattern.SimpleFactory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018-09-06
 */
public class Calculator {


    private static Pattern pattern = Pattern.compile("[0-9]+");
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
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
        Integer result = calculator.process(firstNumber,secondNumber,operator);
        if(null != result){
            System.out.printf("计算的结果是:%d",result);
        }else {
            System.out.println("输入有误，请检查输入的内容\r\n");
        }
    }

    private Integer process(String firstNumber,String secondNumber,String operator){
        Matcher firstMatcher = pattern.matcher(firstNumber);
        boolean fistMathch = firstMatcher.matches();
        Matcher secondMatcher = pattern.matcher(secondNumber);
        boolean secondMatch = secondMatcher.matches();
        if (!fistMathch || !secondMatch){
            return null;
        }
        switch (operator) {
            case "+":
                return Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);
            case "-":
                return Integer.valueOf(firstNumber) - Integer.valueOf(secondNumber);
            case "*":
                return Integer.valueOf(firstNumber) * Integer.valueOf(secondNumber);
            case "/":
                return Integer.valueOf(firstNumber) / Integer.valueOf(secondNumber);
            default:
                return null;
        }


    }
}
