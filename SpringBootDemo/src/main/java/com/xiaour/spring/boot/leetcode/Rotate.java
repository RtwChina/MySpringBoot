package com.xiaour.spring.boot.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
 * 旋转数组
 * 通过3次翻转实现整体的处理
 * @author rtw
 * @since 2024/6/16
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Rotate.rotateV2(nums,2);
        System.out.println(JSON.toJSONString(nums));
    }


    private static void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int after = (i + k) % nums.length;
            nums2[after] = nums[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
    }

    private static void rotateV2(int[] nums, int k) {
        // 翻转  7 6 5 4 3 2 1
        reverse(nums, 0, nums.length - 1);
        // 翻转  5 6 7
        reverse(nums, 0, k % nums.length - 1);
        // 翻转  1 2 3 4
        reverse(nums, k % nums.length, nums.length - 1);

    }

    // 翻转数组  1234 -> 4321
    private static void reverse(int[] nums, int start, int end) {
        for (int i = start; i < ((end - start + 1) / 2) + start; i++) {
            int temp = nums[i];
            nums[i] = nums[end + start - i];
            nums[end + start - i] = temp;
        }
    }

    // 翻转数组  1234 -> 4321
    private static void reverseV2(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
