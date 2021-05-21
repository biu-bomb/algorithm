package com.godme.leetcode.q1021;

// 思路: 检测计数，被包围直接添加，边界直接移除
// 时间: O(n)
// 空间: O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0, count; i < chars.length; i++){
            chars[i] = '0';
            count = 1;
            while(count > 0){
                count += chars[++i] == '(' ? 1 : -1;
                if(count == 0){
                    chars[i] = '0';
                }
            }
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != '0'){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}