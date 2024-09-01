package com.xiaour.spring.boot.leetcode.simple.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author rtw
 * @since 2024/8/29
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        Solution solution = new Solution(array);
        solution.shuffle();

    }
    int[] nums;
    int[] original;


    public Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums,0,nums.length);
        return original;
    }

    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            Random random = new Random();
            int i1 = random.nextInt(list.size());
            nums[i] = list.remove(i1);
        }
        return nums;
    }
}
