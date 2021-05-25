package com.godme.leetcode.q152;

/**
 * 依赖传递: 结果依赖单层传递，摒弃多分支计算，转换为单层计算
 */

// 思路:
//      1. 最大值有三种可能: current, current * max, current * min
//      2. 正数的最大值积累存在中断，但是负数最小值可能跳变，最小值也需要维护
// 时间: O(n)
// 空间: O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        int prev_max, prev_min;
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            prev_max = max;
            prev_min = min;
            max = Math.max(prev_max * nums[i], Math.max(nums[i], prev_min * nums[i]));
            min = Math.min(prev_max * nums[i], Math.min(nums[i], prev_min * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}

