package com.djcao.sell.algorithm.review1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 */
public class BucketSort {

    /**
     * 确认桶的个数
     * 根据桶的个数，最大值，最小值，确认映射函数 index = (currentValue - minValue) / bucketSize;
     * 对所有的桶内的元素进行排序（使用插入排序方法）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = new int[2][3];
        for (int i=0;i<2;i++){
            for (int j=0;j<3;j++){
                image[i][j] = 0;
            }
        }

        solution.floodFill(image,0,0,2);
    }

    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int height = image.length;
            int wide = 0;
            for(int i=0;i<height;i++){
                wide = Math.max(image[i].length,wide);
            }
            dfs(image,sr,sc,newColor,image[sr][sc],new boolean[height][wide]);
            return image;
        }

        private void dfs(int[][] image,int sr,int sc,int newColor,int oldColor,boolean[][] mark){
            if(mark[sr][sc]) return;
            mark[sr][sc] = true;
            image[sr][sc] = newColor;
            if(sr - 1 >= 0 && image[sr - 1][sc] == oldColor){
                dfs(image,sr - 1,sc,newColor,oldColor,mark);
            }
            if(sr + 1 < image.length && image[sr + 1][sc] == oldColor){
                dfs(image,sr + 1,sc,newColor,oldColor,mark);
            }
            if(sc - 1 >= 0 && image[sr][sc - 1] == oldColor){
                dfs(image,sr ,sc- 1,newColor,oldColor,mark);
            }
            if(sc + 1 < image[sr].length && image[sr][sc + 1] == oldColor){
                dfs(image,sr ,sc + 1,newColor,oldColor,mark);
            }
        }

        private List<Integer> getSameColorPoint(int[][] image, int sr, int sc, int newColor){
            List<Integer> list = new ArrayList<>();
            return list;
        }
    }


}
