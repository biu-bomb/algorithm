package com.godme.leetcode.q62;

import java.util.Arrays;

// 思路: 无非两路: 从上到下，从左到右，当前的结果就是两路只和
// 时间: O(mn)
// 空间: O(mn)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        for(int y = 1; y < m; y++){
            for(int x = 1; x < n; x++){
                dp[y][x] = dp[y-1][x] + dp[y][x-1];
            }
        }
        return dp[m-1][n-1];
    }
}