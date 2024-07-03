package com.xiaour.spring.boot.leetcode.simple.characterstr;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/
 * 整数反转
 * @author rtw
 * @since 2024/6/21
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(ReverseInteger.reverseInt(1534236469));
    }

    public static int reverseInt(int i) {
        if (i == 0 || i == Integer.MAX_VALUE) {
            return i;
        }
        int op = i < 0 ? -1 : 1;
        int abs = Math.abs(i);
        String value = String.valueOf(abs);
        char[] chars = value.toCharArray();
        // 翻转
        reverserChar(chars);
        Long integer = Long.valueOf(String.valueOf(chars));
        return integer.intValue() * op;
    }


    private static void reverserChar(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
