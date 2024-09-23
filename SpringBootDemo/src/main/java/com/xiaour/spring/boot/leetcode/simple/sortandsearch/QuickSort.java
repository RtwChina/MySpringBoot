package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 *
 * @author rtw
 * @since 2024/9/17
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 1, 4, 5};
        QuickSort guiBingSort = new QuickSort();
        guiBingSort.sort(array, 0, array.length - 1);
        System.out.println(JSON.toJSONString(array));

    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = divide(array, left, right); // 获取基准值的索引
            sort(array, left, pivot - 1); // 对基准值左侧的子数组进行排序
            sort(array, pivot + 1, right); // 对基准值右侧的子数组进行排序
        }
    }

    /**
     * 对left～right的数组进行排序，以left的值为基准值，并最终返回基准值的位置
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int divide(int[] array, int left, int right) {
        // 基准值
        int midNum = array[left];
        int low = left +1;
        int hi = right;
        while (low < hi) {
            while (low < hi && array[low] < midNum) {
                low++;
            }
            while (low < hi && array[hi] < midNum) {
                hi--;
            }
            if (low < hi) {
                swap(array, low, hi);
            }
        }
        swap(array, left, hi); // 将基准值放到正确的位置上
        return hi;
    }

    public void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = two;
        array[two] = temp;
    }
}