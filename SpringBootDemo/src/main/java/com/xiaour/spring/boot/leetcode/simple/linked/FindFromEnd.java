package com.xiaour.spring.boot.leetcode.simple.linked;

import java.util.PriorityQueue;

/**
 * 找到倒数第 N 个节点
 * @author rtw
 * @since 2024/10/13
 */
public class FindFromEnd {

    public static void main(String[] args) {


        ListNode node2_1 = new ListNode(3);
        ListNode node2_2 = new ListNode(4, node2_1);
        ListNode node2_3 = new ListNode(3, node2_2);
        ListNode node2_4 = new ListNode(2, node2_3);
        ListNode node2_5 = new ListNode(1, node2_4);

        FindFromEnd mergeKLists = new FindFromEnd();
        ListNode fromEnd = mergeKLists.findFromEnd(node2_5, 2);
        System.out.println(fromEnd);


    }


    /**
     * 精妙
     * @param lists
     * @return
     */
    public static ListNode findFromEnd(ListNode list, int k) {
        ListNode fisrtHead = list;
        int steep = k;
        // 首先，先将fisrtHead移动 K 步。
        while (fisrtHead !=null && steep != 0) {
            fisrtHead = fisrtHead.next;
            steep--;
        }

        // 然后，创建第二个 head指 向最左侧
        ListNode secondHead = list;

        // 最后，将fisrtHead移动到最末端后，第二个 Head指向的就是倒数的那个节点了
        while (fisrtHead != null) {
            fisrtHead = fisrtHead.next;
            secondHead = secondHead.next;
        }
        return secondHead;
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
