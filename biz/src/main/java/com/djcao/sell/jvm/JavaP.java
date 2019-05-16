package com.djcao.sell.jvm;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/4/8
 */
public class JavaP {
    public static void main(String[] args) {
        int i = 0;
        int j = 2;
        int temp = i != (i = j) ? i : j;
        System.out.println(temp);
    }
}
