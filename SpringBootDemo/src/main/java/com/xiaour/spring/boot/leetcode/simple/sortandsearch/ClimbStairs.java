package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

/**
 * 爬楼梯
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn854d/
 * @author rtw
 * @since 2024/8/26
 */
public class ClimbStairs {


    public static void main(String[] args) {
        System.out.println(staircaseV2(3));
    }

    /**
     * 递归, 时间复杂度太高
     */
    public static int staircase(int n) {
        if (n <= 2) {
            return n;
        }
        return staircase(n - 1) + staircase(n - 2);
    }


    /**
     * 递归, 时间复杂度太高
     */
    public static int staircaseV2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] array = new int[n+1];
        for (int i = 1; i < n; i++) {
            if (i <= 2) {
                array[i] = i;
                continue;
            }
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1] + array[n-2];
    }

}
