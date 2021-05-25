package com.godme.leetcode.q300;

/**
 * 关系降级: 连续关系尽量转变为层级计算依赖，将深度计算转为上一次结果或者边界的单层计算
 * 多重结果: 设置单独变量，重复比对覆盖，缩小变化因素
 * 全局极值: 核心方法为计算单次最大值，使用全局变量进行更新
 */

// 思路: 从左到右，计算下标的最大连续字符串；更新全局最大
// 时间: O(n^2) 当前需要检测之前全部数据
// 空间: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // 至少包含自身，长度为1
            // 检查之前数据，更新当前最大序列值
            for (int j = 0; j < i; j++) { // 对比之前全部序列
                if (nums[i] > nums[j]) { // 满足递增参与计算
                    // 因为存在多种序列方式，需要比对覆盖
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新全局最大序列
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
