package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnldjj/
 *
 * @author rtw
 * @since 2024/8/20
 */
public class LevelOrderBST {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.right = new TreeNode(30);


        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(20);


        List<List<Integer>> listList = levelOrder(head);
        System.out.println(JSON.toJSONString(listList));
    }


    /**
     * 迭代算法
     * 是否是二叉树不仅仅只需要和父节点判断，因为有可能存在需要和父节点的父节点进行判断。因此我们就引入了上下界的逻辑。
     * 如果上下界都存在，判断节点是否在上下界内。不符合则返回 false,将当前节点的值作为上界，对节点的左子书进行判断。将当前节点的值作为下界，对节点的右子树进行判断
     * <p>
     * 所以说左子树的上界是节点值，下界继承自节点值的下界，右字数有上下界
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> listList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            listList.add(list);
        }
        return listList;
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
