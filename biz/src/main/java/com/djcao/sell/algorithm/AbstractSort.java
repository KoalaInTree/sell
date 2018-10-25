package com.djcao.sell.algorithm;

import java.util.stream.Stream;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/8
 */
public abstract class AbstractSort {
    protected int[] values;

    protected abstract void sort();

    protected void swap(int[] arr,int source,int target){
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }
}
