package com.godme.leetcode.q1019;


import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {

        int size = 0;
        for(ListNode cursor = head; cursor!=null; cursor = cursor.next){
            size += 1;
        }
        int[] res = new int[size];
        int index = 0;
        while (head != null){
            res[index++] = head.val;
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < size; i++){
            if(!stack.isEmpty() && res[i] <= res[stack.peek()]){
                while (!stack.isEmpty() && res[i] > res[stack.peek()]){
                    res[stack.peek()] = res[i];
                    stack.pop();
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
