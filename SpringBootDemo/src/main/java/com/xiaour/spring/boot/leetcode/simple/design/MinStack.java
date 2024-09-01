package com.xiaour.spring.boot.leetcode.simple.design;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rtw
 * @since 2024/8/29
 */
public class MinStack {
    public static void main(String[] args) {
//        ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        Deque<Integer> mixValueQue = new LinkedList<>();
        mixValueQue.peekLast();

//        MinStack minStack = new MinStack();
//        minStack.push(2147483646);
//        minStack.push(2147483646);
//        minStack.push(2147483647);
//        System.out.println(minStack.top());
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        minStack.push(2147483647);
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
//        minStack.push(-2147483648);

        MinStack minStack = new MinStack();
        minStack.push(85);
        minStack.push(-99);
        minStack.push(67);
        System.out.println(minStack.getMin());

    }
    public TradeNode root;
    public Deque<Integer> mixValueQue = new LinkedList<>();


    public void push(int val) {
        if (mixValueQue.size() == 0) {
            mixValueQue.offer(val);
        } else if (mixValueQue.peek() != null && mixValueQue.peekLast() >= val) {
            // 如果当前的堆栈最上层的数值比将要塞入的数据大
            mixValueQue.offer(val);
        }
        TradeNode node = new TradeNode(val);
        if (root == null) {
            root = node;
            return;
        }
        node.next = root;
        root = node;
    }

    public void pop() {
        if (root == null) {
            return;
        }
        if (root.value.equals( mixValueQue.peekLast())) {
            mixValueQue.pollLast();
        }
        root = root.next;
    }

    public int top() {
        if (root == null) {
            return 0;
        }
        return root.value;
    }

    public int getMin() {
        if (mixValueQue == null || mixValueQue.size() == 0) {
            return 0;
        } else {
            return mixValueQue.peekLast();
        }
    }


    public class TradeNode {
        private Integer value;
        private TradeNode next;

        TradeNode(Integer x) {
            value = x;
        }
    }
}
