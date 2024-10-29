package com.xiaour.spring.boot.leetcode.simple.linked;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 *
 * @author rtw
 * @since 2024/10/13
 */
public class GetIntersectionNode {

    public static void main(String[] args) {


        ListNode node2_4 = new ListNode(3);
        ListNode node2_5 = new ListNode(2, node2_4);

        GetIntersectionNode mergeKLists = new GetIntersectionNode();
        ListNode fromEnd = mergeKLists.getIntersectionNode(node2_4, node2_5);
        System.out.println(fromEnd);


    }


    /**
     * 多个链表
     * 精妙
     *
     * @param lists
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA_node = headA;
        ListNode headB_node = headB;
        // 为空？
        int i = 1;
        int j = 1;
        while (headA_node != headB_node) {
            if (headA_node == null && i > 0) {
                headA_node = headB;
                i--;
                break;

            }
            if (headB_node == null && j > 0) {
                headB_node = headA;
                j--;
                break;

            }
            headA_node = headA_node.next;
            headB_node = headB_node.next;
        }
        return headA_node;
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
