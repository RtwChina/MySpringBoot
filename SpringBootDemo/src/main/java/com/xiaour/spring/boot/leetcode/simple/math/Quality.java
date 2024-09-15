package com.xiaour.spring.boot.leetcode.simple.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author rtw
 * @since 2024/9/1
 */
public class Quality {
    public static void main(String[] args) {
        Quality quality = new Quality();
        System.out.println(quality.countPrimes(30));
    }
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int[] array = new int[n];
        // 假设所有数组都是质素，标志为 1
        Arrays.fill(array, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] == 1) {
                ans++;
                int j = 2;
                while (i * j < n) {
                    array[i*j] = 0;
                    j++;
                }
            }
        }
        return ans;
    }
}
