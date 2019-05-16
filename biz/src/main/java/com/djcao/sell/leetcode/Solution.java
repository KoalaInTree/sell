package com.djcao.sell.leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/19
 */
public class Solution {

    /**
     * 26. 删除排序数组中的重复项
     * @return
     */
    //@Test
    public int removeDuplicates() {
        int[] nums = {1,1,2};
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int cur = 0, last = 0;
        int offset = 1;
        while (last < nums.length && cur < nums.length - 1) {
            if (nums[cur] >= nums[cur + 1]) {
                while (last < nums.length) {
                    offset = 0;
                    if (nums[last] <= nums[cur]) {
                        last++;
                    } else {
                        nums[cur + 1] = nums[last];
                        break;
                    }
                }
            }
            cur++;
        }
        return cur + offset;
    }

    @Test
    public void flipAndInvertImage() {
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        int m = A.length;
        int n  = A[0].length;
        for(int i = 0;i < m ;i++){
            for(int j=0;j < n/2;j++){
                swapAndReserve(A,i,j,n-j-1);
            }
            if(n % 2 == 1){
                A[i][n/2] = 1 -  A[i][n/2];
            }
        }
        //return A;
    }

    private void swapAndReserve(int[][] A,int i,int source,int target){
        int temp = A[i][source];
        A[i][source] = 1 - A[i][target];
        A[i][target] = 1 - temp;
        String s;
    }

    @Test
    public void testA(){
        String s = "123.123";
        System.out.println(Arrays.toString(s.split(".")));
    }

    @Test
    public void firstBadVersion() {
        int n = 5;
        if(n == 1)
            return;
        recuse(1,n);
    }

    private int recuse(int left,int right){
        if(left >= right)
            return -1;
        int mid = (left + right) / 2;
        if(isBadVersion(mid)){
            if(!isBadVersion(mid - 1)){
                return mid;
            }else{
                return recuse(left, mid);
            }
        }else{
            return recuse(mid, right);
        }
    }

    private boolean isBadVersion(int n) {
        return n == 4;
    }
    @Test
    public void constructMaximumBinaryTree() {
        int[] nums = {3,2,1,6,0,5};
        TreeNode tranverse = tranverse(nums, 0, nums.length);

    }

    public TreeNode tranverse(int[] nums, int first, int end){
        int max=Integer.MIN_VALUE;
        int max_index = -1;
        if(first >= end)
            return null;
        for(int i= first; i < end; i++){
            if(max < nums[i]){
                max = nums[i];
                max_index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = tranverse(nums,first,max_index);
        root.right = tranverse(nums,max_index + 1, end);
        return root;
    }

}
