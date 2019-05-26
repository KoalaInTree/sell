package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class SelectSort_1 extends AbstractSort {

    @Override
    public void sort() {
        int i = 0;
        while (i < values.length){
            int min = i;
            for (int j = i + 1; j < values.length; j++){
                if (values[min] > values[j]){
                    min = j;
                }
            }
            swap(values,i,min);
            i++;
        }
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new SelectSort_1();
        int[] arr = {12,1,5,2,7,4,9,0};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
