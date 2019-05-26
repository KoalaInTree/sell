package com.djcao.sell.algorithm.learn;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/17
 */
public class SquareArray {
        @Test
        public void sortedSquares() {
            int[] A = {-4,-1,0,3,10};
            int i=0,j,length = A.length;
            int[] result = new int[length];
            while(i < A.length && A[i] < 0)
                i++;
            j = i - 1;
            int index;
            for(index = 0;i < length && j >= 0; index++){
                if(square(A[i]) > square(A[j])){
                    result[index] = square(A[j]);
                    j--;
                }else{
                    result[index] = square(A[i]);
                    i++;
                }
            }
            if(index < length){
                if(j > 0 ){
                    while(j >= 0){
                        result[index++] = square(A[j--]);
                    }
                }else if(i < length){
                    while(i < length){
                        result[index++] = square(A[i++]);
                    }
                }
            }
            System.out.println(result);

        }

        private int square(int num){
            return num * num;
        }
}
