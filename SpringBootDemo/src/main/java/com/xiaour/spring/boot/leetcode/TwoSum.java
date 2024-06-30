package com.xiaour.spring.boot.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
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


    public static int[] twoSum(int[] nums1, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] index = null;
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(target - nums1[i]) == null) {
                map.put(nums1[i], i);
            } else {
                index = new int[]{i,map.get(target - nums1[i])};
            }
        }
        return index;
    }

}
