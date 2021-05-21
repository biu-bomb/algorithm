package com.godme.leetcode.q503;

import java.util.Arrays;
import java.util.Stack;

// 思路: 单调栈，大于出栈，小于入栈(index)
// 时间: O(n)
// 空间: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length, index;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < length * 2 - 1; i++){
            index = i % length;
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                    res[stack.pop()] = nums[index];
                }
            }
            stack.push(index);
        }
        return res;
    }
}