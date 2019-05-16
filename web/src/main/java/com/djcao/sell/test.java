package com.djcao.sell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/19
 */
public class test {
    public static void main(String[] arges) {

        Scanner sc = new Scanner(System.in);

        String strTotal = sc.nextLine();
        String strPrices = sc.nextLine();

        Integer total = Integer.parseInt(strTotal);
        String splitPrices[] = strPrices.split(" ");

        List<Integer> prices = new ArrayList<>();
        for (String s : splitPrices) {
            Integer price = Integer.parseInt(s);
            if (price >= 0 && price <= 10000) {
                prices.add(price);
            }
        }
        //从小到大排序
        Collections.sort(prices);

        //判断当前合计价格+下一个价格是否大于上线
        Integer sumPrice = 0;
        for (Integer price : prices) {
            if (sumPrice + price <= total) {
                sumPrice += price;
            }else{
                break;
            }
        }
        System.out.println(sumPrice);
        long s;
    }

    @Test
    public void testStringSubstring(){
        int i = 5;
        int j = (++i) + (++i)+ (++i);
        System.out.println(j);
    }
}