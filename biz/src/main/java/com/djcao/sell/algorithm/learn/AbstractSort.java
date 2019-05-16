package com.djcao.sell.algorithm.learn;

import java.util.stream.Stream;

import org.springframework.util.StringUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/8
 */
public abstract class AbstractSort {
    public int[] values;

    public abstract void sort();

    protected void swap(int[] arr,int source,int target){
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

    public static void main(String[] args) {
        String path = "mybatis/application/../other.ff";
        System.out.println(StringUtils.cleanPath(path));
    }
}
