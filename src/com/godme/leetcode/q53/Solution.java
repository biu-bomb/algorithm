package com.godme.leetcode.q53;

class Solution {
    // 最大和：累计效用必须大于单独的值，否则直接重新计数
    public int maxSubArray(int[] nums) {
        int maxCurrentSum = 0, globalMaxSum = nums[0];
        for (int currentValue: nums){
            // 累计效用为负，直接重新计数
            maxCurrentSum = Math.max(maxCurrentSum + currentValue, currentValue);
            // 比较每次峰值
            globalMaxSum = Math.max(globalMaxSum, maxCurrentSum);
        }
        return globalMaxSum;
    }
}