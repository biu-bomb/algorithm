package com.godme.leetcode.q739;

import java.util.Stack;

// 思路: 温度低入栈，温度高出栈
// 时间: O(n)
// 空间: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < res.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
