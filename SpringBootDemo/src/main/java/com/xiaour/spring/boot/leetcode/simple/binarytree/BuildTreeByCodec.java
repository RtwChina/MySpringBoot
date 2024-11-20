package com.xiaour.spring.boot.leetcode.simple.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * @author rtw
 * @since 2024/11/16
 */
public class BuildTreeByCodec {

    public static void main(String[] args) {
        Queue queue =new LinkedList();
        queue.offer(null);
        queue.offer(null);
        System.out.println(queue.poll());
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("null").append(",");
                continue;
            }
            res.append(node.val).append(",");
            // 这是有点小巧思的，默认把left或者 right塞入进去，在拿出来的时候打印 null
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        // 塞入了所有的 root节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
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
