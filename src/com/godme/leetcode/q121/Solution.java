package com.godme.leetcode.q121;

class Solution {
    // 漏洞：利润只来源于高峰和低估的差值，唯一受限的是顺序
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxEarn = 0;
        for (int price: prices){
            // 相同最小值，峰值更新
            maxEarn = Math.max(maxEarn, price - minPrice);
            // 更新最小值
            minPrice = Math.min(minPrice, price);
        }
        return maxEarn;
    }
}
