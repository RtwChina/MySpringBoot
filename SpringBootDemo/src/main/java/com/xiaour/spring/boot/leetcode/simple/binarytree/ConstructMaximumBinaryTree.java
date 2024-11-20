package com.xiaour.spring.boot.leetcode.simple.binarytree;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/description/
 *
 * @author rtw
 * @since 2024/11/14
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,6,0,5};
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode treeNode = constructMaximumBinaryTree.constructMaximumBinaryTree(a);
        System.out.println("SUCCESS");

    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return constructMaximumBinaryTreeByIndex(nums, 0, nums.length - 1);
    }

    /**
     * [start, end]
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public TreeNode constructMaximumBinaryTreeByIndex(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (end < 0 || start >= nums.length) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        // 找到 num[] 中的最大值
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTreeByIndex(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTreeByIndex(nums, maxIndex + 1, end);
        return root;
    }


    public class TreeNode {
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
