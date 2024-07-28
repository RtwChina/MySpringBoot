package com.xiaour.spring.boot.leetcode.simple.characterstr;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;

/**
 * 外观数列
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnpvdm/
 * 1. 迭代的思想
 * 2. 遍历每一个数字拼接外观数列
 * @author rtw
 * @since 2024/7/27
 */
public class CountAndSay {
    public static void main(String[] args) {

        String s = CountAndSay.countAndSay(4);
        System.out.println(s);
    }


    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 上一次生成的 SB
        String sb = CountAndSay.countAndSay(n -1);
        // 对 sb进行处理

        char[] chars = sb.toCharArray();
        char first = chars[0];
        int cont = 1;
        String all = "";
        for (int i = 0; i < chars.length; i++) {
            // 遍历
            if (first == chars[i] && i!=0) {
                cont++;
            } else if (first != chars[i]){
                all = all + cont + first;
                first = chars[i];
                cont = 1;
            }
            if (i == chars.length-1) {
                all = all + cont + first;
            }
        }
        return all;

    }



    public static String countAndSayV2(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        char first = chars[0];
        int cont = 1;
        String all = "";
        for (int i = 0; i < chars.length; i++) {
            // 遍历
            if (first == chars[i] && i!=0) {
                cont++;
            } else if (first != chars[i]){
                all = all + cont + first;
                first = chars[i];
                cont = 1;
            }
            if (i == chars.length-1) {
                all = all + cont + first;
            }
        }
        return all;
    }
}
