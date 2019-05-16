package com.djcao.sell.spring.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/11/28
 */
public class Test {

    private static void testIndetOf(){
        String s = "kjsaashdsahdksahdsakdhsakdhksahdkasjkjsaashdsahdksahdsakdhsakdhksahdkasjkjsaashdsahdksahdsakdhsakdhksahdkasjkjsaashdsahdksahdsakdhsakdhksahdkasjkjsaashdsahdksahdsakdhsakdhksahdkasjkjsaashdsahdksahdsakdhsakdhksahdkasjkjsaashdsahdksahdsakdhsakdhksahdkasj";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < 100000 ;i++){
            stringBuilder.append(s);
        }
        stringBuilder.toString().indexOf("idname");
    }

    public static void main(String[] args) {
        System.out.println(1 << 30 > Integer.MAX_VALUE );
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        for (int i=0 ;i< 40 ;i++){
            testIndetOf();
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}
