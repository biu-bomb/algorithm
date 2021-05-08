package com.godme.leetcode.q746;

import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, cost.length);
    }

    public int minCostClimbingStairs(int[] cost, int target){
        if(cache.containsKey(target)) return cache.get(target);
        int a = cost[target-1] + minCostClimbingStairs(cost, target-1);
        int b = cost[target-2] + minCostClimbingStairs(cost, target-2);
        int res = Math.min(a, b);
        cache.put(target, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{10, 15, 20};
        System.err.println(solution.minCostClimbingStairs(arr));
    }
}