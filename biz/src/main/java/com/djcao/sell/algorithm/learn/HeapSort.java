package com.djcao.sell.algorithm.learn;

import java.util.Arrays;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/28
 */
public class HeapSort extends AbstractSort {
    @Override
    public void sort() {
        buildHeap(values);
        for (int i = values.length - 1; i >= 0; i--){
            swap(values, 0, i);
            adjustHeap(values,0,i-1);
        }
    }

    private void buildHeap(int[] arr){
        for(int i = getParent(arr.length - 1); i >=0 ; i--){
            adjustHeap(arr, i, arr.length - 1);
        }
    }

    private void adjustHeap(int[] arr, int parentIndex, int lastIndex){
        int leftChildIndex = getLeftChild(parentIndex);
        int rightChildIndex = getRightChild(parentIndex);
        int biggerIndex = parentIndex;
        if (rightChildIndex <= lastIndex){
            biggerIndex = arr[leftChildIndex] > arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
        }else if (leftChildIndex <= lastIndex){
            biggerIndex = leftChildIndex;
        }
        if (arr[biggerIndex] > arr[parentIndex]){
            swap(arr, biggerIndex, parentIndex);
            adjustHeap(arr, biggerIndex, lastIndex);
        }
    }

    private int getParent(int childIndex){
        return childIndex / 2;
    }

    private int getLeftChild(int parentIndex){
        return parentIndex * 2 + 1;
    }

    private int getRightChild(int parentIndex){
        return parentIndex * 2 + 2;
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new HeapSort();
        int[] arr = {12,1,5,2,7,4,9,0};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
