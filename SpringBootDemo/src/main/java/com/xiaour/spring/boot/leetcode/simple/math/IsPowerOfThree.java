package com.xiaour.spring.boot.leetcode.simple.math;

/**
 * @author rtw
 * @since 2024/9/1
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
//        System.out.println(5/3);
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 0) {
            return false;
        }
        for (; ; ) {
            if (n % 3 != 0  || n == 0) {
                break;
            }
            n = n / 3;
        }
        return n == 1;
    }


    public static boolean isPowerOfThreeV2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
