package com.godme.leetcode.q69;

class Solution {
    public int mySqrt(int x) {
        return x < 2 ? x : (int) mySqrt(x, 1, x);
    }

    public long mySqrt(long target, long left, long right){
        if(right - left < 2 || left * left == target) return left;
        long mid = (left + right) / 2;
        long temp = mid * mid;
        if(temp == target) return mid;
        return temp < target ? mySqrt(target, mid, right) : mySqrt(target, left, mid);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.mySqrt(4));
    }
}