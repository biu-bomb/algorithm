package com.godme.leetcode.q309;


//      1. 持有
//          1.1 持续持有
//          1.2 昨日买入
//      2. 空闲
//          2.1 持续空闲
//          2.2 今日买入
// 思路:
//      1. 冷冻期无法买入股票，单一线性思考复杂
//      2. 拆分维度，多线性综合: a. 交易状态 b. 是否买卖
// 时间: O(n)
// 空间: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int lastHoldGain = -prices[0], currentHoldGain;
        int lastSaleGain = 0, currentSaleGain;
        int lastFreeGain = 0, currentFreeGain;
        for (int i = 1; i < prices.length; ++i) {
            // 1. 昨天持有收益 2. 今天买入收益 (3. 冷冻期不参与收益计算)
            currentHoldGain = Math.max(lastHoldGain, lastFreeGain - prices[i]);
            // 卖出收益
            currentSaleGain = lastHoldGain + prices[i];
            // 1. 早就卖出导致的空闲 2. 昨日卖出导致的空闲
            currentFreeGain = Math.max(lastSaleGain, lastFreeGain);

            lastHoldGain = currentHoldGain;
            lastSaleGain = currentSaleGain;
            lastFreeGain = currentFreeGain;
        }
        // 最后一天肯定卖出回本，关键是早就卖的还是当天卖的
        return Math.max(lastSaleGain, lastFreeGain);
    }
}