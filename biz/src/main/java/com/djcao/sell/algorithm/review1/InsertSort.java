package com.djcao.sell.algorithm.review1;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 * 算法时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 排序规则:每次把元素插入到有序数组中
 */
public class InsertSort extends AbstractSort {
    @Override
    public AbstractSort sort() {
        for (int i=1; i < value.length; i++){
            for (int j = i; j > 0;j--){
                if (value[j] < value[j -1])
                    swap(j, j-1);
                else
                    break;
            }
        }
        return this;
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new InsertSort();
        if (abstractSort.sort().isSort())
            System.out.println(abstractSort.printValue());
    }
}
