package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.alibaba.fastjson.JSON;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 * @author rtw
 * @since 2024/8/6
 */
public class Flatten {
//    public static void main(String[] args) {
//        TreeNode head = new TreeNode(20);
//        head.left = new TreeNode(10);
//        head.right = new TreeNode(30);
//
//
//        head.left.left = new TreeNode(4);
//        head.right.right = new TreeNode(20);
//        Flatten flatten = new Flatten();
//        TreeNode treeNode = flatten.flatten(head);
//        System.out.println(JSON.toJSONString(treeNode));
//    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.right = new TreeNode(30);


        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(20);
        Flatten flatten = new Flatten();
        flatten.flattenV2(head);
        System.out.println(JSON.toJSONString(flatten));
    }


    /**
     * 利用前序便利
     */
    public TreeNode flatten(TreeNode root) {
        this.traverse(root);
        return resultRootHead;
    }
    public TreeNode resultRootHead = new TreeNode();
    public TreeNode resultRoot = resultRootHead;


    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        resultRoot.right = new TreeNode(root.val);
        resultRoot = resultRoot.right;
        traverse(root.left);
        traverse(root.right);
    }




    /**
     * 通过子问题解决
     * 将左子树迁移到右子树
     */
    public void flattenV2(TreeNode root) {
        if (root == null) {
            return;
        }

        this.traverse(root.left);
        this.traverse(root.right);


        // 后续位置
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        TreeNode theLast = root;
        while (theLast.right != null) {
            theLast = theLast.right;
        }
        theLast.right = right;

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