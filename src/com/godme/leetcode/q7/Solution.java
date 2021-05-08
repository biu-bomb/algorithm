package com.godme.leetcode.q7;

class Solution {

    int min = Integer.MIN_VALUE / 10;
    int max = Integer.MAX_VALUE / 10;
    public int reverse(int x) {
        int ans = 0;
        while (x > 0){
            // 边界
            if (ans < min || ans > max) return 0;
            ans = ans * 10 + (x % 10);
            x = x / 10;
        }
        return ans;
    }
}