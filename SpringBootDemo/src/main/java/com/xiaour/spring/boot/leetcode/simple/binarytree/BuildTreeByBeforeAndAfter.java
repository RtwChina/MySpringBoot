package com.xiaour.spring.boot.leetcode.simple.binarytree;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.leetcode.simple.design.MinStack;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * @author rtw
 * @since 2024/11/16
 */
public class BuildTreeByBeforeAndAfter {

    public static void main(String[] args) {

        Queue queue =new LinkedList();
        queue.offer(null);
        queue.offer(null);
        System.out.println(queue.poll());







//
//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] inorder = new int[]{9, 3, 15, 20, 7};
//        BuildTreeByBeforeAndAfter andAfter = new BuildTreeByBeforeAndAfter();
//        TreeNode treeNode = andAfter.buildTree(preorder, inorder);
//        System.out.println(JSON.toJSONString(treeNode));

    }

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode treeNode = this.buildTreeByRoot(0, 0, preorder.length - 1, inorder.length - 1);
        return treeNode;
    }


    /**
     * 递归生产子树
     * [] 前后闭区间
     *
     * @return
     */
    public TreeNode buildTreeByRoot(int leftPreOrder, int leftInOrder,
                                    int rightPreOrder, int rightInOrder) {
        if (leftPreOrder > rightPreOrder || leftInOrder > rightInOrder) {
            return null;
        }

        // 找出 root
        TreeNode root = new TreeNode(preorder[leftPreOrder]);
        // 再去 inorder中找到 root左侧和右侧，左侧为左子树，右侧为右子树
        int rootIndexInOrder = 0;
        for (int i = leftInOrder; i <= rightInOrder; i++) {
            if (inorder[i] == preorder[leftPreOrder]) {
                rootIndexInOrder = i;
                break;
            }
        }
        // 左子树
        int nextLeftInOrder = leftInOrder;
        int nextRightInOrder = rootIndexInOrder - 1;
        int nextleftPreOrder = leftPreOrder + 1;
        int nextrightPreOrder = leftPreOrder + (rootIndexInOrder - leftInOrder);

        root.left = buildTreeByRoot(nextleftPreOrder, nextLeftInOrder, nextrightPreOrder, nextRightInOrder);


        // 右子树
        int nextRightLeftInOrder = rootIndexInOrder + 1;
        int nextRightRightInOrder = rightInOrder;

        int nextRightLeftPreOrder = nextrightPreOrder + 1;
        int nextRightRightPreOrder = rightPreOrder;

        root.right = buildTreeByRoot(nextRightLeftPreOrder, nextRightLeftInOrder, nextRightRightPreOrder, nextRightRightInOrder);

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
