package com.xiaour.spring.boot.leetcode.simple.linked;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * 是否是回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author rtw
 * @since 2024/7/28
 */
public class IsPalindromeList {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = IsPalindromeList.isPalindrome(node1);
        System.out.println(JSON.toJSONString(listNode));
    }

    /**
     * 先进行调转
     * 然后一个一个比较就完事了
     */
    public static ListNode isPalindrome(ListNode head) {
       // todo
        return null;
    }


    /**
     * 调转一下
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
