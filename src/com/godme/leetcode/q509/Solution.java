package com.godme.leetcode.q509;

class Solution {
    public int fib(int n) {
        if( n < 2) return n;
        int last = 1, lastBefore = 0, temp;
        while(n-->1){
            temp = last;
            last += lastBefore;
            lastBefore = temp;
        }
        return last;
    }
}