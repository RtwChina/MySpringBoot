package com.xiaour.spring.boot.leetcode.simple.linked;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
 *
 * @author rtw
 * @since 2024/7/28
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = ReverseList.reverseListV2(node1);
        System.out.println(JSON.toJSONString(listNode));
    }

    /**
     * 堆栈的方式
     */
    public static ListNode reverseList(ListNode head) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode put = head;
        while(put != null) {
            linkedList.push(put);
            put = put.next;
        };
        if (linkedList.size() == 0) {
            return head;
        }
        ListNode topAfter = linkedList.peek();
        ListNode lastAfter = topAfter;

       while (linkedList.size() >= 2) {
           ListNode top = linkedList.pop();
           lastAfter = linkedList.peek();
           top.next = lastAfter;
       }
        lastAfter.next = null;
       return topAfter;
    }



    /**
     * 明确三个节点， 当前，从前和以后，  curr，pre，next
     */
    public static ListNode reverseListV2(ListNode head) {
        // 第一个的 pre 就是 null，神来之笔
        ListNode pre = null;
        ListNode next = null;
        ListNode curr = head;
        while(curr != null) {
           ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        };
        return pre;
    }




    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
