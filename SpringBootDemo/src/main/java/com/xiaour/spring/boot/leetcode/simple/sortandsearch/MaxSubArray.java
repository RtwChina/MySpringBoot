package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

/**
 * @author rtw
 * @since 2024/8/27
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = new int[]{5,4,-1,7,8};
        System.out.println(maxSubArray(a));
    }
    public static int maxSubArray(int[] nums) {
        // 当前连续数组的总和
        int sumV1 = 0;
        // 连续数组的最大值
        int sumV2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur + sumV1 > sumV1) {
                sumV1 = cur + sumV1;
            } else {
                sumV1 = cur;
            }
            if (sumV1 > sumV2) {
                sumV2 = sumV1;
            }
        }
        return Math.max(sumV1,sumV2);
    }


    public static int maxSubArrayV2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
