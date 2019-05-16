package com.djcao.sell.algorithm.learn;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 排序思想：每次遍历未排序的数组，获取本次最小值有序的后面。
 * 时间复杂度：O(n2)
 * 适用范围：
 *
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/8
 */
public class SelectSort extends AbstractSort{

    @Override
    public void sort() {
        Objects.requireNonNull(values);
        for (int i=0;i<values.length;i++){
            int min = i;
            for (int j = i;j<values.length;j++){
                if (values[min] > values[j]){
                    min = j;
                }
            }
            if (i != min){
                swap(values,i,min);
            }
        }
    }
    public static void main(String[] args) {
        AbstractSort abstractSort = new SelectSort();
        int[] arr = {12,1,5,2,7,4,9,0};
        abstractSort.values = arr;
        abstractSort.sort();
        Stream.of(arr).forEach(System.out::println);
    }
}
