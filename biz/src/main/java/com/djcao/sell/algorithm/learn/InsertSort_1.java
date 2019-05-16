package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class InsertSort_1 extends AbstractSort {

    @Override
    public void sort() {
        int i = 1;
        while (i < values.length){
            int min = i;
            for (int j = i; j >= 0; j--){
                if (values[min] > values[j]){
                    swap(values, min, j);
                    min = j;
                }
            }
        }
    }
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {12,1,5,2,7,4,9,0};
        insertionSort.values = arr;
        insertionSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
