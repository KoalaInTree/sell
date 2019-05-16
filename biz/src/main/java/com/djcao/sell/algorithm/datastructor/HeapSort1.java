package com.djcao.sell.algorithm.datastructor;

import java.util.Arrays;

import com.djcao.sell.algorithm.learn.AbstractSort;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/28
 */
public class HeapSort1 extends AbstractSort{
    @Override
    public void sort() {
        if (values == null || values.length == 0) return;
        for (int i =  values.length-1 ;i > 0; i--){
            adjust(values,i+1);
            swap(values,0,i);
        }
    }

    public void adjust(int[] value,int length){
        int i = length / 2 -1;
        for (;i >= 0;i--){
            int leftChildIndex = getLeftChildIndex(i);
            int rightChildIndex = getRightChildIndex(i);
            int bigger = i;
            if (rightChildIndex < length){
                bigger = value[leftChildIndex] > value[rightChildIndex] ? leftChildIndex :rightChildIndex;
                bigger = value[bigger] > value[i] ? bigger : i;
            }else if (leftChildIndex < length){
                bigger = value[leftChildIndex] > value[bigger] ? leftChildIndex :bigger;
            }
            if (bigger != i)
                swap(value,i,bigger);
        }
    }

    public int getLeftChildIndex(int parent){
        return parent * 2 + 1;
    }

    public int getRightChildIndex(int parent){
        return parent * 2 + 2;
    }
    public static void main(String[] args) {
        AbstractSort abstractSort = new HeapSort1();
        int[] arr = {12,1,5,2,7,4,9,0};
        abstractSort.values = arr;
        abstractSort.sort();
        System.out.println(Arrays.toString(arr));
    }
}
