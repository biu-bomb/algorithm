package com.godme.leetcode.q1190;

import java.util.Stack;
// 思路: 使用数组，左右交换
// 时间:
// 空间: O(n)
class Solution {
    char[] arr;
    public String reverseParentheses(String s) {
        arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(i);
            }else if(arr[i] == ')'){
                dfs(stack.pop(), i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: arr){
            if(ch != '0'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public void dfs(int left, int right){
        arr[left] = '0';
        arr[right] = '0';
        while (left < right){
            swap(left++, right--);
        }
    }
    void swap(int a, int b){
        char ch = arr[a];
        arr[a] = arr[b];
        arr[b] = ch;
    }
}
