package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class FastSort extends AbstractSort {

    @Override
    public void sort() {
        if (values != null)
        doSort(values, 0, values.length - 1);
    }

    private void doSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int i =  left, j = right;
        int mid = (left + right) >>> 1;
        while (i < j){
            while (arr[j] >= arr[mid] && j > i){
                j --;
            }
            while (arr[i] <= arr[mid] && i < j){
                i++;
            }
            if (i != j)
                swap(arr, i, j);
        }
        swap(arr, mid, j);
        doSort(arr, left, j - 1);
        doSort(arr, j+1, right);
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new FastSort();
        int[] arr = {0, 9, 1, 3, 8, 2, 0, 0, 0, 2, 3, 4, 1, 1, 3, 0, 0, 0};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(arr));
    }

}
