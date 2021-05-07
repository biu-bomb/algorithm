package com.godme.leetcode.q232;

import java.util.Stack;

class MyQueue {

    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();
    public MyQueue() {}
    public void push(int x) {
        inStack.push(x);
    }
    public int pop() {
        adjust();
        return outStack.pop();
    }
    public int peek() {
        adjust();
        return outStack.peek();
    }
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    public void adjust(){
        if(outStack.isEmpty() && !inStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}
