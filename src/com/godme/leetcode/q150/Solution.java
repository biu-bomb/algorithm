package com.godme.leetcode.q150;

import java.util.Stack;

// 思路: 遇到数据压栈，遇到操作符计算
// 时间: O(n)
// 空间: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a,b,sum = 0;
        for(String s: tokens){
            if(Character.isDigit(s.charAt(0)) || s.length() > 1 && Character.isDigit(s.charAt(1))){
                sum = Integer.parseInt(s);
            }else{
                b = stack.pop();
                a = stack.pop();
                switch (s){
                    case "+": sum = a + b;break;
                    case "-": sum = a - b;break;
                    case "*": sum = a * b;break;
                    case "/": sum = a / b;break;
                }
            }
            stack.push(sum);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.err.println(new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
