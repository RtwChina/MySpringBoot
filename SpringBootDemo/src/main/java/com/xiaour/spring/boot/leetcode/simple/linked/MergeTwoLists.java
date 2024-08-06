package com.xiaour.spring.boot.leetcode.simple.linked;

/**
 * @author rtw
 * @since 2024/8/3
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);


        ListNode node3_a = new ListNode(3);
        ListNode node2_a = new ListNode(2, node3_a);
        ListNode node1_a = new ListNode(1, node2_a);



        ListNode listNode = MergeTwoLists.mergeTwoListsV2(node1, node1_a);
        System.out.println(listNode);
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode first = newList;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ListNode next = new ListNode();
                next.val = list2.val;
                newList.next = next;
                newList = next;
                list2 = list2.next;
                continue;
            } else if (list2 == null){
                ListNode next = new ListNode();
                next.val = list1.val;
                newList.next = next;
                newList = next;
                list1 = list1.next;
                continue;
            }

            if (list1.val < list2.val) {
                ListNode next = new ListNode();
                next.val = list1.val;
                newList.next = next;
                newList = next;
                list1 = list1.next;
            } else {
                ListNode next = new ListNode();
                next.val = list2.val;
                newList.next = next;
                newList = next;
                list2 = list2.next;
            }
        }
        return first.next;
    }

    /**
     * 通过对2条链路的处理，获得头部最小的节点。
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode first = newList;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                newList.next = list2;
                newList = newList.next;
                list2 = list2.next;
                continue;
            } else if (list2 == null){
                newList.next = list1;
                newList = newList.next;
                list1 = list1.next;
                continue;
            }

            if (list1.val < list2.val) {
                newList.next = list1;
                newList = newList.next;
                list1 = list1.next;
            } else {
                newList.next = list2;
                newList = newList.next;
                list2 = list2.next;
            }
        }
        return first.next;
    }



    /**
     * 迭代
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoListsV3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoListsV3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsV3(list1, list2.next);
            return list2;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
