package com.xiaour.spring.boot.leetcode.simple.array;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Stack;

/**
 * 输入一个数组 nums，请你返回一个等长的结果数组，结果数组中对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
 * 比如说，输入一个数组 nums = [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。因为第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
 *
 * @author rtw
 * @since 2024/10/29
 */
public class CalculateGreaterElement {
    public static void main(String[] args) {
        CalculateGreaterElement element = new CalculateGreaterElement();
        element.calculateGreaterElement(new int[]{2, 4, 1});
    }


    int[] calculateGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> stack = new Stack();

        // 从后往前处理
        for (int i = n - 1; i >= 0; i--) {

            // nums[i]为当前的元素，stack.peek()是 nums[i] 后面的元素，把在后面小于nums[i]的元素抛弃
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            // 上一步已经将小于nums[i]的元素抛弃，那么要么还有剩余的元素就是目标值，要么没有剩余的元素了
            res[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(nums[i]);
        }


        return res;
    }
}
