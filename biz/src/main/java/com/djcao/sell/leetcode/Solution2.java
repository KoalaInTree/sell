package com.djcao.sell.leetcode;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/4/22
 */
class Solution2 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int offset = 0;
        int remain = s.length();
        while(remain >= 0){
            if(remain >= 2*k){
                appendz(chars, offset, k-1, true, res);
                appendz(chars, offset+k, k-1, false, res);
            }
            else if(remain >= k){
                appendz(chars, offset, k-1, true, res);
                appendz(chars, offset+k, remain - k-1, false, res);
                break;
            }else{
                appendz(chars, offset, remain-1, true, res);
                break;
            }
            offset += 2*k;
            remain -= 2*k;
        }
        return res.toString();
    }

    private void appendz(char[] chars,int offset,int count,boolean reverse,StringBuilder res){
        int left = offset;
        int right = offset + count;
        char temp;
        if(reverse){
            for(int i = left; i <= (right + left) / 2;i++){
                temp = chars[i];
                chars[i] = chars[right - i];
                chars[right - i] = temp;
            }
        }
        for(int i = left; i <= right ; i++){
            res.append(chars[i]);
        }
    }

    public static void main(String[] args) {
        /*Solution2 solution2 = new Solution2();
        solution2.reverseStr("abcdef",3);*/
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"one");
        treeMap.put(6,"six");
        treeMap.put(4,"four");
        treeMap.put(5,"five");
        SortedMap<Integer, String> integerStringSortedMap = treeMap.tailMap(3);
        integerStringSortedMap.values();
    }
}
