package com.godme.leetcode.q20;

import java.util.Stack;

// 思路: 左边压栈，右边匹配；匹配弹栈，不匹配false；最后栈不为空true
// 时间: O(n)
// 空间: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(isLeft(ch)){
                stack.push(ch);
            } else {
                if(!stack.isEmpty() && match(stack.peek(), ch)){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    boolean isLeft(char ch){
        return ch == '(' || ch == '[' || ch == '{';
    }
    boolean match(char left, char right){
        switch (left){
            case '(': return right == ')';
            case '{': return right == '}';
            case '[': return right == ']';
        }
        return false;
    }
}