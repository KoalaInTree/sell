package com.djcao.sell.algorithm.learn;

import java.util.stream.Stream;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/8
 */
public class InsertionSort extends AbstractSort{

    /**
     * 从小到大排序
     * @return
     */
    public void sort(){
        if(null == values || values.length == 0){
            return;
        }
        /*for (int i=0;i<values.length;i++){
            int key = values[i];
            for (int j=i-1;j>=0;j--){
                if (key < values[j]){
                    values[j+1] = values[j];
                    values[j] = key;
                }else {
                    break;
                }
            }
        }*/
        for (int i=0 ; i< values.length ; i++){
            int j = i;
            while (j > 0 && values[j] < values[j - 1]){
                swap(values,j,j-1);
                j--;
            }
        }
    }
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {12,1,5,2,7,4,9,0};
        insertionSort.values = arr;
        insertionSort.sort();
        Stream.of(arr).forEach(System.out::println);
    }
}
