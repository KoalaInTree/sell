package com.djcao.sell.algorithm.review1;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 * 算法时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 排序规则：每一趟选择最小的元素，放置最前面
 */
public class SelectSort extends AbstractSort {


    @Override
    public SelectSort sort() {
        for (int i = 0;i < value.length; i++){
            int min = i;
            for (int j = value.length -1; j >= i; j--){
                if (value[j] < value[min])
                    min = j;
            }
            if (min != i)
                swap(min,i);
        }
        return this;
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new SelectSort();
        if (abstractSort.sort().isSort())
            System.out.println(abstractSort.printValue());
    }
}
