package com.godme.leetcode.q155;

import java.util.Deque;
import java.util.LinkedList;

// 新增删除依据栈操作，最小值并非全局最小，而是阶段最小
// 可以通过数据绑定抵消查找操作
class MinStack {
    class Entry{
        int value;
        int min;

        Entry(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
    Deque<Entry> stack;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(new Entry(val,Math.min(val, getMin())));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        Entry entry = stack.peek();
        if(entry == null){
            return Integer.MAX_VALUE;
        }
        return entry.min;
    }
}
