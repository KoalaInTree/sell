package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class MergeSort_1 extends AbstractSort {

    @Override
    public void sort() {
        mergeSort(values, 0 , values.length - 1);
    }

    private void mergeSort(int[] arr,int left, int right){
        if (left >= right) return;
        int mid = (left + right) >>> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    private void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid, temp_index = 0;
        while (i < mid && j <= right && temp_index < temp.length){
            if (arr[i] <= arr[j]){
                temp[temp_index++] = arr[i++];
            }else {
                temp[temp_index++] = arr[j++];
            }
        }
        if (temp_index <= temp.length -1){
            while (i < mid){
                temp[temp_index++] = arr[i++];
            }
            while (j <= right){
                temp[temp_index++] = arr[j++];
            }
        }
        System.arraycopy(temp,0, arr, left, temp.length);
    }
    public static void main(String[] args) {
        AbstractSort abstractSort = new MergeSort_1();
        int[] arr = {12,1,5,2,7,4,9,0,0,1,5,8};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(abstractSort.values));
    }
}
