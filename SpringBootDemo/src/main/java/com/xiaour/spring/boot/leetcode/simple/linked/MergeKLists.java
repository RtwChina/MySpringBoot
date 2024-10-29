package com.xiaour.spring.boot.leetcode.simple.linked;

import java.util.PriorityQueue;

/**
 * 合并多个链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * @author rtw
 * @since 2024/10/13
 */
public class MergeKLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node1_2 = new ListNode(2, node1);


        ListNode node2_1 = new ListNode(3);
        ListNode node2_2 = new ListNode(3, node2_1);
        ListNode node2_3 = new ListNode(2, node2_2);

        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] lists = new ListNode[]{node1_2, node2_3};
        ListNode listNode = mergeKLists.mergeKLists(lists);
        System.out.println(listNode);


    }


    /**
     * 多个链表
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode one = new ListNode();
        ListNode first = one;

        // 优先级队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, (a, b) -> {
            return a.val - b.val;
        });

        // 头节点塞入优先级队列
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                priorityQueue.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        // 从优先级队列中拿出最小的塞到合并队列中，然后哪个队列拿出来的，就使用 next 把下一个节点放到优先级队列中。
        // （亮点就是拿出来的节点可以直接获取其下一个节点，如果是数组的话就做不到了）
        while (priorityQueue.size() != 0) {
            ListNode minInQueue = priorityQueue.poll();
            if (minInQueue.next != null) {
                priorityQueue.offer(minInQueue.next);
            }
            first.next = minInQueue;
            first = first.next;
        }

        return one.next;
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
