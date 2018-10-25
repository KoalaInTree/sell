package com.djcao.sell.algorithm;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/12
 */
public class BFSDFS {

    private void generateNumber(int n) {
        for (int i = 0; i < 9; i++) {

        }
    }

    private List getNext(int number) {
        if (number == 0) {
            return Arrays.asList(0, 7, 8, 9);
        } else {
            List<Integer> result = Arrays.asList(number + 1, number - 1, number + 3, number - 3);
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) <= 0 || result.get(i) >= 10) {
                    result.remove(i);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
