package com.xiaour.spring.boot.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 两个数组的交集 II
 *
 * @author rtw
 * @since 2024/6/21
 */
public class Intersect {
    public static void main(String[] args) {
        int[] array = {2, 2, 3, 3, 4};
        int[] array2 = {2, 2, 3, 3, 4};

        int[] intersect = Intersect.intersect(array, array2);
        System.out.println(JSON.toJSONString(intersect));
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            value = value == null ? 0 : value;
            map.put(nums1[i], ++value);

        }
        for (int j = 0; j < nums2.length; j++) {
            // 把 Map的 Key作为次数
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) >= 0) {
                list.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }

        int[] returnInt = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            returnInt[i] = list.get(i);
        }
        return returnInt;
    }

}
