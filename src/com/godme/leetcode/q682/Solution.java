package com.godme.leetcode.q682;

import java.util.Stack;
// 思路: 按照规矩操作，最后累加
// 时间: O(n)
// 空间: O(n)
class Solution {
    Stack<Integer> stack = new Stack<>();
    public int calPoints(String[] ops) {
        for(String op: ops) {
           operation(op);
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
    void operation(String op){
        switch(op){
            case "C":stack.pop(); break;
            case "D":stack.push(stack.peek() * 2);break;
            case "+":{
                int top = stack.pop();
                int sum = top + stack.peek();
                stack.push(top);
                stack.push(sum);
            }
            default:stack.push(Integer.parseInt(op));
        }
    }
}