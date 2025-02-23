package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import java.util.PriorityQueue;

/**
 * @author rtw
 * @since 2024/12/11
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,13,4,5};
        FindKthLargest largest = new FindKthLargest();

        System.out.println(largest.findK(nums, 2));
    }


    public int findK(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i =0;i<nums.length;i++) {
            // 所有的元素塞入一遍
            queue.offer(nums[i]);
            // 当存在有大于 K 个元素在堆中时，都可以poll掉
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
