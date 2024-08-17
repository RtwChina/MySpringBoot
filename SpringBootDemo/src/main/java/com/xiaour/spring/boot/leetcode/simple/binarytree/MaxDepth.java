package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rtw
 * @since 2024/8/6
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);


        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);


        int maxDepth = maxDepthV2(head);
        System.out.println(maxDepth);
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }


    public static int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            // 将某一层的所有节点添加到 quee，然后一个一个拿出来遍历
            while (size != 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            // 遍历一层
            depth++;
        }
        return depth;
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
