package com.xiaour.spring.boot.leetcode.simple.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x248f5/
 * 存在重复元素
 * 先排序后比啊你
 * @author rtw
 * @since 2024/6/21
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,9};
        boolean duplicate = Solution.containsDuplicate(array);
        System.out.println(duplicate);
    }



    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateV2(int[] nums) {
        Set set =  new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

        }
        return false;
    }
}
