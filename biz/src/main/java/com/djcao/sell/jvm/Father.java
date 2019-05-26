package com.djcao.sell.jvm;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/5
 */
public class Father implements FatherInter{
    public final static int father_constance = 1;
    public static int father_stic = 2;
    static {
        System.out.println("father init...");
    }
    public Father(){
        System.out.println("father constructor");
    }
}
