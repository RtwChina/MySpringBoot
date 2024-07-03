package com.xiaour.spring.boot.leetcode.simple.characterstr;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
 *
 * @author rtw
 * @since 2024/6/21
 */
public class Reverse {
    public static void main(String[] args) {
        char[] array = {'s', 't', 'a', 'r', 't'};

        Reverse.reverseString(array);
        System.out.println(JSON.toJSONString(array));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;

        }
    }
}
