package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

/**
 * @author rtw
 * @since 2024/8/6
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left =  new TreeNode(2);
        head.right =  new TreeNode(3);


        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);


        int maxDepth = maxDepth(head);
        System.out.println(maxDepth);
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth =  maxDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;

    }



    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
