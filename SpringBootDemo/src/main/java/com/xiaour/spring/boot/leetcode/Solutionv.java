package com.xiaour.spring.boot.leetcode;

import java.util.*;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x21ib6/
 * 只出现一次的数字
 * @author rtw
 * @since 2024/6/21
 */
public class Solutionv {
    public static void main(String[] args) {
        int[] array = {2,2,3,3,4};
        int intt = Solutionv.singleNumberV3(array);
        System.out.println(intt);
    }


    public static int singleNumberV3(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length-1; i++) {
            m = m ^ nums[i];
        }
        return m;
    }


    public static int singleNumberV2(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 2);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;

    }

}
