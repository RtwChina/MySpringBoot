package com.xiaour.spring.boot.leetcode.simple.characterstr;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/
 * 整数反转
 *
 * @author rtw
 * @since 2024/6/21
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(ReverseInteger.reverseIntV2(-12300));
    }

    /**
     * 通过 / 和 % 获取到最后一个数字和其他数字，然后对最后一个数字一直乘以 10 进行循环拼接
     * 可以通过 / 来消除 0
     * 通过 % 获取末尾数字
     * @param i
     * @return
     */
    public static int reverseIntV2(int i) {
        if (i == 0 || i >= Integer.MAX_VALUE || i <= Integer.MIN_VALUE) {
            return 0;
        }
        // 处理正负数
        int op = i < 0 ? -1 : 1;
        i = Math.abs(i);
        // 将末尾的 0 去掉
        while (i % 10 == 0) {
            i = i / 10;
        }
        // 将末尾的数字移动到前方
        long target = 0L;
        while (i != 0) {
            int lastNumber = i % 10;
            i = i / 10;
            // 最后一位数字前进一位存放到 target中。
            target = target * 10L + lastNumber;
            if (target < Integer.MIN_VALUE || target > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int)target * op;
    }

    /**
     * 利用字符串翻转的方式
     *
     * @param i
     * @return
     */
    public static int reverseInt(int i) {
        if (i == 0 || i >= Integer.MAX_VALUE || i <= Integer.MIN_VALUE) {
            return 0;
        }
        int op = i < 0 ? -1 : 1;
        int abs = Math.abs(i);
        String value = String.valueOf(abs);
        char[] chars = value.toCharArray();
        // 翻转
        reverserChar(chars);
        Long integer = Long.valueOf(String.valueOf(chars));
        if (integer >= Integer.MAX_VALUE) {
            return 0;
        }
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
