package com.xiaour.spring.boot.leetcode.simple.graph;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 * 遍历所有的路径
 * @author rtw
 * @since 2024/12/14
 */
public class TraverseGraphTest {

    public static void main(String[] args) {
        int[] graph =
                {-1,5,-3,4,-2}
        ;
        TraverseGraphTest graph1 = new TraverseGraphTest();
        System.out.println( graph1.maxSubArray(graph));
    }
    public int maxSubArray(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            // 扩大窗口并更新窗口内的元素和
            windowSum += nums[right];
            right++;
            // 更新答案
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // 判断窗口是否要收缩
            while(windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
                windowSum -=  nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
