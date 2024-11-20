package com.xiaour.spring.boot.leetcode.simple.linked;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * 滑动窗口最大值 239
 * <p>
 * 需要一个单调站来维护当前的最大值，每次 push的时候，把之前比他小的数据都删除后再塞入。这样的话第一个点就永远都是最大值。
 *
 * @author rtw
 * @since 2024/11/2
 */
public class SlideWindowMax {
    public static void main(String[] args) {
        SlideWindowMax slideWindowMax = new SlideWindowMax();
        int[] ints = slideWindowMax.maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        int[] res = new int[nums.length-k+1];
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                // 初始化时，先塞入 K 个值，初始化滑动窗口
                queue.push(nums[i]);
            } else {
                // 将滑动窗口的最大值保存下来
                res[resIndex] = queue.max();
                resIndex++;
                // 塞入当前值
                queue.push(nums[i]);
                // 删除上一次需要被淘汰的滑动窗口最左侧
                queue.pop(nums[i-k]);
            }
        }
        // 最后一个数值，需要特殊处理
        res[resIndex] = queue.max();
        return res;
    }

    public class MonotonicQueue {

        LinkedList<Integer> linkedList = new LinkedList();

        /**
         * 塞入一个值，然后便利前面的值进行
         *
         * @param v
         */
        void push(int v) {
            while (!linkedList.isEmpty() && linkedList.getLast() <= v) {
                linkedList.removeLast();
            }
            linkedList.addLast(v);
        }

        /**
         * 删除某一个元素，其实回想一下，滑动窗口需要删除该元素时，该元素一定是在窗口最左侧，
         * 如果还在单调栈里面，只有可能是当前单调栈的最大值。否则已经在上一步中被移除了
         */
        void pop(int v) {
            if (v == linkedList.getFirst()) {
                linkedList.removeFirst();
            }
        }

        /**
         * 返回站内最大值
         */
        int max() {
            return linkedList.getFirst();
        }
    }

}
