package com.godme.leetcode.q5;

/**
 * 回文判断两种方法
 *      1. 中心收缩: 对比双端，然后中心收缩
 *      2. 中心扩展: 中心对比，逐渐两端扩张
 * 对于一般的回文字符串判断，中心收缩的方式是最为方便的。
 * 但是在非一次性判断的情况下，中心扩展的方式可以复用已经判断的字符串，效率较高
 * 同时，为了保证中心字符串的先行计算(x,y)->(x+1, y-1)，更好的方式是变长+，而非两端遍历导致中心字符串未计算
 */

// 思路: 遍历子串，更新回文串长度 isPalindrome(s(x,y)) = s(x) == s(y) && isPalindrome(s(x+1, y-1))
// 时间: O(n ^ 2)
// 空间: O(n ^ 2)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length+1];
        int maxLength = 1, startIndex = 0;
        for(int subLength = 0; subLength < length; subLength++){
            for(int start = 0; start < length - subLength; start++){
                int end = start + subLength;
                if(start == end || // 独立成文
                        subLength == 0 || s.charAt(start) == s.charAt(end) && // 首尾相等的情况下
                        (start + 1 == end || dp[start+1][end-1])){ // 偶数情况不用中心收缩，否则中心收缩
                    dp[start][end] = true;
                    if(maxLength < subLength + 1){
                        maxLength = subLength + 1;
                        startIndex = start;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}