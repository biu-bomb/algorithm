package com.godme.leetcode.q1143;

/**
 * 逻辑抽象: 题中的计算约束，往往过于基本，需要抽象出流程，基于 流程+边界 计算结果
 * 继承变更: 无关层继承，相关层计算，传递链中构建单一层级依赖，每一层都是边界逻辑
 * 层级屏蔽: 层级结果传递产生细节屏蔽效果，本题中表现为乱序字符自动过滤
 */
// 思路: f(a[:i], b[:j]) = a[i] == b[j] ? f(a[:i-1],b[:j-1]) : max(f(a[:i-1], b[:j]), f(a:[:i], b[:j-1]))
//      1. 末尾相等，累计结果+1
//      2. 结尾不等，a查b 和 b查a 的最大值
// 时间: O(mn)    互查
// 空间: O(mn)    记录
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = text1.charAt(i-1) == text2.charAt(j-1) ?
                        dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
