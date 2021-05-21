package com.godme.leetcode.q225;

import java.util.LinkedList;
import java.util.Queue;

// 思路: 头插法，将每次压入元素置顶
// 时间: O(n)
// 空间: O(n)
class MyStack {
    Queue<Integer> main = new LinkedList<>();
    Queue<Integer> help = new LinkedList<>();
    public MyStack() {}
    public void push(int x) {
        help.offer(x);
        while (!main.isEmpty()){
            help.add(main.poll());
        }
        Queue<Integer> temp = main;
        main = help;
        help = temp;
    }
    public int pop() {
        return main.remove();
    }
    public int top() {
        return main.peek();
    }
    public boolean empty() {
        return main.isEmpty();
    }
}