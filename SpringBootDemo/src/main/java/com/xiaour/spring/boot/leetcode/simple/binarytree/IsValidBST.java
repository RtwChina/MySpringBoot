package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.alibaba.fastjson.JSON;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否是二叉搜索树（BST）
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn08xg/
 * @author rtw
 * @since 2024/8/6
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.right = new TreeNode(30);


        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(20);


        isValidBSTV3(head);
    }


    /**
     * 迭代算法
     * 是否是二叉树不仅仅只需要和父节点判断，因为有可能存在需要和父节点的父节点进行判断。因此我们就引入了上下界的逻辑。
     * 如果上下界都存在，判断节点是否在上下界内。不符合则返回 false,将当前节点的值作为上界，对节点的左子书进行判断。将当前节点的值作为下界，对节点的右子树进行判断
     *
     * 所以说左子树的上界是节点值，下界继承自节点值的下界，右字数有上下界
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
      return   isValidBSTRecursion(root, null, null);
    }


    /**
     * 迭代算法转为递归算法
     * 是否是二叉树不仅仅只需要和父节点判断，因为有可能存在需要和父节点的父节点进行判断。因此我们就引入了上下界的逻辑。
     * 如果上下界都存在，判断节点是否在上下界内。不符合则返回 false,将当前节点的值作为上界，对节点的左子书进行判断。将当前节点的值作为下界，对节点的右子树进行判断
     *
     * 所以说左子树的上界是节点值，下界继承自节点值的下界，右字数有上下界
     * @param root
     * @return
     */
    public static boolean isValidBSTV2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> low = new LinkedList<>();
        Queue<Integer> up = new LinkedList<>();

        queue.offer(root);
        low.offer(null);
        up.offer(null);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer lowNum = low.poll();
            Integer upNum = up.poll();

            if (lowNum != null && poll.val <= lowNum) {
                return false;
            }
            if (upNum != null && poll.val >= upNum) {
                return false;
            }

            queue.offer(root.left);
            low.offer(lowNum);
            up.offer(root.val);


            queue.offer(root.right);
            low.offer(root.val);
            up.offer(upNum);
        }
        return true;
    }

    static Queue<Integer> queue = new LinkedList<>();


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static void isValidBSTV3(TreeNode root) {
        recursionV3(root);
        System.out.println(JSON.toJSONString(queue));
    }

    private static void recursionV3(TreeNode root) {
        if (root == null) {
            return;
        }
        recursionV3(root.left);
        queue.offer(root.val);
        recursionV3(root.right);
    }


    public static boolean isValidBSTRecursion(TreeNode root, Integer low, Integer up) {
        if (root == null) {
            return true;
        }
        if (low != null && root.val <= low) {
            return false;
        }
        if (up != null && root.val >= up) {
            return false;
        }
        // 递归左子树，下界继承自节点，上界为节点的值
        boolean validBSTRecursionLeft = isValidBSTRecursion(root.left, low, root.val);
        // 递归右子树，上界继承自节点，下界为节点的值
        boolean validBSTRecursionRight = isValidBSTRecursion(root.right, root.val, up);
        return validBSTRecursionLeft && validBSTRecursionRight;
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
