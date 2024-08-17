package com.xiaour.spring.boot.leetcode.simple.binarytree;

/**
 * 对称二叉树
 *
 * @author rtw
 * @since 2024/8/14
 */
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return this.isSymmetricHelper(left.left, right.right) && this.isSymmetricHelper(left.right, right.left);

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


    }

}
