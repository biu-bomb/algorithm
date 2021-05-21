package com.godme.leetcode.q856;

// 思路: 解包 (()(())) == (()) ((()))
// 时间: O(n)
// 空间: O(1)
class Solution {
    public int scoreOfParentheses(String s) {
        char[] chs = s.toCharArray();
        int pow = -1, index = 0;
        int res = 0;
        while(index < chs.length){
            while(index < chs.length && chs[index] == '('){
                pow++;
                index++;
            }
            res += Math.pow(2, pow);
            while(index < chs.length && chs[index] == ')'){
                pow--;
                index++;
            }
        }
        return res;
    }
}