package com.djcao.sell;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/19
 */
public class MessageTest {
    private static HashMap<Character,String> cache = new HashMap<>();
    private static char[][] chars = {
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'},
        {'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'},
        {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String monthAndDay = sc.nextLine();
        String words = sc.nextLine();
        String[] split = monthAndDay.split(" ");
        if (split.length != 2)
            return;
        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);

        //处理流程
        doWork(month, day, words.toCharArray());
    }

    public static void doWork(int month, int day, char[] chars) {
        month--;day--;
        //根据输入的月份和，日期初始化密码表
        init(month,day);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(getCharLocation(c)).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void init(int month, int day) {
        int monthOffset = month % chars.length;
        int dayOffset = day % chars[0].length;
        chars = sortMonth(chars, monthOffset);
        for (char[] innerChar : chars) {
            sortDay(innerChar, dayOffset);
        }
    }

    public static String getCharLocation(char target) {
        String res = "";
        if (StringUtils.isNotBlank(res = cache.get(target))){
            return res;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                char alpha = chars[i][j];
                if (alpha == target) {
                    res = ++i + "" + ++j;
                    cache.putIfAbsent(target,res);
                    break;
                }
            }
        }
        return res;
    }

    public static char[] sortDay(char[] chars, int offset) {
        char[] arr = chars.clone();
        for (int i = 0; i < chars.length; i++) {
            int target = (chars.length - offset + i) % chars.length;
            //int target = i + offset >= chars.length ? i + offset - chars.length : i + offset;
            chars[i] = arr[target];
        }
        return chars;
    }

    public static char[][] sortMonth(char[][] chars, int offset) {
        char[][] arr = chars.clone();
        for (int i = 0; i < chars.length; i++) {
            int target = (chars.length - offset + i) % chars.length;
            //int target = i + offset >= chars.length ? i + offset - chars.length : i + offset;
            chars[i] = arr[target];
        }
        return chars;
    }
}
