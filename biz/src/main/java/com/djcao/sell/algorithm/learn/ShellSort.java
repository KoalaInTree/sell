package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class ShellSort extends AbstractSort{


    @Override
    public void sort() {
        int n = values.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < n; i++){
                for (int j = i;j >= h && values[j] < values[j - h]; j -= h){
                    swap(values, j - h, j);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new ShellSort();
        int[] arr = {12,1,5,2,7,4,9,0};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
