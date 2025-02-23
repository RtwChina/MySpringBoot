package com.xiaour.spring.boot.leetcode.simple.array;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 * 两数之和
 *
 * @author rtw
 * @since 2024/6/21
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {2, 3, 3, 1, 4};

        int[] intersect = TwoSum.twoSum(array, 6);
        System.out.println(JSON.toJSONString(intersect));
    }


    /**
     * 通过一个 Map来解决
     *
     * @param nums1
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums1, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] index = null;
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(target - nums1[i]) == null) {
                map.put(nums1[i], i);
            } else {
                index = new int[]{i, map.get(target - nums1[i])};
            }
        }
        return index;
    }

    /**
     * 双指针来解决
     *
     * @param nums1
     * @param target
     * @return
     */
    public static int[] twoSumV2(int[] nums1, int target) {
        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            if (left + right == target) {
                return new int[]{left + 1, right + 1};
            } else if (left + right < target) {
                left++;
            } else if (left + right > target) {
                right--;
            }

        }
        return new int[]{-1, -1};

    }


}
