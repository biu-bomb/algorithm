package com.godme.leetcode.q32;

class Solution {
    // 基于简单匹配方式，不论是压栈还是计数，都面临不完全匹配的问题()(()
    // 核心在于单边的不完全匹配导致对于结果的计数错误，多或者少计具体看计数方式
    // 因此，通过正序+倒序的双重计数，来确定真实的匹配情况
    public int longestValidParentheses(String s) {
        return Math.max(orderMatch(s, true), orderMatch(s, false));
    }

    public int orderMatch(String s, boolean reverse){
        int series = 0;
        int maxIndex = s.length() - 1;
        // 边界设定
        for (int index = reverse?maxIndex:0,left = 0, right = 0; (reverse &&  index > -1) || (!reverse && index <= maxIndex); index += reverse ? -1 : 1) {
            if(s.charAt(index) == '('){
                left += 1;
            } else {
                right += 1;
            }
            // 相等时候需要比对最大值
            // 正序)为截断标记，以right为基准值
            // 倒序(为截断标记，以left为基准值
            if(left == right){
                series = Math.max(series,  2 * (reverse ? right : left));
            } else if((reverse && left > right) || (!reverse && right > left)){
                right = left = 0;
            }
        }
        return series;
    }
}
