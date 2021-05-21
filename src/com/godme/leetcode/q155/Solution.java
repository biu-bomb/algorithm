package com.godme.leetcode.q155;

import java.util.Deque;
import java.util.LinkedList;

// 思路: 最小值并非一成不变，固定范围内最小值相同
// 时间: O(1)
// 空间: O(n)
class MinStack {
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

class Entry{
    int value;
    int min;

    Entry(int value, int min){
        this.value = value;
        this.min = min;
    }
}
