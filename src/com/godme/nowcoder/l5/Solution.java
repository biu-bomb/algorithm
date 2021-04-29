package com.godme.nowcoder.l5;


import java.util.Stack;

public class Solution {
    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        char current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if(current == '(' || current == '{' || current == '['){
                stack.push(current);
                continue;
            }
            if(stack.isEmpty() || !match(stack.peek(), current)){
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
    public boolean match(char a, char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a =='{' || b == '}');
    }

    public static void main(String[] args) {
        System.err.println(new Solution().isValid("()"));
    }
}