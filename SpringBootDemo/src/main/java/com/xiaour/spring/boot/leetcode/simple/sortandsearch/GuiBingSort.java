package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序
 *
 * @author rtw
 * @since 2024/9/17
 */
public class GuiBingSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 1, 4, 5};
//        GuiBingSort guiBingSort = new GuiBingSort();
//        guiBingSort.merge(array, 0, 2, 1);
//        System.out.println(args);
        GuiBingSort guiBingSort = new GuiBingSort();
        guiBingSort.sort(array, 0, array.length - 1);
        System.out.println(JSON.toJSONString(array));

    }

    public void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        this.sort(array, lo, mid);
        this.sort(array, mid + 1, hi);
        this.merge(array, lo, hi, mid);
    }

    public void merge(int[] array, int lo, int hi, int mid) {
        int[] temp = new int[hi - lo + 1];
        int left = lo;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= hi) {
            if (array[left] < array[right]) {
                temp[index] = array[left];
                index++;
                left++;
            } else {
                temp[index] = array[right];
                index++;
                right++;
            }
        }
        if (left <= mid) {
            for (int i = left; i <= mid; i++) {
                temp[index] = array[i];
                index++;
            }
        }
        if (right <= hi) {
            for (int i = right; i <= hi; i++) {
                temp[index] = array[i];
                index++;
            }
        }

        // 拷贝
        int initIndex = 0;
        for (int i = lo; i <= hi; i++) {
            array[i] = temp[initIndex];
            initIndex++;
        }

    }
}