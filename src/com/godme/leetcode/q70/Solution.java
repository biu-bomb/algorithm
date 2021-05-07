package com.godme.leetcode.q70;

class Solution {

    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        for(int index = 2; index <= n; index++){
            cache[index] = cache[index-1] + cache[index-2];
        }
        return cache[n];
    }
}