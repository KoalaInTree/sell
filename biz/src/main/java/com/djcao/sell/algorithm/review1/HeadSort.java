package com.djcao.sell.algorithm.review1;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 */
public class HeadSort extends AbstractSort {
    @Override
    public AbstractSort sort() {
        for (int i = 0 ;i < value.length; i++){
            adjust(value.length - i);
            swap(0,value.length-i-1);
        }
        return this;
    }

    public void adjust(int length){
        int left,right,bigger;
        for (int i = length / 2 + 1; i >= 0;i--){
            left = getLeftChild(i);
            right = getRightChild(i);
            bigger = i;
            if (right < length){
                bigger = value[left] >= value[right] ? left : right;
                bigger = value[bigger] > value[i] ? bigger : i;
            }else if (left < length){
                bigger = value[bigger] > value[left] ? bigger : left;
            }
            if (bigger != i)
                swap(i,bigger);
        }
    }

    private int getLeftChild(int parent){
        return parent * 2 + 1;
    }

    private int getRightChild(int parent){
        return parent * 2 + 2;
    }
    public static void main(String[] args) {
        AbstractSort abstractSort = new HeadSort();
        if (abstractSort.sort().isSort())
            System.out.println(abstractSort.printValue());
    }

}
