package com.godme.leetcode.q1019;


import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        for(ListNode cursor = head; cursor !=null; cursor = cursor.next){
            size += 1;
        }
        int[] nums = new int[size];
        int[] res = new int[size];
        for (int index = 0; index < size; index++, head = head.next){
            nums[index] = head.val;
        }
        Stack<Integer> stack = new Stack<>();
        //  数据分割: 1. 数组-数值 2. 栈-下标
        //  领域分割后可以单独管理
        for(int i = 0; i < size; i++){
            // 回填比当前数小的
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return nums;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
