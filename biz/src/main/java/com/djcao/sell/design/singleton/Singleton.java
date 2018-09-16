package com.djcao.sell.design.singleton;

/**
 * 饿汉式单例模式 -- 线程安全--类的加载是互斥的。
 *
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/13
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        String sa = "ab";
        String sb = "cd";
        String sab=sa+sb;
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        String a = "123";
        String b = new String ("123");
        String c = "1";
        String d = "23";
        String e = c +d;
        String f = "1"+"23";
        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder.append(a).toString();
        StringBuffer stringBuffer = new StringBuffer();
        String toString = stringBuffer.append(a).toString();
        System.out.println(a == string);
        System.out.println(a == toString);
        System.out.println(string == toString);

        System.out.println(b == string);
        System.out.println(b == toString);
        System.out.println(string == toString);
        System.out.println(a == b);
        System.out.println(e == f);
    }
}
