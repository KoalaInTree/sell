package com.djcao.sell.algorithm.learn;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/16
 */
public class Bushu {
    @Test
    public void findComplement() {
        int num = 2147483647;
        int n = num;
        int result = 0;
        num -= 1;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        num += 1;
        int length = (int)(Math.log(num) / Math.log(2));
        if(n > (int)Math.pow(2,30))
            length = 31;
        int[] bits = new int[length];
        for(int index = 0;index < length; index ++){
            bits[index] = n % 2;
            result += (1-(n % 2)) * (int)Math.pow(2,index);
            n /= 2;
        }

        System.out.println( result);
    }
}
