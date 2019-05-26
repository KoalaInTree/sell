package com.djcao.sell.algorithm.review1;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 * 时间复杂度：O(nlogn)
 * 空间复杂度:O(n)
 * 排序规则：分治
 */
public class MergeSort extends AbstractSort {
    @Override
    public AbstractSort sort() {
        merge(0,value.length - 1);
        return this;
    }

    private void merge(int first,int last){
        if (first >= last) return;
        int mid = (first + last) / 2,left = first,right = mid+1;
        merge(first,mid);
        merge(mid+1,last);
        int[] temp = new int[last - first + 1];
        int current = 0;
        while (left <= mid && right <= last){
            if (value[left] >= value[right]){
                temp[current++] = value[right++];
            } else {
                temp[current++] = value[left++];
            }
        }
        if (current < temp.length){
            if (left <= mid){
                while (current < temp.length)
                    temp[current++]  = value[left++];
            }else if (right <= last){
                while (current < temp.length)
                    temp[current++]  = value[left++];
            }
        }
        System.arraycopy(temp,0,value,first,temp.length);
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new MergeSort();
        if (abstractSort.sort().isSort())
            System.out.println(abstractSort.printValue());
    }
}
