package com.djcao.sell.algorithm.review1;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 排序规则：每一趟中根据大小交换相邻元素的位置，把最小的放置最前面
 */
public class BubbleSort extends AbstractSort {

    @Override
    public AbstractSort sort() {

        for (int i=0; i< value.length; i++){
            boolean flag = false;
            for (int j = value.length - 1; j > i; j--){
                if (value[j] < value[j - 1]){
                    swap(j, j-1);
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        return this;
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new BubbleSort();
        if (abstractSort.sort().isSort())
            System.out.println(abstractSort.printValue());
    }
}
