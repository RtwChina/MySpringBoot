package com.xiaour.spring.boot.leetcode.simple.array;

import com.alibaba.fastjson.JSON;

/**
 * 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 * 双指针，一个指针作为非零的队列末尾指针，一个指针作为已处理的队列末尾指针
 * 然后通过已处理的队列末尾指针自增，知道处理完所有长度
 *
 * @author rtw
 * @since 2024/6/23
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] array = {2, 0, 1, 0, 3};
        int[] ints = MoveZero.moveZeroesV2(array);
        System.out.println(JSON.toJSONString(ints));
    }

    public static int[] moveZeroes(int[] digits) {
        // 我们目标是把非 0 的数字移动到前端

        // 非零的队列末尾指针
        int i = 0;
        // 已处理的队列末尾指针
        int j = 0;
        do {
            if (digits[j] != 0) {
                swap(digits, i, j);
                i++;
            }
            j++;
        } while (j < digits.length);
        return digits;
    }

    public static int[] moveZeroesV2(int[] nums) {
        int indexNow = 0;
        int indexNum = 0;
        int m = nums.length;

        while(indexNum<m){
            if(nums[indexNum] != 0) {
                nums[indexNow++] = nums[indexNum];
            }
            ++indexNum;
        }

        for(int i = indexNow; i < m; i++){
            nums[i] = 0;
        }
        return nums;
    }

    public static void swap(int[] digits, int i, int j) {
        int mid = digits[i];
        digits[i] = digits[j];
        digits[j] = mid;
    }

}
