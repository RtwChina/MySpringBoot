package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

/**
 * 打家劫舍
 * https://leetcode.cn/problems/house-robber/solutions/263856/da-jia-jie-she-by-leetcode-solution/
 * @author rtw
 * @since 2024/8/29
 */
public class RaidHomesPlunderHouses {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,3};
        System.out.println(rob(nums));
    }
    /**
     * 通过动态规划的方式获取到最优解
     * 第 N 家最多的钱 就两种算法，N-1的钱或者是 N-2+N的钱。
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        if (size == 1) {
            return dp[0];
        }
        dp[1] = Math.max(dp[0], nums[1]);
        if (size == 2) {
            return dp[1];
        }
        for (int i = 2;i<size;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[size-1];
    }
}
