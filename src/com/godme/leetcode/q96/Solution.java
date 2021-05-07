package com.godme.leetcode.q96;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    {
        cache.put(0, 1);
        cache.put(1, 1);
    }
    // 只和数量相关，重复计算使用缓存
    public int numTrees(int n) {
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int sum = 0;
        for(int i = 1; i <=n; i++){
            sum += numTrees(i-1) * numTrees(n - i);
        }
        cache.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.numTrees(2));
    }
}