package com.xiaour.spring.boot.leetcode.simple.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将有序数组转化为二叉树
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xninbt/
 *
 * @author rtw
 * @since 2024/8/6
 */
public class ArrayToTree {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};

        TreeNode treeNode = ArrayToTree.sortedArrayToBST(array, 0, 2);
        System.out.println("GOOD");
    }


    /**
     *
     */
    public static TreeNode sortedArrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode();
        treeNode.val = array[mid];
        treeNode.left = ArrayToTree.sortedArrayToBST(array, start, mid - 1);
        treeNode.right = ArrayToTree.sortedArrayToBST(array, mid + 1, end);
        return treeNode;
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