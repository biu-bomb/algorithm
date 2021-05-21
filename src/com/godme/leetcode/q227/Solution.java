package com.godme.leetcode.q227;

import java.util.Stack;

class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int value = 0;
        char lastOp = '+';
        for(char ch: (s+"+").toCharArray()){
            if(ch == ' ') continue;;
            if(Character.isDigit(ch)){
                value = value * 10 + ch - '0';
            } else {
                switch (lastOp){
                    case '+': stack.push(value);break;
                    case '-': stack.push(-value);break;
                    case '*': stack.push(stack.pop()* value); break;
                    case '/': stack.push(stack.pop() / value); break;
                }
                value = 0;
                lastOp = ch;
            }
        }
        int sum = 0;
        while(stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
