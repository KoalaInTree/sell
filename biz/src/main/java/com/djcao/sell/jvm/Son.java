package com.djcao.sell.jvm;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/5
 */
public class Son extends Father implements SonInter{

    static {
        System.out.println("son init...");
    }

    public final static int son_constance = 10;
    public static int son_stic = 20;
}
