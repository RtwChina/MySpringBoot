package com.xiaour.spring.boot.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author rtw
 * @since 2024/6/23
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] array = {1,2,3,4,9};
        int[] array = {1,2,9,9,9};
        int[] ints = PlusOne.plusOne(array);
        System.out.println(JSON.toJSONString(ints));
    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        // 末尾是 9的,这选择一个不是 9 的自增，后续的就修改为 0
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // 全是 9，这增加一个呗
        int[] newint = new int[digits.length +1];
        newint[0] =1;
        for (int i = 1; i < newint.length; i++) {
            newint[i] = 0;
        }
        return newint;

    }
}
