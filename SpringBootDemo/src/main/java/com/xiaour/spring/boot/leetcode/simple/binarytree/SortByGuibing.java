package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序
 *
 * @author rtw
 * @since 2024/12/8
 */
public class SortByGuibing {
    public static void main(String[] args) {
        int[] a = new int[]{1,34,5,21,3,4,5,7,8};
        SortByGuibing sb = new SortByGuibing();
        try {
            sb.traverse(a, 0 , a.length-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(a));

    }



    /**
     * 归并排序
     */
    public void traverse(int[] array, int start, int end) {
        // 终止条件
        if (start >= end) {
            return;
        }
        // 识别中间点
        int mid = start + (end - start) / 2;
        // 递归处理
        this.traverse(array, start, mid);
        this.traverse(array, mid + 1, end);
        // 合并两个列表
        merge(array, start, mid, end);
    }


    public int[] merge(int[] array, int leftStart, int mid, int rightEnd) {
        int[] temp = new int[rightEnd - leftStart + 1];
        int i = leftStart;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= rightEnd) {
            if (array[i] < array[j]) {
                temp[tempIndex++] = array[i++];
            } else {
                temp[tempIndex++] = array[j++];
            }
        }
        // 判断还剩余哪个数据
        if (i >= mid) {
            // right还有剩余
            while (j <= rightEnd) {
                temp[tempIndex++] = array[j++];
            }
        }


        if (j >= rightEnd) {
            // right还有剩余
            while (i <= mid) {
                temp[tempIndex++] = array[i++];
            }
        }
        // 拷贝
        int index = leftStart;
        for (int i1 = 0;i1<rightEnd - leftStart + 1;i1++) {
            array[index++] = temp[i1];
        }
        return array;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
