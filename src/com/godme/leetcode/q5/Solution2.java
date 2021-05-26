package com.godme.leetcode.q5;

import java.util.Arrays;

// 思路: isPalindrome(s(x,y)) = s(x) == s(y) && isPalindrome(s(x+1, y-1))
//      x -> x+1，保证依赖，先大后小
//      y -> y-1，保证依赖，先小后大
// 时间: O(n ^ 2)
// 空间: O(n ^ 2)
class Solution2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 单字符回文
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }
        int res = 1, length, start = 0, end = 0;
        // 优先计算
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                if(dp[i][j]){
                    length = j - i + 1;
                    if(res < length){
                        res = length;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}