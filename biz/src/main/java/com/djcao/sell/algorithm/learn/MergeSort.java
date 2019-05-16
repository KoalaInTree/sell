package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class MergeSort extends AbstractSort {

    @Override
    public void sort() {
        mergeSort(values, 0, values.length - 1);
    }

    public void mergeSort(int[] origin, int left, int right){
        if (left >= right) return;
        int mid = (left + right) >>> 1;
        mergeSort(origin, left, mid);
        mergeSort(origin, mid + 1, right);
        merge(origin, left, right, mid);
    }

    private void merge(int[] origin, int left, int right, int mid) {
        int[] target = new int[right - left + 1];
        int left_index = left, right_index = mid+1, current_index = 0;
        while (current_index <= target.length - 1 && left_index <= mid && right_index <= right){
            if (values[left_index] >= values[right_index]){
                target[current_index++] = values[right_index++];
            }else {
                target[current_index++] = values[left_index++];
            }
        }
        if (current_index <= target.length - 1){
            if (left_index > mid ){
                while (right_index <= right){
                    target[current_index] = origin[right_index];
                    right_index++;
                    current_index++;
                }
            }else if (right_index > right){
                while (left_index <= mid){
                    target[current_index] = origin[left_index];
                    left_index++;
                    current_index++;
                }
            }
        }
        for (int temp = 0; temp < target.length;temp++){
            values[left + temp] = target[temp];
        }
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new MergeSort();
        int[] arr = {12,1,5,2,7,4,9,0,1};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(abstractSort.values));
    }
}
