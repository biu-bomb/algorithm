package com.godme.leetcode.q322;

import java.util.Arrays;

// 思路: 从小到达遍历硬币拼接可能，重复拼接取最小值，特殊大值标识无法拼接
// 时间: O(Sn) 每种金额每种面额双重循环
// 空间: O(S)  全是1，最多S
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 从小到达逐个拼接
        for (int i = 1; i < max; i++) {
            for (int coin : coins) {
                // 大硬币参与计算
                if(coin > i) continue;
                // 初始化采用大值标识无法拼接，重复拼接情况采取最小值
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
