package com.xiaour.spring.boot.leetcode.simple.linked;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
 *
 * @author rtw
 * @since 2024/7/28
 */
public class RemoveNthFromEndNode {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = RemoveNthFromEndNode.removeNthFromEndV3(node1, 2);
        System.out.println(listNode);
    }

    /**
     * 先遍历获得链表长度
     * 然后找到倒数第 N 位进行删除
     * @param node
     * @param n
     */
    public static ListNode removeNthFromEnd(ListNode node, int n) {
        int size = 1;
        ListNode first = node;

        ListNode findSize = node;
        while (findSize.next != null) {
            size++;
            findSize = findSize.next;
        }
        // 删除第一个的话进行处理
        if (size - n == 0) {
            return node.next;
        }
        // 循环
        int num = 1;
        ListNode pre = node;
        do {
            if (num == size - n) {
                pre = node;
                break;
            }
            num ++;
            node = node.next;
        } while(true);
        pre.next = pre.next.next;
        return first;
    }


    /**
     * 堆栈的方式
     * @param node
     * @param n
     */
    public static ListNode removeNthFromEndV2(ListNode node, int n) {
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        ListNode first = node;
        do {
            list.push(node);
            node = node.next;
        } while (node != null);

        while (n > 0) {
            n--;
            list.pop();
        }


        if (list.size() == 0 && first.next != null) {
//            first.next = first.next.next;
            return first.next;
        }

        if (list.size() == 0 && first.next == null) {
            return null;
        }

        ListNode pop = list.peek();
        pop.next = pop.next.next;
        return list.get(0);
    }


    /**
     * 先增加一个虚拟的 node 作为头节点（这是点睛之笔，可以自然而然处理删除第一个节点的问题）
     * 然后pop出 n个节点。
     * 剩下栈里面的拿一个就是要删除的的节点的 pre节点。
     * @param node
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndV3(ListNode node, int n) {
        ListNode dummy = new ListNode(0, node);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
