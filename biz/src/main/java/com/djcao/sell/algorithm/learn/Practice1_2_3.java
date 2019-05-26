package com.djcao.sell.algorithm.learn;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/2
 */

/**
 * 1、a^(log(a)(b))=b
 2、log(a)(a^b)=b
 3、log(a)(MN)=log(a)(M)+log(a)(N);
 4、log(a)(M÷N)=log(a)(M)-log(a)(N);
 5、log(a)(M^n)=nlog(a)(M)
 换地公式  log(y)(x) =log(e)(x) / log(e)(y)
 */
public class Practice1_2_3 {
    /**
     *  假设我们正比较插入排序与归并排序在相同机器上的实现。对规模为n的输入，插入排序运行8n^2步，而归并排序运行
     * 64nlgn步。问对哪些n值，插入排序优于归并排序？
     */

    private int n;
    /**
     * 插入排序常量
     */
    private int a;

    //插入排序公式
    private double onePattern(){
        return a * Math.pow(n,2);
    }

    private int b;

    //归并排序公式--换地公式
    private double otherPattern(){
        return b *  Math.pow(2,n);
    }

    public static void main(String[] args) {
        Practice1_2_3 practice122 = new Practice1_2_3();
        practice122.a = 100;
        practice122.b = 1;
        for (int i = 1 ;;i++){
            practice122.n = i;
            if (practice122.onePattern() < practice122.otherPattern()){
                System.out.println("n == "+i);
                System.out.println(practice122.onePattern());
                System.out.println(practice122.otherPattern());
                break;
            }
        }
    }

}
