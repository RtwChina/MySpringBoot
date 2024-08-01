package com.xiaour.spring.boot.leetcode.simple.linked;

/**
 * 删除链表中的节点
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnarn7/
 *
 * @author rtw
 * @since 2024/7/28
 */
public class DeleteNode {


    public static void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
